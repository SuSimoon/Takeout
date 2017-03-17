package cn.takeout.cart;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import cn.takeout.food.Food;
import cn.takeout.food.FoodService;

import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport {
	@Autowired
	@Qualifier("cartService")
	private CartService cartService;
	
	@Autowired
	@Qualifier("foodService")
	private FoodService foodService;
	
	//接收fid
	private Integer fid;
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	
	//Session获取购物车
	public Cart getCart(HttpServletRequest request) {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if(cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		return cart;
	}
	
	
	//添加购物车
	public String add() {
		//查询商品信息
		Food food = foodService.findByFid(fid);
		//创建一个购物项
		CartItem cartItem = new CartItem();
		cartItem.setCount(1);
		cartItem.setFood(food);
		//加入购物车
		Cart cart = getCart(ServletActionContext.getRequest());
		cart.addCart(cartItem);
		System.out.println(fid);
		return "addCartSuccess";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
