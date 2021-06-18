package com.api.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import com.api.dto.ScheduleDto;
import com.api.exception.ScheduleLengthException;
import com.api.service.ScheduleService;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class ScheduleController {
	@Autowired
	ModelMapper modelMapper;
	private final ScheduleService scheduleService;

	public ScheduleController(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}

	@RequestMapping("/api/{yyyymm}/{ldport}/{dcport}")
	@ResponseBody
	public ResponseEntity<?> apiSchedule( @PathVariable("yyyymm")String yyyymm,
										  @PathVariable("ldport")String ldport,
										  @PathVariable("dcport")String dcport){
	   isCheckPathVariable(yyyymm,ldport,dcport);
	  
	   List<EntityModel<ScheduleDto>> scheduleDto = scheduleService.findAll();
	   CollectionModel<EntityModel<ScheduleDto>> model = CollectionModel.of(scheduleDto);
	   
	        model.add(linkTo(ScheduleController.class).withSelfRel());
	        model.add(Link.of("/docs/index.html#resources-data-group-list").withRel("profile"));
	   
	   return ResponseEntity.ok().body(model);
			 
	}

    public void isCheckPathVariable(String yyyymm,String ldport,String dcport) {
    	/*
    	 *   yyyymm :
    	 *             *오늘 기준 날짜에서 +-1 월까지 허용 
    	 *             *null 안됨 
    	 *             *숫자입력 특수문자 오류 공백제거
    	 *             *5자리 체크 
    	 *   ldport, dcport 
    	 *             *null체크
    	 *             *코드5자리 체크
    	 *             *숫자 안됨 공백제거 특수문자 오류
    	 *             *DB에 코드 존재 확인 유무
    	 */
    	 if(yyyymm.length()!=6)   throw new ScheduleLengthException("DATE",yyyymm); 
    	 if(ldport.length()!=5)   throw new ScheduleLengthException("LDPORT",ldport); 
    	 if(dcport.length()!=5)   throw new ScheduleLengthException("DCPORT",dcport); 
    	 
    	
    }
}
