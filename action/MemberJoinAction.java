package action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.MemberJoinService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberJoinAction implements Action{
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 	
		 	MemberBean member=new MemberBean();
	   		boolean joinResult=false;
	   		
//	   		member.setUSER_NUM(Integer.parseInt(request.getParameter("USER_NUM")));
	   		member.setID(request.getParameter("ID"));
	   		member.setPASSWD(request.getParameter("PASSWD"));
	   		member.setNAME(request.getParameter("NAME"));
	   		member.setNICKNAME(request.getParameter("NICKNAME"));
	   		member.setPHONE(request.getParameter("PHONE"));
	   		member.setBIRTH(request.getParameter("BIRTH"));
	   		member.setEMAIL(request.getParameter("EMAIL"));
	   		member.setADDRESS(request.getParameter("ADDRESS"));
	   		member.setGENDER(request.getParameter("GENDER"));
	   		
	   		MemberJoinService memberJoinService = new MemberJoinService();
	   		joinResult=memberJoinService.joinMember(member);
	   		
	   		ActionForward forward = null;
	   		if(joinResult==false){
	   			response.setContentType("text/html;charset=UTF-8");
	   			PrintWriter out = response.getWriter();
	   			out.println("<script>");
	   			out.println("alert('회원등록실패')");
	   			out.println("history.back()");
	   			out.println("</script>");
		   	}
	   		else{
	   	    forward = new ActionForward();
	   		forward.setRedirect(true);
	   		forward.setPath("./memberLogin.me");
	   		}
	   		return forward;
	}
}