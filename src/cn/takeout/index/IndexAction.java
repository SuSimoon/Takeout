package cn.takeout.index;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.takeout.menu.Menu;
import cn.takeout.menu.MenuService;
import cn.takeout.title.Title;
import cn.takeout.title.TitleService;

public class IndexAction extends ActionSupport {
	@Autowired
	@Qualifier("titleService")
	private TitleService titleService;
	@Autowired
	@Qualifier("menuService")
	private MenuService menuService;
	
	public String index() {
		List<Title> tList = titleService.findAll();
		//List<Menu> mList = menuService.findAll();
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("tList", tList);
		//session.put("menu", mList);
		return "indexSuccess";
	}
	
}
