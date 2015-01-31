/**
 * 
 */
package com.telapp.rs;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author rajunair
 *
 */
public class UserRegImpl implements UserRegistration{
	
	private static Map<Long,User> map =
				new Hashtable<Long,User>();

	private static Long id =0L;

	public String addUser(User user) {
		
		
		System.out.println("executing the user "+user);
		map.put(++id, user);
		return ""+id;
	}


	public User getUser(Long id) {
	
		return map.get(id);
	}

}
