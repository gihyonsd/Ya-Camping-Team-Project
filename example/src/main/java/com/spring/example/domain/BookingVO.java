package com.spring.example.domain;






import java.util.Date;


import lombok.Data;

@Data
public class BookingVO {
	private String reservid;
	private String id;
	private int bno;
	private String faclt_nm;
	private Date reservday;
}
