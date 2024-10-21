package bean;

public class Login {
   private String name;
   private String mobile;
   private String email;
   private String address;
   private String password;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Login(String name, String mobile, String email, String address, String password) {
	super();
	this.name = name;
	this.mobile = mobile;
	this.email = email;
	this.address = address;
	this.password = password;
}
public Login() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Login [name=" + name + ", mobile=" + mobile + ", email=" + email + ", address=" + address + ", password="
			+ password + "]";
}
   
}
