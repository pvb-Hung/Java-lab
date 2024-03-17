package vnua.fita.bookstrore.bean;

public class User {
    private String username;
    private String password;
    private int role; // 0: khách hàng, 1: quản trị

    // Constructors, getters, and setters

    public User(String username, String password, int role) {
        this.username = username;
        this.password = password;
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

    // Các phương thức khác nếu cần
    
}
