package vnua.fita.bookstore.formbean;

import java.util.ArrayList;
import java.util.List;

public class LoginForm {
	private String username;
	private String password;
	

	public LoginForm(String username, String password) {
		this.username = username;
        this.password = password;
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

	public List<String> validate() {
        List<String> errors = new ArrayList<>();

        // Kiểm tra tính hợp lệ của dữ liệu và thêm lỗi vào danh sách nếu cần
        if (username == null || username.trim().isEmpty()) {
            errors.add("Username is required.");
        }

        System.out.println("pass: "+password);
        if (password == null || password.trim().isEmpty()) {
            errors.add("Password is required.");
        }

        // Các kiểm tra khác có thể được thêm vào tùy thuộc vào yêu cầu của bạn

        return errors;
    }
}
