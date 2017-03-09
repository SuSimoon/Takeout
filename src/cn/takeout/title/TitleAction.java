package cn.takeout.title;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionSupport;

public class TitleAction extends ActionSupport {
	@Autowired
	@Qualifier("titleService")
	private TitleService titleService;
}
