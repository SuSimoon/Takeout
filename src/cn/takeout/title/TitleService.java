package cn.takeout.title;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class TitleService {
	@Autowired
	@Qualifier("titleDao")
	private TitleDao titleDao;

	public List<Title> findAll() {
		return titleDao.findAll();
	}
}
