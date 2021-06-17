package com.api.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.api.entity.ScheduleEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleDto {
	@Autowired
	ModelMapper modelMapper;
	private String VESSEL_CODE;
	private String VESSEL_NAME;
	private String LD_PORT;
	private String DC_PORT;
	private String ETD;
	private String ETA;
	
	
	public ScheduleDto convertToDto(ScheduleEntity scheduleEntity) {
		ScheduleDto scheduleDto = modelMapper.map(scheduleEntity, ScheduleDto.class);
	    scheduleDto.setVESSEL_CODE("CODE");
	    scheduleDto.setVESSEL_NAME("NAME");
	    return scheduleDto;
	}
	
}
