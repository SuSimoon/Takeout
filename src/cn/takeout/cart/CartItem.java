package cn.takeout.cart;

import cn.takeout.food.Food;

public class CartItem {
	private Food food;
	private Integer count;
	private Double subtotal;
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count; 
	}
	public Double getSubtotal() {
		return count * food.getPrice();
	}
	
	
	
}
