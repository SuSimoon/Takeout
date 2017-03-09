package cn.takeout.menu;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class MenuService {
	private MenuDao menuDao;

	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}
	
}
