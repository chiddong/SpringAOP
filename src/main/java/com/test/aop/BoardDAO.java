package com.test.aop;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSessionTemplate template;

	public int add(BoardDTO dto) {

		return template.insert("board.add", dto);
	}

	public List<BoardDTO> list() {
		
		return template.selectList("board.list");
	}

	public BoardDTO get(String seq) {
		
		return template.selectOne("board.get", seq);
	}

	public int del(String seq) {

		return template.delete("board.del", seq);
	}
	
}
