package cn.takeout.customer;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CustomerService {
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void signup(Customer customer) {
		//保存用户
		
		customerDao.signup(customer);
		//发送邮件
		
	}
	
}
