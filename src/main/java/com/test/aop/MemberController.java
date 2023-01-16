package com.test.aop;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

	@Autowired
	private MemberDAO dao;
	
	@GetMapping(value="/member/login")
	public String login() {
		
		return "member.login";
	}
	
	@PostMapping(value="/member/loginok")
	public String loginok(String id, HttpSession session) {
		
		MemberDTO dto = dao.auth(id);
		
		if (dto != null) {
			//로그인 성공 > 인증 티켓 발급
			session.setAttribute("auth", id);
			session.setAttribute("name", dto.getName());
			session.setAttribute("lv", dto.getLv());
			
			return "redirect:/board/list";
			
		} else {
			//로그인 실패
			
			return "redirect:/member/login";
		}

	}
	
	@GetMapping(value="/member/logout")
	public String logout(HttpSession session) {
		
		session.removeAttribute("auth");
		session.removeAttribute("name");
		session.removeAttribute("lv");
		
		return "redirect:/member/login";
	}
	
	@GetMapping(value="/member/log")
	public String log(Model model) {
		
		List<LogDTO> list = dao.log();

		model.addAttribute("list", list);
		
		return "member.log";
	}
	
	
}











