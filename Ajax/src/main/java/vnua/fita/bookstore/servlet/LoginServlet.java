package vnua.fita.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vnua.fita.bookstore.formbean.*;
import vnua.fita.bookstore.utils.MyUtils;
import vnua.fita.bookstrore.bean.*;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/views/loginView.jsp");
		dispatcher.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// khác với page thì là điều hướng ko mang dư liêu theo thì dípatcher cũng là
		// điều hướng nhưng mang dữ liệu theo

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		// lấy dữ liệu của người dùng về băng cách su dung dôi tượng request
		String username = req.getParameter("userName");
		String password = req.getParameter("password");

		LoginForm loginForm = new LoginForm(username, password);
		List<String> errors = loginForm.validate();

		if (errors.isEmpty()) {
			// Tìm user trong DB, tạm thời tạo giả đối tượng trả về với quyền bằng 0 (quyền
			// khách hàng)

			User user = new User("ndnam", "123", 0);
			if (user == null) {
				errors.add("Sai thong tin tai khoan");
				}
			else {
			HttpSession session = req.getSession();
			MyUtils.storeLoginedUser(session, user);
			// Chuyển tiếp tới trang chủ máy khách hay quản trị tùy thuộc vào quyền của user

			// Nếu là khách hàng, chuyển tiếp đến trang clientHomeView.jsp
			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/views/helloUserName.jsp");
			dispatcher.forward(req, resp);
			}
//			req.setAttribute("userName", username);
//		
//		
//		if(username.equals("admin") && password.equals("123456")) {
//			req.getRequestDispatcher("/views/helloUserName.jsp").forward(req, resp);
//		}else {
//			req.getRequestDispatcher("/views/loginView.jsp").include(req, resp);
//		}
		}
		if (!errors.isEmpty()) {

			// Lưu các thông tin vào vùng nhớ request trước khi chuyển tieeps

			req.setAttribute("errors", String.join(", ", errors));
			req.setAttribute("loginForm", loginForm);
			// Chuyển tiếp tới trang /views/loginView.jsp
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/views/loginView.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
