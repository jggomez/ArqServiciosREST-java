package co.gov.dane.framework.log;

import org.apache.log4j.Logger;
import javax.enterprise.inject.Produces;  
import javax.enterprise.inject.spi.InjectionPoint; 

public class LogFactory {
	
	@Produces
	Logger produceLogger(InjectionPoint injectionPoint ){
		return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}

}
