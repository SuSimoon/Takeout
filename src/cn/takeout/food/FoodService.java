package cn.takeout.food;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class FoodService {
	@Autowired
	@Qualifier("foodDao")
	private FoodDao foodDao;

	public List<Food> findByMid(Integer mid) {
		return foodDao.findByMid(mid);
	}
	public Food findByFid(Integer fid) {
		return foodDao.findByFid(fid);
	}
}
