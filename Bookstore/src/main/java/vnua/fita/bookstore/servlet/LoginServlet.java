package vnua.fita.bookstore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vnua.fita.bookstore.bean.User;
import vnua.fita.bookstore.formbean.LoginForm;
import vnua.fita.bookstore.model.UserDAO;
import vnua.fita.bookstore.util.MyUtil;

//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO=new UserDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = this.getServletContext()
				.getRequestDispatcher("/views/loginView.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		LoginForm loginForm = new LoginForm(username, password);

		// Kiểm tra tính hợp lệ của dữ liệu nhập vào
		List<String> errors = loginForm.validate();

		// Nếu không có lỗi validate
		if (errors.isEmpty()) {
			// Tìm user trong DB
			User user = userDAO.checkLogin(username, password);

			// Nếu sai thông tin trong db thì bổ sung vào danh sách lỗi
			if (user == null) {

				errors.add("Sai thong tin tai khoan");
			} else { // Đăng nhập thành công

				HttpSession session = request.getSession();
				MyUtil.storeLoginedUser(session, user);
				if (user.getRole() == 0) {

					RequestDispatcher rd = this.getServletContext()
							.getRequestDispatcher("/views/clientHomeView.jsp");
					rd.forward(request, response);
				} else if (user.getRole() == 1) {

//					RequestDispatcher rd = this.getServletContext()
//							.getRequestDispatcher("/views/adminHomeView.jsp");
//					rd.forward(request, response);
					response.sendRedirect(request.getContextPath()+"/adminHome");
				}
			}
		}

		if (!errors.isEmpty()) {
			request.setAttribute("errors", String.join(", ", errors));
			request.setAttribute("loginForm", loginForm);

			RequestDispatcher rd = this.getServletContext()
					.getRequestDispatcher("/views/loginView.jsp");
			rd.forward(request, response);
		}
	}

}
