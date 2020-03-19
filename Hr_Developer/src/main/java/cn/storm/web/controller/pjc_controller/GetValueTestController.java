package cn.storm.web.controller.pjc_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 测试拿值
 * @author 17834
 *
 */
@Controller
@RequestMapping("/aa")
public class GetValueTestController {

	@RequestMapping("bb.do")
	public String getvalue(){
		return "redirect:/index.jsp";
	}
	
}
