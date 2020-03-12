package cn.storm.web.controller.pjc_controller;

import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.storm.pojo.ConfigFileFirstKind;
import cn.storm.pojo.ConfigFileSecondKind;
import cn.storm.pojo.ConfigFileThirdKind;
import cn.storm.service.ConfigFileFirstKindService;
import cn.storm.service.ConfigFileSecondKindService;
import cn.storm.service.ConfigFileThirdKindService;

@Controller
@RequestMapping("/majorchange")
/**
 * 调动管理模块
 * @author 17834
 *
 */
public class MajorManagerManagerController {
	@Autowired
	private ConfigFileFirstKindService cffks= null;
	@Autowired
	private ConfigFileSecondKindService cfsks= null;
	@Autowired
	private ConfigFileThirdKindService cftks= null;
	
	@RequestMapping("/majorchange.do")
	/**
	 * 展示查询可变更职位的职员的controller
	 * 首先需要查询系统中状态为“正常”的员工。查询条件包括：员工所在机构和建档时间。
	 * @return
	 */
	public ModelAndView showChangePage(){
		ModelAndView mv = new ModelAndView();
		//查询出所有一级机构分类
		List<ConfigFileFirstKind> first_list = this.cffks.queryAllConfigFileFirstKind();
		//查询出所有二级机构分类
		List<ConfigFileSecondKind> second_list = this.cfsks.queryAllConfigFileSecondKind();
		//查询出所有三级机构分类
		List<ConfigFileThirdKind> third_list = this.cftks.queryAllConfigFileThirdKind();
		
//		保存所有的集合的json字符串
//		mv.addObject("firstlist", first_list);
//		mv.addObject("secondlist", second_list);
//		mv.addObject("thirdlist", third_list);
		JSONArray  first = JSONArray.fromObject(first_list);
		mv.addObject("firstlist", first.toString());
//		System.out.println(first);
		
		
		
		mv.setViewName("/major_change_list");
		return mv;
	}
	
	
	
	
	
}
