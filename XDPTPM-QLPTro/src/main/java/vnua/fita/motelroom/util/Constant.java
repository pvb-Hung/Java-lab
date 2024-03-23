package vnua.fita.motelroom.util;

public class Constant {
	
	public static final String INCORRECT_ACCOUNT_VALIDATE_MSG="Sai thông tin tài khoản"; 
	public static final byte ADMIN_ROLE=1; 
	public static final byte CUSTOMER_ROLE=2; 
	public static final String USERNAME_EMPTY_VALIDATE_MSG="Nhập username"; 
	public static final String PASSWORD_EMPTY_VALIDATE_MSG="Nhập password"; 
	public static final String LOGINED_USER="loginedUser";
	public static final String USERNAME_STORE_IN_COOKIE_OF_BOOKSTORE="username";
	public static final String TOKEN_STORE_IN_COOKIE_OF_BOOKSTORE="token";
	public static final String SECRET_STRING="SECRET_STRING";
	public static final String INSERT_BOOK_FAIL="Lỗi thêm mới sách";
	public static final String CASH_PAYMENT_MODE="cash";
	public static final String TRANSFER_PAYMENT_MODE="transfer";
	public static final byte WAITING_CONFIRM_ORDER_STATUS=1;
	public static final byte DELEVERING_ORDER_STATUS=2;
	public static final byte DELEVERED_ORDER_STATUS=3;
	public static final byte CANCEL_ORDER_STATUS=4;
	public static final byte REJECT_ORDER_STATUS=5;
	public static final byte NOT_AVAIABLE_ORDER_STATUS=6;
	public static final String WAITING_APPROVE_ACTION="waiting";
	public static final String DELEVERING_ACTION="delivering";
	public static final String DELEVERED_ACTION="delivered";
	public static final String REJECT_ACTION="reject";

}
