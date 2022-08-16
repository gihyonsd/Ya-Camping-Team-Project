package com.spring.example.domain;






import java.util.Date;


import lombok.Data;

@Data
public class BookingVO {
	private int campnum;
	private int user_num;
	private String reservid;
	private String id;
	private String facltnm;
	private int audult_no;
	private int child_no;
	private Date reservday;
	private int price;
	private String startDate;
	private String endDate;
}
