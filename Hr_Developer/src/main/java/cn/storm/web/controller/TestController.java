package cn.storm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/testclass")
public class TestController {
		@RequestMapping("/selectAll.do")
		public String testMethod(){
			System.out.println("TestController执行了");
			return "redirect:/main.jsp";
		}
}
