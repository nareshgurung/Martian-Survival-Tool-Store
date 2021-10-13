package net.revature.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Pointcut("within(net.revature.service..*)")
	public void serviceLog() {}
	
	@Before(value="serviceLog()")
	public void logBeforeService(JoinPoint jp) {
		LOGGER.info("this final method with my userservice");
	}
	
	@After(value="serviceLog()")
	public void logAferService(JoinPoint jp) {
		LOGGER.info("after adive:");
	}
	
	@AfterReturning(value="serviceLog()", returning= "returnedusers")
	public void logAfterServiceReturn(JoinPoint jp, Object returnedusers) {
		LOGGER.info("afterreturning adive: the mathod has return " + returnedusers);
	}
	
	@AfterThrowing(value = "serviceLog()", throwing="thrownException")
	public void logAfterServiceException(JoinPoint jp, Exception thrownException) {
		LOGGER.info("afterthrowing advice: " + thrownException);
	}
}





