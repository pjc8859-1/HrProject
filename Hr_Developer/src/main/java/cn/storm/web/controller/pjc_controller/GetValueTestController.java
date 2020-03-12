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

	@RequestMapping("/bb.do")
	public void getvalue(@RequestParam("item.firstKindName") String val){
		System.out.println(val+"aaaaaaaaa");
	}
	
}
