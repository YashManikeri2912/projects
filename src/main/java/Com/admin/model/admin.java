package Com.admin.model;

public class admin {
private int a_id;
private String name;
private String address;
private long phone;
private String 	email;
private String password;
public admin() {
	
}
public admin(int a_id, String name, String address, long phone, String email, String password) {
	super();
	this.a_id = a_id;
	this.name = name;
	this.address = address;
	this.phone = phone;
	this.email = email;
	this.password = password;
}
public int getA_id() {
	return a_id;
}
public void setA_id(int a_id) {
	this.a_id = a_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
