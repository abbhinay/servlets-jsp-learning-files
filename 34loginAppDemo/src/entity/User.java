package entity;

public class User {

	String name,mail,password;

	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, String mail, String password) {
		super();
		this.name = name;
		this.mail = mail;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
