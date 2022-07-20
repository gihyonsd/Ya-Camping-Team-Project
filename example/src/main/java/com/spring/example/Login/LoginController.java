package com.spring.example.Login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    public String Login(@RequestParam("id") String id
                       , @RequestParam("password") String password, HttpServletRequest request) throws Exception {

        String path = "";

        MemberVO vo = new MemberVO();

        vo.setId(id);
        vo.setPassword(password);

        int result = memberServiceImpl.Login(vo);
        HttpSession session = request.getSession();
        session.setAttribute("id", id);
        session.setAttribute("password", password);

        if(result == 1) {
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

}