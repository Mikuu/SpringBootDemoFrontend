package com.websystique.springboot.controller;

import com.websystique.springboot.config.MyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	private MyConfig myConfig = new MyConfig();

	@Autowired
	public void setMyConfig(MyConfig myConfig) {
		this.myConfig = myConfig;
	}

	@RequestMapping("/")
	String index(ModelMap modal) {
		modal.addAttribute("title","Spring Demo Frontend");
		modal.addAttribute("host",myConfig.getHost());
		modal.addAttribute("port",myConfig.getPort());
		return "index";
	}

	@RequestMapping("/partials/{page}")
	String partialHandler(@PathVariable("page") final String page) {
		return page;
	}

}
