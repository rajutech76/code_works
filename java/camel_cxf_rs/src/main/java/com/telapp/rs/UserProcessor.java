/**
 * 
 */
package com.telapp.rs;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author rajunair
 *
 */
public class UserProcessor implements Processor{

	
	private final static Logger log = LoggerFactory.getLogger(UserProcessor.class);
	
	
    private Class<?> beanClass;
    private Object instance;
    
    public UserProcessor(Object obj) {
        beanClass = obj.getClass();
        instance = obj;
    }
     
    public void process(Exchange exchange) throws Exception {
        String operationName = exchange.getIn().getHeader(CxfConstants.OPERATION_NAME, String.class);
        Method method = findMethod(operationName, exchange.getIn().getBody(Object[].class));
        try {
            Object response = method.invoke(instance, exchange.getIn().getBody(Object[].class));
            exchange.getOut().setBody(response);
        }  catch (InvocationTargetException e) {
            throw (Exception)e.getCause();
        }
    }
    
    private Method findMethod(String operationName, Object[] parameters) throws SecurityException, NoSuchMethodException {            
        return beanClass.getMethod(operationName, getParameterTypes(parameters));
    }
    private Class<?>[] getParameterTypes(Object[] parameters) {
        if (parameters == null) {
            return new Class[0];
        }
        Class<?>[] answer = new Class[parameters.length];
        int i = 0;
        for (Object object : parameters) {
            answer[i] = object.getClass();
            i++;
        }
        return answer;
    }

}
