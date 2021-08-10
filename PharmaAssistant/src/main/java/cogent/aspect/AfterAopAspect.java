package cogent.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect @Configuration
public class AfterAopAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@After(value = "cogent.aspect.CommonJoinPointConfig.controllerLayerExecution() ||"
				 + "cogent.aspect.CommonJoinPointConfig.serviceLayerExecution()")
	public void after(JoinPoint joinPoint) {
		logger.info("after execution of {}", joinPoint.getArgs()[0]);
	}

}
