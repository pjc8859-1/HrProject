package cn.storm.web.controller.pjc_controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.storm.pojo.ConfigMajor;
import cn.storm.pojo.ConfigMajorKind;
import cn.storm.pojo.EngageInterview;
import cn.storm.service.ConfigMajorKindService;
import cn.storm.service.ConfigMajorService;
import cn.storm.service.EngageInterviewService;


/**
 * 面试管理
 * @author 17834
 *
 */
@Controller
@RequestMapping("/interview")
public class InterviewManagerController {
	//注入service
	@Autowired
	private ConfigMajorKindService cmks = null;
	@Autowired
	private ConfigMajorService cms = null;
	@Autowired
	private EngageInterviewService eis = null;
	
	//=================================================
	/**
	 * 展示面试结果登记的搜索页面
	 */
	@RequestMapping("showinterviewregister.do")
	public ModelAndView showinterviewregister(){
		//查询出职位分类
		
		ModelAndView mav = new ModelAndView();
		mav = setMavBaseValue(mav);
		mav.setViewName("forward:/interview_query.jsp");
		return mav;
	}
	
	/**
	 * 接收来自面试结果登记的值
	 */
	@RequestMapping("interviewquerysubmit.do")
	public ModelAndView interviewquerysubmit(
			@RequestParam("MajorKindName") String majorkindname,
			@RequestParam("MajorName") String majorname,
			 String[] key,
			@RequestParam String starttime,
			@RequestParam String endtime,
			String keywords
			){
		ModelAndView mav = new ModelAndView();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("keywords", keywords);
		if(key != null && key.length >0){
			
			for (String string : key) {
				System.out.println(string);
				map.put(string, 1);
				
			}
		}
		if(majorkindname!= null && majorkindname.trim() != "")
		{
			map.put("humanMajorKindName", majorkindname);
		}
		if(majorname!= null && majorname.trim() != "")
		{
			map.put("humanMajorName", majorname);
		}
		if(starttime!= null && starttime.trim() != "")
		{
		map.put("starttime", converttime(starttime, 1));
		}
		if(endtime!= null && endtime.trim() != "")
		{
			map.put("endtime", converttime(endtime, 1));
		}
		
		//开始调用动态查询
		List<EngageInterview> list = eis.queryByDiction(map);
//		for (EngageInterview engageInterview : list) {
//			System.out.println(engageInterview);
//		}
		mav.addObject("interviews", list);
		mav.setViewName("forward:/interview_query_result_list.jsp");
		return mav;
		
	}
	
	/**
	 * 面试筛选主页面
	 */
	@RequestMapping("interviewscreen.do")
	public ModelAndView interviewscreen(){
		ModelAndView mav = new ModelAndView();
		//查询出所有简历信息
		List<EngageInterview> list = eis.queryAllEngageInterview();
		mav.addObject("interviews", list);
		mav.setViewName("forward:/interview_screen.jsp");
		return mav;
	}
	
	
	//帮助方法===============
	//帮助方法
		/**
		 * 给传进来的mav 设基本的职位分类等等
		 */
		public ModelAndView setMavBaseValue(ModelAndView mav)
		{
			//查询出所有请选择职位分类
			List<ConfigMajorKind> fourth_list = this.cmks.queryAllConfigMajorKind();
			//查询出所有请选择职位
			List<ConfigMajor> fifth_list =this.cms.queryAllConfigMajor();
			
			//存入到nav中
			JSONArray  fourth = JSONArray.fromObject(fourth_list);
			JSONArray  fifth = JSONArray.fromObject(fifth_list);
			
			mav.addObject("fourthlist", fourth.toString());
			mav.addObject("fifthlist", fifth.toString());
			return mav;
		}
		
		/**
		 * 时间转换函数
		 * @param arg0
		 * @param type 
		 * @return
		 */
		@SuppressWarnings("deprecation")
		public Timestamp converttime(String arg0,int type) {
			System.out.println(arg0);
			Date d = null;
			if(type == 1 )
			{
				d = new Date(arg0.replace("-", "/")+" 00:00:00");
			}
			else
			{
				d = new Date(arg0.replace("-", "/"));
			}
			long time = d.getTime();//long
			return new Timestamp(time);
		}
}
