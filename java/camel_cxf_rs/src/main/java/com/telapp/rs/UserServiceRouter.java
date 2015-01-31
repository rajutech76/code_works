/**
 * 
 */
package com.telapp.rs;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author rajunair
 *
 */
public class UserServiceRouter extends RouteBuilder{
	
	private static final Log log = LogFactory.getLog(UserServiceRouter.class);

	@Override
	public void configure() throws Exception {
		log.info("Executing the method configure");
		
	    from("cxfrs:bean:rsServer").
	    process(new Processor() {
	    	public void process(Exchange exchange) throws Exception {
	    		}
	    		})
	    		.setBody(constant("SUCCESS"));
		
		log.info("Finished executing the method configure");
		
	}

}
