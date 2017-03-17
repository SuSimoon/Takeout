package cn.takeout.cart;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {
	//购物项：商品ID作为key
	private Map<Integer,CartItem> map = new HashMap<Integer, CartItem>();
	//总计
	private Double total;
	
	public Collection getCartItems() {
		return map.values();
	}
	public Double getTotal() {
		return total;
	}
	//方法：
	//添加购物项
	public void addCart(CartItem cartItem) {
		Integer fid = cartItem.getFood().getFid();
		//判断购物车中是否已经含有该购物项
		if(map.containsKey(fid)) {
			CartItem _cartItem = map.get(fid);
			_cartItem.setCount(_cartItem.getCount()+1);
		} else {
			map.put(fid, cartItem);
		}
		total += cartItem.getSubtotal();
	}
	//移除购物项
	public void removeCart(Integer fid) {
		CartItem cartItem = map.remove(fid);
		total -= cartItem.getSubtotal();
	}
	//清空购物车
	public void clearCart() {
		map.clear();
		total = 0d;
	}
}
