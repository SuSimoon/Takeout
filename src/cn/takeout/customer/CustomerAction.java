package cn.takeout.customer;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import cn.takeout.utils.CookieUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	private boolean autoLogin;  
	private String repassword;
	
	public boolean isAutoLogin() {
		return autoLogin;
	}
	public void setAutoLogin(boolean autoLogin) {
		this.autoLogin = autoLogin;
	}
	
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	@Autowired
	@Qualifier("customerService")
	private CustomerService customerService;

	//参数获取设置
	private Customer customer = new Customer();
	@Override
	public Customer getModel() {
		return customer;
	}
	
	//跳转注册页面
	public String signupPage() {
		return "signupPage";
	}
	//用户注册
	public String signup() {
		//验证邮箱是否已经注册过
		Customer existCustomer = customerService.findByEmail(customer.getEmail());
		if(existCustomer == null){
			customerService.signup(customer);
			this.addActionMessage("注册成功，请去邮箱激活！");
			return "MessagePage";
		} else {
			this.addActionError("该邮箱已注册！");
			return "input";
		}
	}
	//用户激活
	public String active() {
		// 根据激活码查询到这个用户
		Customer existCustomer = customerService.findByCode(customer.getCode());
		if(existCustomer != null){
			// 根据激活码查询到这个用户.
			existCustomer.setState(1);
			// 修改用户的状态
			customerService.update(existCustomer);
			// 添加信息:
			this.addActionMessage("激活成功!请去登录!");
			return "MessagePage";
		}else{
			this.addActionMessage("激活失败!激活码有误!");
			return "MessagePage";
		}
	}
	//跳转用户登录页面
	public String loginPage() {
		return "loginPage";
	}
	//用户登录
	public String login() {
		Customer existCustomer = customerService.login(customer);
		if(existCustomer == null) {
			//登录失败
			this.addActionError("邮箱或密码错误，或用户未激活!");
			return "loginFail";
		} else {
			// 判断是否要添加到cookie中 
            if (autoLogin) {  
            	List<Cookie> cookieList = CookieUtils.addCookie(existCustomer);  
            	for (Cookie cookie : cookieList) {  
            		ServletActionContext.getResponse().addCookie(cookie);  
                } 
            }  
            ServletActionContext.getRequest().getSession().setAttribute("existCustomer", existCustomer);
			return "index";
		}
	}
	//跳转找回密码页面
	public String getBackPwdPage() {
		return "getBackPwdPage";
	}
	
    //找回密码
	public String getBackPwd() {
		Customer existCustomer = customerService.findByEmail(customer.getEmail());
		if(existCustomer != null){
			//找回密码
			customerService.getBackPwd(customer.getEmail());
			// 添加信息
			this.addActionMessage("请前往邮箱修改密码");
			return "MessagePage";
		}else{
			this.addActionMessage("密保邮箱不存在，请重新输入");
			return "getBackPwdPage";
		}
	}
	
	//邮箱跳转重置密码页面
	public String updatePwdPage() {
		// 根据邮箱查询到这个用户
	    Customer existCustomer = customerService.findByEmail(customer.getEmail());
	    if(existCustomer != null){
	    	//验证code是否正确
	    	if(customer.getCode().equals(existCustomer.getCode())) {
	    		return "updatePwdPage";
	    	}
	    }
	    this.addActionMessage("密码修改链接失败!");
		return "MessagePage";
	}
	//重置密码
	public String updatePwd() {
		// 根据邮箱查询到这个用户
		Customer existCustomer = customerService.findByEmail(customer.getEmail());
		if(existCustomer != null){
			existCustomer.setPassword(customer.getPassword());
			// 修改用户的状态
			customerService.update(existCustomer);
			// 添加信息:
			this.addActionMessage("密码修改成功!请去登录!");
			return "MessagePage";
		}else{
			this.addActionMessage("密码修改失败!邮箱账号有误!");
			return "MessagePage";
		}
	}
	//用户退出
	public String logout() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("existCustomer", null);
		CookieUtils.delCookie(request);
		return "index";
	}
	

	
	
	
}






