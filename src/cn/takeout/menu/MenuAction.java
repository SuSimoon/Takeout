package cn.takeout.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import cn.takeout.food.Food;

import com.opensymphony.xwork2.ActionSupport;

public class MenuAction extends ActionSupport {
	@Autowired
	@Qualifier("menuService")
	private MenuService menuService;
	
	
	
}
