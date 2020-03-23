package cn.storm.web.controller.pjc_controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	 * 题目查询
	 * 
	 */
	@RequestMapping("subjectquery.do")
	public ModelAndView  subjectquery() 
	{
		ModelAndView mav = new ModelAndView();
		
		//查询出所有二级考试分类
		//II类试题
		List<ConfigQuestionSecondKind> secondlist = cqsks.queryAllConfigQuestionSecondKind();
		mav.addObject("subjects", secondlist); 
		mav.setViewName("forward:/subject_query.jsp");
		return mav;
		
	}
	
	
	/**
	 * 接收题目查询页面传来的查询条件
	 */
	@RequestMapping("/subjectquerysubmit/{pagenum}.do")
	public ModelAndView  subjectquerysubmit(
		String	secondKindName,
		String keyword,
		String starttime,
		String endtime,
		@PathVariable("pagenum") int pagenum
		
			)
	{
		
		System.out.println(pagenum);
		ModelAndView mav = new ModelAndView();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("secondKindName", secondKindName);
		if(keyword != null && keyword != "")
		{
			map.put("keyword", keyword);
		}
		if(starttime != null && starttime != "")
		{
			map.put("starttime", converttime(starttime, 1));
		}
		if(endtime != null && endtime != "")
		{
			map.put("endtime", converttime(endtime, 1));
		}
		List<EngageSubjects> list = ess.queryEngageSubjectsByCondition(map);
		
		int pagecount = list.size();
		System.out.println("总条数"+pagecount);
		int n = 1;//最大页数
		if(pagenum <=0)
		{
			pagenum =1;
		}
		if(pagecount == 0)
		{
			
		}
		else{
			//最大页数
			n = (pagecount % 10) >0 ? (pagecount / 10 + 1):(pagecount / 10 );
			System.out.println("最大页数"+n);
			int nextcount =  pagenum*10;
			if(nextcount > pagecount)
			{
				//到了最后一页
				nextcount = pagecount;
			}
			
			
			list = list.subList((pagenum-1)*10, nextcount);
			System.out.println("取了"+(pagenum-1)*10+"到"+nextcount+"个");
			for (EngageSubjects engageSubjects : list) {
				System.out.println(engageSubjects);
			}
		}
		
		
		System.out.println(list.get(0));
		mav.addObject("subjects", list);
		mav.addObject("maxnum",n );//存入最大页数
		mav.addObject("currentnum",pagenum );//存入当前页数
		mav.addObject("pagecount",pagecount );//存入总条数
		mav.setViewName("forward:/subject_query_result.jsp");
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
