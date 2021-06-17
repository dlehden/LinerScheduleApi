package com.api;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.api.component.DataSample;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class ScheduleapiApplication {
	public static void main(String[] args)throws Exception {
		SpringApplication.run(ScheduleapiApplication.class, args);
	}
}
