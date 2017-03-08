package cn.takeout.utils;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.takeout.customer.Customer;

public class CookieUtils {
	// 添加一个cookie  
    public static List<Cookie> addCookie(Customer customer) {  
        Cookie cookieE = new Cookie("email", customer.getEmail());  
        Cookie cookieP = new Cookie("password", customer.getPassword());  
        
        cookieE.setMaxAge(60 * 60 * 24 * 14);// cookie保存两周  
        cookieP.setMaxAge(60 * 60 * 24 * 14);// cookie保存两周  
        cookieE.setPath("/");  
        cookieP.setPath("/");
        List<Cookie> list = new ArrayList<Cookie>();  
        list.add(cookieE);  
        list.add(cookieP);
        return list;  
    }  
    // 按名称查找cookie 
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
	
	// 删除cookie  
    public static void delCookie(HttpServletRequest request) {  
    	Cookie [] cs = ServletActionContext.getRequest().getCookies();
    	Cookie cookieE = new Cookie("email",null);
    	System.out.println(cookieE.getValue());
    	cookieE.setMaxAge(0);
    	Cookie cookieP = new Cookie("password",null);
    	cookieP.setMaxAge(0);
    }  
}