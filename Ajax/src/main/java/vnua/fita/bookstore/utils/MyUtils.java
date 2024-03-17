package vnua.fita.bookstore.utils;

import javax.servlet.http.HttpSession;

import vnua.fita.bookstrore.bean.User;

public class MyUtils {

    // Lưu thông tin user vào session
    public static void storeLoginedUser(HttpSession session, User loginedUser) {
        // Lưu user vào session
        session.setAttribute("loginedUser", loginedUser);
    }

   
}