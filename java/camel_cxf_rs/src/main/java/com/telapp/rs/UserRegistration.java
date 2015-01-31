/**
 * 
 */
package com.telapp.rs;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * @author rajunair
 *
 */
@WebService
@Path("/userservice/")
@Consumes("text/xml")
@Produces("text/xml")
public interface UserRegistration {
	
	@POST
	@Path("/user")
	public String addUser(@WebParam(name = "user") User user);
	
	 @WebMethod
	 @GET
	 @Path("/{id}")
	 @Consumes("*/*")
	public User getUser(@PathParam("id") @WebParam(name = "id") Long id);

}
