/**
 * 
 */
package com.telapp;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.FileRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.resource.URIResolver;
import org.junit.Test;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author rajunair
 *
 */
public class UserTest extends CamelSpringTestSupport {

	
	 @Override
	    protected AbstractXmlApplicationContext createApplicationContext() {
	        return new ClassPathXmlApplicationContext("META-INF/spring/camel-user-route.xml");
	    }
	 
	 

	    @Test
	    public void testOrderOk() throws Exception {
	      
	    	sendRestRequest();
	      	        
	    }
	    
	 private void sendRestRequest() throws IOException{   
	    System.out.println("\n");
        System.out.println("Sent HTTP POST request to add customer");
       
       // Client client = new Client();
        
       String inputFile = this.getClass().getResource("/add_user.xml").getFile();
       System.out.println(" input file : "+inputFile);
       
       URIResolver resolver = new URIResolver(inputFile);
       File input = new File(resolver.getURI());
        PostMethod post = new PostMethod("http://localhost:9001/rst/userservice/user");
        post.addRequestHeader("Accept" , "text/xml");
        
        RequestEntity entity = new FileRequestEntity(input, "text/xml; charset=ISO-8859-1");
        post.setRequestEntity(entity);
        HttpClient httpclient = new HttpClient();

        try {
            int result = httpclient.executeMethod(post);
            System.out.println("Response status code: " + result);
            System.out.println("Response body: ");
            System.out.println(post.getResponseBodyAsString());
        } finally {
            // Release current connection to the connection pool once you are
            // done
            post.releaseConnection();
        }

        System.out.println("\n");
        //System.exit(0);
    }

    private static String getStringFromInputStream(InputStream in) throws Exception {
        CachedOutputStream bos = new CachedOutputStream();
        IOUtils.copy(in, bos);
        in.close();
        bos.close();
        return bos.getOut().toString();
    }

	    
	   
}
