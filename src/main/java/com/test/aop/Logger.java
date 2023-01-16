package com.test.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//보조 업무
@Aspect			//보조 업무 객체 자격 획득
@Component	//<bean> 선언과 동일
public class Logger {

	@Autowired
	private LogDAO dao;
	
	//주업무 지정 > 포인트 컷
//	@Pointcut("execution(public String com.test.aop.BoardController.list(org.springframework.ui.Model))")
//	public void pc1() {
//		
//	}
	
//	//보조 업무 생성 + 결합
//	@Before("pc1()")
//	public void m1() {
//		
//		System.out.println("보조 업무");
//	}
	
	//게시판
	@Pointcut("execution(public String com.test.aop.BoardController.*(..))")
	public void pc2() {
		
		
	}
	
	@After("pc2()")
	public void log(JoinPoint jp) {
		
		//현재 포인트컷에 해당하는 메소드의 매개변수들이 들어있다.
		HttpServletRequest req = (HttpServletRequest)jp.getArgs() [0];
		HttpSession session = (HttpSession)jp.getArgs() [1];
		
		if (session.getAttribute("auth") != null) {
		
			System.out.println(req.getRequestURI());
			System.out.println((String)session.getAttribute("auth"));
			
			//누가? 페이지? 언제?
			LogDTO dto = new LogDTO();
			
			dto.setId((String)session.getAttribute("auth"));
			dto.setUrl(req.getRequestURI());
			
			dao.log(dto);
			
			System.out.println("로그를 기록합니다.");
		}
	}
	
	
}
