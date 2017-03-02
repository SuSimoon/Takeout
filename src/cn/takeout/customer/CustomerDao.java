package cn.takeout.customer;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CustomerDao extends HibernateDaoSupport {
	//保存用户注册信息
	public void save(Customer customer) {
		this.getHibernateTemplate().save(customer);
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
	
}
