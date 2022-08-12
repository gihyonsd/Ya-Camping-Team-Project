package com.spring.example.Login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.example.VO.MemberVO;
import com.spring.example.serviceImpl.MemberServiceImpl;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private MemberServiceImpl memberServiceImpl;

	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String LoginPage() {
		return "/common/LoginPage";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String joinPage() {
		return "/common/joinPage";
	}

	private boolean rememberId(boolean rememberId) {
		return rememberId;
	}

	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public String Login(@RequestParam("id") String id, @RequestParam("password") String password,
			HttpServletRequest request, HttpServletResponse response, boolean rememberId) throws Exception {

		String path = "";

		MemberVO vo = new MemberVO();

		if (rememberId(rememberId)) {
			Cookie cookie = new Cookie("id", id);
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}

		vo.setId(id);
		vo.setPassword(password);

		int result = memberServiceImpl.Login(vo);
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		session.setAttribute("password", password);

		if (result == 1) {
			path = "home";
		} else {
			path = "/common/LoginPage";
		}

		return path;

	}

	@RequestMapping(value = "/Logout", method = RequestMethod.GET)
	public String Logout(HttpServletRequest request) {

		HttpSession session = request.getSession();
		session.invalidate();
		String path = "";
		path = "home";
		return path;

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute MemberVO vo) throws Exception {

		int result = memberServiceImpl.idChk(vo);
		try {
			if (result == 1) {
				return "/common/joinPage";
			} else if (result == 0) {
				memberServiceImpl.register(vo);
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
		String path = "";
		path = "/common/LoginPage";
		return path;
	}

	// 아이디 중복 체크
	@ResponseBody
	@RequestMapping(value = "/idChk", method = RequestMethod.POST)
	public int idChk(MemberVO vo) throws Exception {
		int result = memberServiceImpl.idChk(vo);
		return result;
	}

	// 회원 탈퇴 get
	@RequestMapping(value = "/memberDeleteView", method = RequestMethod.GET)
	public String memberDeleteView() throws Exception {
		return "/memberDeleteView";
	}

	// 회원 탈퇴 post
	@RequestMapping(value = "/memberDelete", method = RequestMethod.POST)
	public String memberDelete(MemberVO vo, HttpSession session, RedirectAttributes rttr) throws Exception {

		// 세션에 있는 member를 가져와 member변수에 넣어줍니다.
		MemberVO member = (MemberVO) session.getAttribute("member");
		// 세션에있는 비밀번호
		String sessionPass = member.getPassword();
		// vo로 들어오는 비밀번호
		String voPass = vo.getPassword();

		if (!(sessionPass.equals(voPass))) {
			rttr.addFlashAttribute("msg", false);
			return "redirect:/memberDeleteView";
		}
		memberServiceImpl.memberDelete(vo);
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value="/memberUpdate", method = RequestMethod.GET)
	public String registerUpdateView() throws Exception{
		
		return "/memberUpdateView";
	}

	@RequestMapping(value="/memberUpdate", method = RequestMethod.POST)
	public String registerUpdate(MemberVO vo, HttpSession session) throws Exception{
		
		memberServiceImpl.memberUpdate(vo);
		
		session.invalidate();
		
		return "redirect:/";
	}
}