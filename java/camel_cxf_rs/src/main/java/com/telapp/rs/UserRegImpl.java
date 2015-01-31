/**
 * 
 */
package com.telapp.rs;

import java.util.Hashtable;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author rajunair
 *
 */
public class UserRegImpl implements UserRegistration{
	
	private static Map<Long,User> map =
				new Hashtable<Long,User>();
	
	private final static Logger log = LoggerFactory.getLogger(UserRegImpl.class);

	private static Long id =0L;

	public String addUser(User user) {
		
		
		log.info("Executing the user "+user);
		map.put(++id, user);
		System.out.println(map);
		return "user id: "+id;
	}


	public User getUser(Long id) {
	
		return map.get(id);
	}

}
