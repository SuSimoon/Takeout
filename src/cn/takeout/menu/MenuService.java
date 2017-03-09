package cn.takeout.menu;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class MenuService {
	private MenuDao menuDao;

	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	public List<Menu> findAll() {
		return menuDao.findAll();
	}
	
}
