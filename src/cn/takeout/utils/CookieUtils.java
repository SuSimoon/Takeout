package cn.takeout.utils;
import javax.servlet.http.Cookie;

import cn.takeout.customer.Customer;

public class CookieUtils {
	 public static final String CUSTOMER_COOKIE = "customer.cookie";
	// 添加一个cookie  
    public static Cookie addCookie(Customer customer) {  
        Cookie cookie = new Cookie(CUSTOMER_COOKIE, customer.getEmail() + ","  
                + customer.getPassword());  
        cookie.setMaxAge(60 * 60 * 24 * 14);// cookie保存两周  
        return cookie;  
    }  
    
	public static Cookie findCookieByName(Cookie[] cs, String name) {
		if (cs == null || cs.length == 0) {
			return null;
		}
		for (Cookie c : cs) {
			if (c.getName().equals(name)) {
				return c;
			}
		}
		return null;
	}
}