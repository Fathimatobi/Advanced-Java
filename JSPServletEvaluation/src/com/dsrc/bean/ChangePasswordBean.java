package com.dsrc.bean;

public class ChangePasswordBean {
 private int id;
 private String pass;
 private String newpass;
 private String confirmpass;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public String getNewpass() {
	return newpass;
}
public void setNewpass(String newpass) {
	this.newpass = newpass;
}
public String getconfirmpass() {
	return confirmpass;
}
public void setConfirmpass(String confirmpass) {
	this.confirmpass = confirmpass;
}

}
