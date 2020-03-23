package cn.storm.web.controller.pjc_controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.storm.pojo.ConfigQuestionFirstKind;
import cn.storm.pojo.ConfigQuestionSecondKind;
import cn.storm.pojo.EngageSubjects;
import cn.storm.service.ConfigQuestionFirstKindService;
import cn.storm.service.ConfigQuestionSecondKindService;
import cn.storm.service.EngageSubjectsService;


/**
 * 考试题库管理
 * @author 17834
 *
 */
@Controller
@RequestMapping("/subject")
public class SubjectManageController {
	//注入service
	@Autowired
	private EngageSubjectsService ess = null;
	@Autowired
	private ConfigQuestionFirstKindService cqfks = null;
	@Autowired
	private ConfigQuestionSecondKindService cqsks = null;
	
	/**
	 * 题库登记页面
	 */
	@RequestMapping("showsubjectregistpage.do")
	public ModelAndView showsubjectregistpage(){
		//准备试题分类数据
		//I类试题
		List<ConfigQuestionFirstKind> firstlist = cqfks.queryAllConfigQuestionFirstKind();
		//II类试题
		List<ConfigQuestionSecondKind> secondlist = cqsks.queryAllConfigQuestionSecondKind();
		
		ModelAndView mav =new ModelAndView();
		//存入mav中
		mav.addObject("firstlist", firstlist);
		mav.addObject("secondlist", secondlist);
		mav.setViewName("forward:/subject_index.jsp");
		return mav;
		
	}
	
	
	/**
	 * 接收来自考试题库登记的题目信息
	 */
	@RequestMapping("submitsubject.do")
	public ModelAndView submitsubject(
			EngageSubjects es,
			String registTime1
			)
	{
		ModelAndView mav = new ModelAndView();
		es.setRegistTime(converttime(registTime1, 0));
		boolean result = ess.addEngageSubjects(es);
		if(result)
		{
			mav.addObject("subjectregistmessage", "登记成功!!");
			
		}else
		{
			mav.addObject("subjectregistmessage", "登记失败,请重试!!");
		}
		mav.setViewName("forward:/subject_regist_success.jsp");
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
