package cn.takeout.intercepter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.takeout.customer.Customer;
import cn.takeout.customer.CustomerDao;
import cn.takeout.utils.CookieUtils;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class AutoLoginIntercepter extends MethodFilterInterceptor {
	
	private CustomerDao customerDao;
	
	

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}



	@Override
	protected String doIntercept(ActionInvocation ai) throws Exception {
		 Cookie [] cs = ServletActionContext.getRequest().getCookies();
		 Cookie cookieE = CookieUtils.findCookieByName(cs, "email");
		 Cookie cookieP = CookieUtils.findCookieByName(cs, "password");
		 if(cookieE!=null && cookieP!=null) {
			 Customer c = new Customer();
			 c.setEmail(cookieE.getValue());
			 c.setPassword(cookieP.getValue());
			 Customer existCustomer = customerDao.checkAutoLogin(c);
			 System.out.println(existCustomer);
			 if(existCustomer != null) {
				 ServletActionContext.getRequest().getSession().setAttribute("existCustomer", existCustomer);
				 return "index";
			 }
		 }
		return ai.invoke();
	}

}
