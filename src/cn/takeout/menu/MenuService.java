package cn.takeout.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import cn.takeout.food.Food;

@Transactional
public class MenuService {
	@Autowired
	@Qualifier("menuDao")
	private MenuDao menuDao;

	
	
}
