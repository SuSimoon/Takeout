package cn.takeout.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public class CartService {
	@Autowired
	@Qualifier("cartDao")
	private CartDao cartDao;
}
