package cn.takeout.customer;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import cn.takeout.utils.MD5Utils;
import cn.takeout.utils.MailUtils;
import cn.takeout.utils.UUIDUtils;

@Transactional
public class CustomerService {
	@Autowired
	@Qualifier("customerDao")
	private CustomerDao customerDao;

	public void signup(Customer customer) {
		
		//保存用户
		customer.setState(0); //未激活
		String code = UUIDUtils.getUUID();
		customer.setCode(code);
		customer.setPassword(MD5Utils.md5(customer.getPassword()));
		customerDao.save(customer);
		//发送邮件
		try {
			MailUtils.sendMail(customer.getEmail(), code);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	//验证邮箱是否已经注册过
	public Customer findByEmail(String email) {
		return customerDao.findByEmail(email);
	}

	//用户激活
	public Customer findByCode(String code) {
		return customerDao.findByCode(code);
	}
	//激活成功后修改用户信息
	public void update(Customer existCustomer) {
		customerDao.update(existCustomer);
	}
	//用户登录
	public Customer login(Customer customer) {
		return customerDao.login(customer);
	}
	//修改密码
	public void getBackPwd(String email) {
		Customer c = customerDao.findByEmail(email);
		//发送邮件
		try {
			MailUtils.sendPwdMail(email,c.getCode());
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	
	
}
