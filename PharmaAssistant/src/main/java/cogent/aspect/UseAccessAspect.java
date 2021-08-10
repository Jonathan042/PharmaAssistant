package cogent.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//AOP
//Configuration
@Aspect
@Configuration
public class UseAccessAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//What kind of method calls I would intercept
	//execution(* PACKAGE.*.*(..))
	
	//@Before("execution(* com.example.spring.aop.springaop.business.*.*(..))")
	
	@Before("cogent.aspect.CommonJoinPointConfig.controllerLayerExecution() ||"
			+ "cogent.aspect.CommonJoinPointConfig.serviceLayerExecution()")
	public void before(JoinPoint joinPoint){
		Object [] args=joinPoint.getArgs();
		logger.info("reading argument before method call: "+args[0]);
		
		
	}
}
