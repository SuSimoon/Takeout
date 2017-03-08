package cn.takeout.customer;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.takeout.utils.MD5Utils;
 
public class CustomerDao extends HibernateDaoSupport {
	//保存用户注册信息
	public void save(Customer customer) {
		this.getHibernateTemplate().save(customer);
		
	}
	//验证邮箱是否已经注册过
	public Customer findByEmail(String email) {
		List<Customer> list = this.getHibernateTemplate().find("from Customer where email = ?",email);
		if(list.size()!=0){
			return list.get(0);
		}
		return null;
	}
		
	//根据激活码查找用户
	public Customer findByCode(String code) {
		List<Customer> list = this.getHibernateTemplate().find("from Customer where code = ?",code);
		if(list.size()!=0){
			return list.get(0);
		}
		return null;
	}
	//激活成功后修改用户信息
	public void update(Customer existCustomer) {
		this.getHibernateTemplate().update(existCustomer);
	}
	//登录
	public Customer login(Customer customer) {
		List<Customer> list = this.getHibernateTemplate().
				find("from Customer where email=? and password=? and state=?",
						customer.getEmail(),MD5Utils.md5(customer.getPassword()),1);
		if(list.size()!=0) {
			return list.get(0);
		}
		return null;
	}
	
	//
	public Customer checkAutoLogin(Customer customer) {
		List<Customer> list = this.getHibernateTemplate().
				find("from Customer where email=? and password=?",
						customer.getEmail(),customer.getPassword());
		if(list.size()!=0) {
			return list.get(0);
		}
		return null;
	}
	
	
	
	
	
	
	
	
}
