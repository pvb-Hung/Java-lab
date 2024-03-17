package vnua.fita.bookstore.util;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import vnua.fita.bookstore.bean.Cart;
import vnua.fita.bookstore.bean.CartItem;
import vnua.fita.bookstore.bean.User;

public class MyUtil {
	public static void storeLoginedUser(HttpSession session, User loginedUser) {
		session.setAttribute("loginedUser", loginedUser);
		session.setAttribute("name", loginedUser.getFullname());
	}

	public static String getPathInfoFromServletPath(String path) {
	    if (path == null || path.isEmpty()) {
	        return ""; // Hoặc có thể ném một ngoại lệ
	    }

	    String[] result = path.split("/");
	    if (result.length == 0) {
	        return "";
	    }

	    return result[result.length - 1];
	}

	public static void storeCart(HttpSession session, Cart cart) {
		session.setAttribute(Constant.CART_OF_CUSTOMER, cart);
	}
	
	public static Cart getCartOfCustomer(HttpSession session) {
		Cart cartOfCustomer = (Cart)session.getAttribute(Constant.CART_OF_CUSTOMER);
		return cartOfCustomer;
	}
	
	public static void updateCartOfCustomer(HttpSession session, Map<Integer, CartItem> cartItemList) {
		Cart cartOfCustomer = getCartOfCustomer(session);
		cartOfCustomer.setCartItemList(cartItemList);
		session.setAttribute(Constant.CART_OF_CUSTOMER, cartOfCustomer);
	}
	
	public static void deleteCart(HttpSession session) {
		session.removeAttribute(Constant.CART_OF_CUSTOMER);
	}
	
	public static String getTimeLable() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy hh_mm");
		return sdf.format(new Date());
	}
	
	public static String createOfderNo(int orderId) {
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
		int code = orderId % 100;
		return sdf.format(new Date())+ code;
	}
	
	public static String extractFileExtension(Part part) {
		String contentDisp = part.getHeader("content-dispomsition");
		int indexOfDot = contentDisp.lastIndexOf(".");
		return contentDisp.substring(indexOfDot, contentDisp.length()-1);
	}
	
	public static File getFolderUpload(String appPath, String folderName) {
		File folderUpload = new File(appPath + File.separator + folderName);
		
		if(!folderUpload.exists()) {
			folderUpload.mkdir();
			
		}
		return folderUpload;
		
	}
	
	public static String convertDateToString(Date date) {
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"	);
		return sdf.format(date);
	}
}
