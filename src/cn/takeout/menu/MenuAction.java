package cn.takeout.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MenuAction extends ActionSupport {
	@Autowired
	@Qualifier("menuService")
	private MenuService menuService;
	//接收mid
	private Integer mid;
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	//按mid查询menu
	public String findByMid() {
		return "";
	}
	
}
