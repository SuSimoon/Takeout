package cn.takeout.food;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.takeout.customer.Customer;

public class FoodDao extends HibernateDaoSupport {

	public List<Food> findByMid(Integer mid) {
		List<Food> list = this.getHibernateTemplate().find("from Food where mid=?", mid);
		return list;
	}

	public Food findByFid(Integer fid) {
		
		List<Food> list = this.getHibernateTemplate().find("from Food where fid=?", fid);
		if(list.size()!=0){
			return list.get(0);
		}
		return null;
	}

}
