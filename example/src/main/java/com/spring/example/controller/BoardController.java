package com.spring.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.example.domain.BoardVO;
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
	@GetMapping("/get")
	public void get(@RequestParam("bno") int bno, Model model) {
		log.info("/get");
		model.addAttribute("board", service.get(bno));
	}
	
	
	@PostMapping("/booking")
	public String booking(BoardVO board, RedirectAttributes rttr) {
		log.info("booking: " + board);
		service.booking(board);
		rttr.addFlashAttribute("result", board.getBno());
		return "redirect:/board/list";
	}
}

