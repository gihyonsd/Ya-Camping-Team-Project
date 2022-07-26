package com.spring.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


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
		model.addAttribute("list", service.getList(cri));
		
		int total = service.getTotal(cri);
		
		log.info("total : "+ total);
		
		model.addAttribute("pageMaker", new PageDTO(cri, total));
		return "/board/list";
	
	}
	
}

