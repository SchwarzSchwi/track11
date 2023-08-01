package com.kr.jsl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringTest {

	@RequestMapping("test")
	public String test(){
		return "home";
	}
	@RequestMapping("abc")
	public String abc(Model model,HttpServletRequest req) {
		
		model.addAttribute("t_name","홍길동");
		req.setAttribute("t_area","대전");
		
		return "abc";
	}
}
