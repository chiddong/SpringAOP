package com.test.aop;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LogDAO {

	@Autowired
	private SqlSessionTemplate template;

	public void log(LogDTO dto) {
		
		template.insert("log.log", dto);
	}
	
}
