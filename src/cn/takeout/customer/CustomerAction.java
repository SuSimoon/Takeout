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
		customerService.signup(customer);
		this.addActionMessage("注册成功，请去邮箱激活！");
		return "signupSuccuess";
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
			return "signupSuccuess";
		}else{
			this.addActionMessage("激活失败!激活码有误!");
			return "signupSuccuess";
		}
	}
	
	
	
}
