/**
 * 
 */
package com.telapp.rs;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author rajunair
 *
 */
@XmlRootElement(name = "User")
public class User {
	
	private int userId;
	private String userMsisdn;
	private String deviceid;
	private String operatotName;
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the userMsisdn
	 */
	public String getUserMsisdn() {
		return userMsisdn;
	}
	/**
	 * @param userMsisdn the userMsisdn to set
	 */
	public void setUserMsisdn(String userMsisdn) {
		this.userMsisdn = userMsisdn;
	}
	/**
	 * @return the deviceid
	 */
	public String getDeviceid() {
		return deviceid;
	}
	/**
	 * @param deviceid the deviceid to set
	 */
	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}
	/**
	 * @return the operatotName
	 */
	public String getOperatotName() {
		return operatotName;
	}
	/**
	 * @param operatotName the operatotName to set
	 */
	public void setOperatotName(String operatotName) {
		this.operatotName = operatotName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userMsisdn=" + userMsisdn
				+ ", deviceid=" + deviceid + ", operatotName=" + operatotName
				+ "]";
	}
	
	

}
