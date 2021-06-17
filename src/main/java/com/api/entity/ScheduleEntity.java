package com.api.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="schedule")
public class ScheduleEntity {
	@Id
	private String VESSEL_CODE;
	@Column(name="vessel_name")
	private String VESSEL_NAME;
	@Column(name="ld_port")
	private String LD_PORT;
	@Column(name="dc_port")
	private String DC_PORT;
	@Column(name="etd")
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm", timezone="Asia/Seoul")
	Date ETD;
	@Column(name="eta")
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm", timezone="Asia/Seoul")
	Date ETA;
}
