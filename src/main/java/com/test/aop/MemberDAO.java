package com.test.aop;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate template;

	public MemberDTO auth(String id) {
		
		return template.selectOne("member.auth", id);
	}

	public List<LogDTO> log() {

		return template.selectList("member.log");
	}
	
}
