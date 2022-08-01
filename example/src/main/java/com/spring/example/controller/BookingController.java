package com.spring.example.controller;

import java.text.DecimalFormat;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.spring.example.domain.BookingVO;
import com.spring.example.service.BookingService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
public class BookingController {
	
	private BookingService service;

	@PostMapping("/booking")
	public String booking(HttpSession session, BookingVO booking, RedirectAttributes rttr) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH));
		String ymd = ym + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		String sub = "";
		for(int i = 1; i <= 6; i++) {
			sub += (int)(Math.random() * 10);
		}
		String reservid = ymd + "-" + sub;
		booking.setReservid(reservid);
		String id = (String)session.getAttribute("id");
		booking.setId(id);
		service.booking(booking);
		rttr.addFlashAttribute("result", booking.getBno());
		return "/board/bookingConfirm";
	}
}

