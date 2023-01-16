package com.test.aop;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

	@Autowired
	private BoardDAO dao;
	
	@GetMapping(value="/board/list")
	public String list(HttpServletRequest req, HttpSession session, HttpServletResponse resp, Model model) {
		
		List<BoardDTO> list = dao.list();
		
		model.addAttribute("list", list);
		
		return "board.list";
	}
	
	@GetMapping(value="/board/add")
	public String add(HttpServletRequest req, HttpSession session, HttpServletResponse resp) {
		
		return "board.add";
	}
	
	@PostMapping(value="/board/addok")
	public String addok(HttpServletRequest req, HttpSession session, HttpServletResponse resp, BoardDTO dto) {
		
		dto.setId((String)session.getAttribute("auth"));
		
		int result = dao.add(dto);
		
		if(result == 1) {
			return "redirect:/board/list";
		} else {
			return "redirect:/board/add";
		}
		
	}
	
	@GetMapping(value="/board/view")
	public String view(HttpServletRequest req, HttpSession session, HttpServletResponse resp, String seq, Model model) {
		
		BoardDTO dto = dao.get(seq);
		
		model.addAttribute("dto", dto);
		
		return "board.view";
	}
	
	@GetMapping(value="/board/del")
	public String del(HttpServletRequest req, HttpSession session, HttpServletResponse resp, String seq, Model model) {

		model.addAttribute("seq", seq);
		
		return "board.del";
	}
	
	@PostMapping(value="/board/delok")
	public String delok(HttpServletRequest req, HttpSession session, HttpServletResponse resp, String seq) {
		
		int result = dao.del(seq);
		
		if(result == 1) {
			return "redirect:/board/list";
		} else {
			return "redirect:/board/del";
		}
		
	}
	
	
}
