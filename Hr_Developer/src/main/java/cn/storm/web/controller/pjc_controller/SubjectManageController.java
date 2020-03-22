package cn.storm.web.controller.pjc_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * 考试题库管理
 * @author 17834
 *
 */
@Controller
@RequestMapping("/subject")
public class SubjectManageController {
	//注入service
	
	
	/**
	 * 题库登记页面
	 */
	@RequestMapping("showsubjectregistpage")
	public ModelAndView showsubjectregistpage(){
		//准备实体分类数据
		
		ModelAndView mav =new ModelAndView();
		return mav;
		
	}
	
}
