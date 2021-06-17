package com.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dto.ScheduleDto;
import com.api.entity.ScheduleEntity;
import com.api.repository.ScheduleRepository;

@Service
public class ScheduleService {
	@Autowired
	ModelMapper modelMapper;
	ScheduleRepository scheduleRepository;
	public ScheduleService(ScheduleRepository scheduleRepository) {
		this.scheduleRepository = scheduleRepository;
	}
	
	
	public List<ScheduleDto>findAll(){
        //Entity로 데이터를 1차 추출   
		List<ScheduleEntity> scheduleAll = new ArrayList<>();
		scheduleRepository.findAll().forEach(e->scheduleAll.add(e));
		//Entity to Dto로 변환하기위해서 modelMapper 사용처리 
	    List<ScheduleDto> scheduleDto = scheduleAll.stream()
                   .map(e->modelMapper.map(e,ScheduleDto.class))
                   .collect(Collectors.toList());
		
		   return scheduleDto;
	}

}
