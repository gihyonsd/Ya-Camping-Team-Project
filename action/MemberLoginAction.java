package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.MemberLoginService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		HttpSession session = request.getSession();
		MemberBean member = new MemberBean();
		
		member.setID(request.getParameter("id"));
		member.setPASSWD(request.getParameter("passwd"));
		
		MemberLoginService memberLoginSerivice = new MemberLoginService();
		boolean loginResult = memberLoginSerivice.login(member);
		ActionForward forward = null;
		if(loginResult) {
			forward = new ActionForward();
			session.setAttribute("id", member.getID());
			forward.setRedirect(true);
			forward.setPath("./main.jsp"); // �α��� ���� �� ����Ȩ�������� ����
		} else {
			response.setContentType("text/html;charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('�α��� ����'); location.href='./memberLogin.me'; </script>");
		}
		return forward;
	}

}
