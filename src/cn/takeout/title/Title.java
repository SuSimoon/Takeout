package cn.takeout.title;

import java.util.HashSet;
import java.util.Set;

import cn.takeout.menu.Menu;

public class Title {
	private Integer tid;
	private String tname;
	private Set<Menu> menus = new HashSet<Menu>();
	
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Set<Menu> getMenus() {
		return menus;
	}
	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}
	
	
}
