package com.spring.example.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.spring.example.domain.BookingVO;
import com.spring.example.mapper.BookingMapper;
import com.spring.example.service.BookingService;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;


@Primary
@Service

@AllArgsConstructor
@Log4j
public class BookingServiceImpl implements BookingService{
	@Setter(onMethod_ = @Autowired) 
	private BookingMapper mapper;
	
	@Override
	public void booking(BookingVO booking) {
		log.info("booking");
		mapper.insert(booking);
	}

}
