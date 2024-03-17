package vnua.fita.bookstore.bean;

public class User {
	private String username;
	private String password;
	private String fullname;
	private int role;
	
	public User(String username, String password,String fullname, int role) {
		this.username = username;
		this.password = password;
		this.fullname=fullname;
		this.role = role;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
}
