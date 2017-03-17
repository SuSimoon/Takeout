package cn.takeout.food;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FoodAction extends ActionSupport {
	@Autowired
	@Qualifier("foodService")
	private FoodService foodService;
	
	//接收mid
	private Integer mid;
	public void setMid(Integer mid) {
		this.mid = mid;
	}
		
	public String findByMid() {
		List<Food> fList = foodService.findByMid(mid);
		ActionContext.getContext().getSession().put("fList", fList);
		return "foodPage";
	}
	
}
