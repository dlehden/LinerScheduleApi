package com.api.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleNotFoundException extends RuntimeException {

	private String yyyymm;
	//private String ldport;
	//private String dcport;
	
	public ScheduleNotFoundException(String yyyymm) {
		this.yyyymm = yyyymm;
	}
}
