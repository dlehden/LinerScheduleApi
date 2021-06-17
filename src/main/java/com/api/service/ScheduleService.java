package com.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.entity.ScheduleEntity;
import com.api.repository.ScheduleRepository;

@Service
public class ScheduleService {

	ScheduleRepository scheduleRepository;
	public ScheduleService(ScheduleRepository scheduleRepository) {
		this.scheduleRepository = scheduleRepository;
	}
	
	
	public List<ScheduleEntity>findAll(){
		List<ScheduleEntity> scheduleAll = new ArrayList<>();
		//scheduleAll = scheduleRepository.findAll();
		scheduleRepository.findAll().forEach(e->scheduleAll.add(e));
		return scheduleAll;
	}

}
