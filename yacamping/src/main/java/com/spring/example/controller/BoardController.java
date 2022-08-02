package com.spring.example.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.example.domain.BookingVO;
import com.spring.example.domain.Criteria;
import com.spring.example.domain.PageDTO;
import com.spring.example.service.BoardService;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	
	private BoardService service;
	
	@GetMapping("/list")
	public String list(Criteria cri,Model model) {
		
		log.info("list : "+ cri);
		Criteria setdate = new Criteria();
		setdate.setStartDate(cri.getStartDate());
		setdate.setEndDate(cri.getEndDate());
		model.addAttribute("setdate", setdate);
		model.addAttribute("list", service.getList(cri));
		
		int total = service.getTotal(cri);
		
		log.info("total : "+ total);
		
		model.addAttribute("pageMaker", new PageDTO(cri, total));
		return "/board/list";
		
	
	}
	@GetMapping("/get")
	public void get(Criteria cri, Model model) {
		log.info("/get");
		Criteria setdate = new Criteria();
		setdate.setStartDate(cri.getStartDate());
		setdate.setEndDate(cri.getEndDate());
		model.addAttribute("setdate", setdate);
		model.addAttribute("board", service.get(cri));
	}
	
}

