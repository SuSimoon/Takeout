package cn.takeout.intercepter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import cn.takeout.customer.Customer;
import cn.takeout.customer.CustomerDao;
import cn.takeout.utils.CookieUtils;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class AutoLoginIntercepter extends MethodFilterInterceptor {
	
	@Autowired
	@Qualifier("customerDao")
	private CustomerDao customerDao;

	@Override
	protected String doIntercept(ActionInvocation ai) throws Exception {
		 Cookie [] cs = ServletActionContext.getRequest().getCookies();
		 Cookie cookieE = CookieUtils.findCookieByName(cs, "email");
		 //System.out.println(cookieE.getValue());
		 Cookie cookieP = CookieUtils.findCookieByName(cs, "password");
		 if(cookieE!=null && cookieP!=null) {
			 Customer c = new Customer();
			 c.setEmail(cookieE.getValue());
			 c.setPassword(cookieP.getValue());
			 Customer existCustomer = customerDao.checkAutoLogin(c);
			 if(existCustomer != null) {
				 ServletActionContext.getRequest().getSession().setAttribute("existCustomer", existCustomer);
				 return "index";
			 }
		 }
		return ai.invoke();
	}

}
