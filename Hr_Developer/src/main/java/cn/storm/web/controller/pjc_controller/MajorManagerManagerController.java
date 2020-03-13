
package cn.storm.web.controller.pjc_controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.storm.dto.MajorManagerDto;
import cn.storm.pojo.ConfigFileFirstKind;
import cn.storm.pojo.ConfigFileSecondKind;
import cn.storm.pojo.ConfigFileThirdKind;
import cn.storm.pojo.ConfigMajor;
import cn.storm.pojo.ConfigMajorKind;
import cn.storm.pojo.HumanFile;
import cn.storm.service.ConfigFileFirstKindService;
import cn.storm.service.ConfigFileSecondKindService;
import cn.storm.service.ConfigFileThirdKindService;
import cn.storm.service.ConfigMajorKindService;
import cn.storm.service.ConfigMajorService;
import cn.storm.service.HumanFileService;

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
	@Autowired
	private ConfigMajorKindService cmks = null;
	@Autowired
	private ConfigMajorService cms = null;
	@Autowired
	private HumanFileService hfs = null;
	
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
		//查询出所有请选择职位分类
		List<ConfigMajorKind> fourth_list = this.cmks.queryAllConfigMajorKind();
		//查询出所有请选择职位
		List<ConfigMajor> fifth_list =this.cms.queryAllConfigMajor();
		
//		保存所有的集合的json字符串
//		mv.addObject("firstlist", first_list);
//		mv.addObject("secondlist", second_list);
//		mv.addObject("thirdlist", third_list);
		JSONArray  first = JSONArray.fromObject(first_list);
		JSONArray  second = JSONArray.fromObject(second_list);
		JSONArray  third = JSONArray.fromObject(third_list);
		JSONArray  fourth = JSONArray.fromObject(fourth_list);
		JSONArray  fifth = JSONArray.fromObject(fifth_list);
		
		
		mv.addObject("firstlist", first.toString());
		mv.addObject("secondlist", second.toString());
		mv.addObject("thirdlist", third.toString());
		mv.addObject("fourthlist", fourth.toString());
		mv.addObject("fifthlist", fifth.toString());
//		System.out.println(first);
		
		
		
		mv.setViewName("/major_change_list");
		return mv;
	}
	
	/**
	 * 处理查询人员页面传来的数据
	 * @return
	 */
	@RequestMapping("/formsubmit.do")
	public ModelAndView handleFormSubmit(@RequestParam("item.firstKindId") String firstkindid,
			@RequestParam("item.secondKindId") String secondkindid,
			@RequestParam("item.thirdKindId") String thirdkindid,
			@RequestParam("item.humanMajorKindName") String majorkindid,
			@RequestParam("item.hunmaMajorName") String majorid,
			@RequestParam("item.str_startTime") Date begintime,
			@RequestParam("item.str_endTime") Date endtime
			){
		System.out.println(firstkindid+"==="+secondkindid+"==="+thirdkindid+"==="+majorkindid+"==="+majorid
					+"\n"+new Timestamp(begintime.getTime())+"==="+new Timestamp(endtime.getTime())
				);
		MajorManagerDto mmd = new MajorManagerDto();
		mmd.setFirstkindid(firstkindid);
		mmd.setSecondkindid(secondkindid);
		mmd.setThirdkindid(thirdkindid);
		mmd.setMajorkindid(majorkindid);
		mmd.setMajorid(majorid);
		mmd.setBegintime(begintime);
		mmd.setEndtime(endtime);
		List<HumanFile> list = hfs.queryByCondition(mmd);
		for (HumanFile humanFile : list) {
			System.out.println(humanFile.getHumanName());
		}
		
		return null;
		
		
	}
	
	@InitBinder  
	 public void initBinder(WebDataBinder binder) {  
	 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
	 dateFormat.setLenient(false);  
	 binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，false:不能为空值 
	}
}
