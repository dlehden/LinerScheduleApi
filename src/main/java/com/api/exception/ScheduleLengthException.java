package com.api.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleLengthException extends RuntimeException {

	private String yyyymm;
	private String ldport;
	private String dcport;
	private String STATUS;
	private String ERRORVALUE;
	
	public  <T> ScheduleLengthException(String STATUS,T t1) {
		this.STATUS = STATUS;
		this.ERRORVALUE = t1.toString();
	}
	
	public  ScheduleLengthException(String STATUS,String ERRORVALUE) {
		this.STATUS = STATUS;
		this.ERRORVALUE =ERRORVALUE;
	}

}
