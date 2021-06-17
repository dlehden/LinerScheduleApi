package com.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleDto {
//	private String VESSEL_CODE;
//	private String VESSEL_NAME;
//	private String LD_PORT;
//	private String DC_PORT;
//	private String ETD;
	private String ETA;
	private String STATUS;
	
	public ScheduleDto() {
		
	}
	public String getSTATUS() {
		
		if(ETA.substring(0,4).equals("2021")) return "end";
		else return STATUS = "go";
	}
	

}
