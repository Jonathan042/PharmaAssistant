package cogent.aspect;


import org.aspectj.lang.annotation.Pointcut;



public class CommonJoinPointConfig {

	public CommonJoinPointConfig() {
		
	}
	@Pointcut("execution(* cogent.controller.*.*(..))")
	public void controllerLayerExecution(){
		//
	}
	
	@Pointcut("execution(* cogent.service.*.*(..))")
	public void serviceLayerExecution() {
		
	}

}
