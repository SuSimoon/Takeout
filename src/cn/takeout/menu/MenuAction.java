package cn.takeout.menu;

import com.opensymphony.xwork2.ActionSupport;

public class MenuAction extends ActionSupport {
	private MenuService menuService;

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	//显示菜单
	public String index() {
		return "indexMenu";
	}
	
}
