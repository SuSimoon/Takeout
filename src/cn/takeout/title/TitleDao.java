package cn.takeout.title;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class TitleDao extends HibernateDaoSupport {

	public List<Title> findAll() {
		return this.getHibernateTemplate().find("from Title");
	}
	
}
