package vnua.fita.bookstore.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vnua.fita.bookstore.bean.Book;
import vnua.fita.bookstore.bean.Cart;
import vnua.fita.bookstore.bean.CartItem;
import vnua.fita.bookstore.model.BookDAO;
import vnua.fita.bookstore.util.Constant;
import vnua.fita.bookstore.util.MyUtil;

public class CartServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private BookDAO bookDAO;
	
	public void init() {
		String jbdcURL = getServletContext().getInitParameter("");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		List<String> errors = new ArrayList<String>();
		
		String servletPath = req.getServletPath();
		String pathInfo = MyUtil.getPathInfoFromServletPath(servletPath);
		String bookIdStr = req.getParameter("bookId");
		String quantityPurchasedStr = req.getParameter("quantityPurchased");
		int bookId = -1;
		int quantityPurchased = -1;
		try {
			if (bookIdStr != null) {
				bookId = Integer.parseInt(bookIdStr);
			}
		} catch (NumberFormatException e) {
			// TODO: handle exception
			errors.add(Constant.BOOK_ID_INVALID_VALIDATE_MSG);
			
		}
		try {
			if(quantityPurchasedStr != null) {
				quantityPurchased = Integer.parseInt(quantityPurchasedStr);
				
			}
		} catch (NumberFormatException e) {
			// TODO: handle exception
			errors.contains(Constant.BOOK_QUANTITY_IN_STOCK_INVALID_VALIDATE_MSG);
		}
		Book selectedBook = bookDAO.getBook(bookId);
		if(errors.isEmpty()) {
			if(Constant.ADD_TO_CART_ACTION.equals(pathInfo)) {
				Cart cartOfCustomer = MyUtil.getCartOfCustomer(session);
				if(cartOfCustomer == null) {
					cartOfCustomer = new Cart();
				}
				cartOfCustomer.addCartItemToCart(bookId, new CartItem(selectedBook, quantityPurchased));
				MyUtil.storeCart(session, cartOfCustomer);
			}
		}
	}
}
