package com.test.aop;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Auth {
	
	@Autowired
	private BoardDAO dao;

	@Pointcut("execution(public String com.test.aop.BoardController.add*(..)) || execution(public String com.test.aop.BoardController.edit*(..)) || execution(public String com.test.aop.BoardController.del*(..))")
	public void pc1() {
		
	}
	
	@Pointcut("execution(public String com.test.aop.BoardController.del*(..))")
	public void pc2() {
		
	}
	

	@Before("pc1()")
	public void check(JoinPoint jp) {
		
		System.out.println("권한 확인");
		
		//로그인한 사람인지 확인?
		HttpSession session = (HttpSession)jp.getArgs()[1];
		HttpServletResponse resp = (HttpServletResponse)jp.getArgs() [2];
		
		//인증받지 못한 사람, 쫓아내야할 사람
		if (session.getAttribute("auth") == null) {
			try {
				resp.sendRedirect("/aop/member/login");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Before("pc2()")
	public void checkOwner(JoinPoint jp) {
		
		HttpSession session = (HttpSession)jp.getArgs()[1];
		HttpServletResponse resp = (HttpServletResponse)jp.getArgs() [2];		
		String seq = (String)jp.getArgs()[3];
		
		if (!dao.get(seq).getId().equals((String)session.getAttribute("auth"))) {
			try {
				resp.sendRedirect("/aop/board/view?seq=" + seq);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
}




