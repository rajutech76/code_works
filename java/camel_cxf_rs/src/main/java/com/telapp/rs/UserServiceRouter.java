/**
 * 
 */
package com.telapp.rs;

import org.apache.camel.builder.RouteBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author rajunair
 *
 */
public class UserServiceRouter extends RouteBuilder{
	
	private static final Log log = LogFactory.getLog(UserServiceRouter.class);
	
	private UserRegistration obj =null ;
	
	 
	
	public UserServiceRouter(UserRegistration obj){		
		this.obj =obj;
	}
	
	
	@Override
	public void configure() throws Exception {
		log.info("Executing the method configure");
		
		from("cxfrs:bean:rsServer?bindingStyle=SimpleConsumer")
		  .process(new UserProcessor(obj))
		  .to("log:TEST?showAll=true");
		  

		log.info("Finished executing the method configure");
		
	}

}
