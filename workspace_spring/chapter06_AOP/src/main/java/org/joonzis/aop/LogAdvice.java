package org.joonzis.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Log4j
@Component
@Aspect	// 해당 클래스 객체로 Aspect 를 구현함을 나타냄
public class LogAdvice {
	// log.info() 관심사를 구현한다.
	
	/*
	 *  Aspect 실행 심정을 지정할 수 있는 어노테이션
	 *  @Before : 어드바이스 타겟 메소드가 호출되기 전에 기능 수행
	 *  @After  : 타겟 메소드의 결과의 관계 없이(성공, 예외)
	 *  			타겟 메소드가 완료되면 어드바이스 기능 수행
	 *  @AfterReturing  :  타겟 메소드가 성공적으로 결과 값을 반환 한 후 어드바이스 기능 수행
	 *  @AfterThrowing  :  타겟 메소드가 수행중 예외를 던지면 어드바이스 기능 수행
	 *  @Around : 어드바이스가 타겟 메소드 호출 전과 후에 어드바이스 기능 수행
	 */
	
	@Before("execution(* org.joonzis.service.SampleService*.*(..))")
	public void logBefore() {
		log.info("=======================");
	}
	/*
	 * Advice와 관련된 어노테이션들은 내부적으로 pointcut을 지정한다.
	 * pointcut은 @pointcut으로 지정해서 사용할수 있음
	 * @Before 내부에 execution은 AspectJ의 표현식
	 * 맨 앞 *은 접근 제한자, 맨 뒤* 는 클래스의 이름과 메소드의 이름을 의미
	 */
	
	@Before("execution(* org.joonzis.service.SampleService*.doAdd(String, String)) && args(str1, str2)")
	public void logBeforeWithParam(String str1, String str2) {
		log.info("str1 : " + str1);
		log.info("str2 : " + str2);
	}
	
	@AfterThrowing(pointcut ="execution(* org.joonzis.service.SampleService*.*(..))" ,
			throwing = "exception")
	public void logException(Exception exception) {
		log.info("Exception");
		log.info("Exception : " + exception);
	}
	
	@Around("execution(* org.joonzis.service.SampleService*.*(..))")
	public Object logTime(ProceedingJoinPoint pip) {
		long start = System.currentTimeMillis();
		
		log.info("Target : " + pip.getTarget());
		log.info("param : " + Arrays.toString(pip.getArgs()));
		
		Object result = null;
		
		try {
			result = pip.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		log.info("Time : " + (end-start));
		return result;
		
	}
}
