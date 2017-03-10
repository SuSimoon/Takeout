package cn.takeout.menu;

import java.util.HashSet;
import java.util.Set;

import cn.takeout.food.Food;
import cn.takeout.title.Title;

public class Menu {
	private Integer mid;
	private String mname;
	private Title title;
	private Set<Food> foods = new HashSet<Food>();
	
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}
	public Set<Food> getFoods() {
		return foods;
	}
	public void setFoods(Set<Food> foods) {
		this.foods = foods;
	}
	
}
