package com.study;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {
	@Autowired
	MyRepository repository;

	@RequestMapping("/")
	public String methodB(Model model) {
		List<Goods> list = repository.methodA();
		model.addAttribute("toHtml", list);
		return "showgoods";
	}
}
