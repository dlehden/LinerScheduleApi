package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.component.DataSample;
import com.api.entity.ScheduleEntity;
import com.api.service.ScheduleService;
/**
 *  @RequestParam
	http://localhost:8080?aaa=bbb&ccc=ddd
	변수에다가 aaa를 넘겨서 올때 
	@PathVariable
	http://localhost:8080/{bbb}/ddd
	url 주소에 넘겨서 올때 
 * 
 * @author drlee
 *
 */
@RestController
@RequestMapping("/v1/schedule/")
public class ScheduleController {
	@Autowired
	DataSample dataSample;
	
	ScheduleService scheduleService;
	public ScheduleController(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}

	@RequestMapping("/api/{yyyymm}")
	@ResponseBody
	public ResponseEntity<List<ScheduleEntity>> apiSchedule(@PathVariable("yyyymm") String yyyymm) {
		//dataSample.createTableAndData();
		System.out.println(yyyymm);
	
		return ResponseEntity.ok(scheduleService.findAll());
	}

}
