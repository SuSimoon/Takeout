package cn.takeout.customer;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	//注入ActionService
	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	//参数获取设置
	private Customer customer = new Customer();
	@Override
	public Customer getModel() {
		return customer;
	}
	//网站首页展示
	public String index() {
		return "index";
	}
	//跳转注册页面
	public String signupPage() {
		return "signupPage";
	}
	//用户注册
	public String signup() {
		//customerService.signup(customer);
		return "index";
	}
	
}
