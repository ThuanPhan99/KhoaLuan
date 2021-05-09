/*
 * @author THUAN-PHAN
 * @date May 27, 2020
 * @version 1.0
 */

package com.khosach.dto;

public class PasswordDTO {
	private String passwordOld;
	private String passwordNew;
	
	public String getPasswordOld() {
		return passwordOld;
	}
	public void setPasswordOld(String passwordOld) {
		this.passwordOld = passwordOld;
	}
	public String getPasswordNew() {
		return passwordNew;
	}
	public void setPasswordNew(String passwordNew) {
		this.passwordNew = passwordNew;
	}
}
