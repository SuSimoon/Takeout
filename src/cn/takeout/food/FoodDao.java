package cn.takeout.food;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class FoodDao extends HibernateDaoSupport {

	public List<Food> findByMid(Integer mid) {
		List<Food> list = this.getHibernateTemplate().find("from Food where mid=?", mid);
		return list;
	}

}
