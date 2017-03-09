package cn.takeout.menu;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MenuDao extends HibernateDaoSupport {

	public List<Menu> findAll() {
		return this.getHibernateTemplate().find("from Menu");
	}
	
}
