package sts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JslTest {
	@RequestMapping("bbb")
	public String bbb() {
		return "abc";
	}
}
