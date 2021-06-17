package com.api.component;

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
/**
 * @Component 를 사용하여 프로그램 실행 시
 * ApplicationRunner 주입하여  H2 에 연결된 Entity table
 * 에 값을 insert 하는 내용을 작성함.
 * @author drlee
 *
 */
@Component
public class DataSample implements ApplicationRunner { 
	@Autowired 
	DataSource dataSource;
	@Autowired 
	JdbcTemplate jdbcTemplate; 
	@Override 
	public void run(ApplicationArguments args) throws Exception { 
		try (Connection connection = dataSource.getConnection()) {
			System.out.println(connection.getMetaData().getURL());
			System.out.println(connection.getMetaData().getUserName()); 
			System.out.println(connection.getMetaData().allTablesAreSelectable());
			//Statement statement = connection.createStatement(); 
			//String sql = "CREATE TABLE USER (ID INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id))"; 
			//statement.executeUpdate(sql); } 
		   jdbcTemplate.execute("insert into schedule (vessel_code,vessel_name,etd,eta,ld_port,dc_port) values('code3','name','2021-10-10','2021-11-10','krpus','tbtbk')");
		   jdbcTemplate.execute("insert into schedule (vessel_code,vessel_name,etd,eta,ld_port,dc_port) values('code1','name','2021-10-10','2021-11-10','krpus','tbtbk')");
		}
	}
	
	//@Bean  //bean 주입시 컨테이너 위로 바로 올라가진다.
	public void createTableAndData() {
		jdbcTemplate.execute("insert into schedule (vessel_code,vessel_name,etd,eta,ld_port,dc_port) values('code3','name','2021-10-10','2021-11-10','krpus','tbtbk')");
		System.out.println("this page insert data sample");
	}

}
