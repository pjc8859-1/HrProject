package cn.storm.web.controller.pjc_controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.storm.pojo.ConfigFileFirstKind;
import cn.storm.pojo.ConfigFileSecondKind;
import cn.storm.pojo.ConfigFileThirdKind;
import cn.storm.pojo.ConfigMajor;
import cn.storm.pojo.ConfigMajorKind;
import cn.storm.pojo.ConfigPublicChar;
import cn.storm.pojo.EngageMajorRelease;
import cn.storm.service.ConfigFileFirstKindService;
import cn.storm.service.ConfigFileSecondKindService;
import cn.storm.service.ConfigFileThirdKindService;
import cn.storm.service.ConfigMajorKindService;
import cn.storm.service.ConfigMajorService;
import cn.storm.service.ConfigPublicCharService;
import cn.storm.service.EngageMajorReleaseService;



/**
 * 
 * 招聘管理模块
 * @author 17834
 *
 */
@Controller
@RequestMapping("/recruitment")
public class RecruitmentManagementController {
	//注入service
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
	private ConfigPublicCharService cpcs = null;
	@Autowired
	private EngageMajorReleaseService emrs = null;
	/**
	 * 查询出招聘发布登记页面需要的数据存入model中
	 */
	@RequestMapping("showrecruitment.do")
	public ModelAndView showrecruitment(){
		
		ModelAndView mav = new ModelAndView();
		mav = setMavBaseValue(mav);
		
		mav.setViewName("forward:/major_release_input.jsp");
		return mav;
	}
	
	@RequestMapping("submitmajorrelease.do")
	public ModelAndView showrecruitment(EngageMajorRelease emr ,
			@RequestParam String deadline1,
			@RequestParam String registTime1
			){
		ModelAndView mav = new ModelAndView();
		emr.setDeadline(converttime(deadline1, 1));
		emr.setRegistTime(converttime(registTime1, 0));
		
		
		//插入
		boolean result = emrs.addEngageMajorRelease(emr);
		if(result)
		{
			//转跳到成功页面
			mav.addObject("releasemessage", "<center><h3>提交成功,可审核<h3><center>");
			mav.setViewName("forward:/major_release_success.jsp");
		}
		else{
			//转跳到失败页面
		}
		
		
		
		return mav;
		
	}
	
	@RequestMapping("submitmajorreleasechange.do")
	public ModelAndView submitmajorreleasechange(EngageMajorRelease emr ,
			@RequestParam String deadline1,//2020-05-12
			@RequestParam String registTime1,
			@RequestParam String changeTime1
			
			){
		ModelAndView mav = new ModelAndView();
		emr.setDeadline(converttime(deadline1, 1));
		emr.setRegistTime(converttime(registTime1, 0));
		emr.setChangeTime(converttime(changeTime1, 0));
		
		
		//插入
		int result = emrs.modifyEngageMajorRelease(emr);
		if(result > 0)
		{
			//转跳到成功页面
			mav.addObject("releasemessage", "<center><h3>提交成功,可审核<h3><center>");
			mav.setViewName("forward:/major_release_success.jsp");
		}
		else{
			//转跳到失败页面
			mav.addObject("releasemessage", "<center><h3>修改失败,重试一下哈<h3><center>");
			mav.setViewName("forward:/major_release_success.jsp");
		}
		
		
		
		return mav;
		
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("showreleasechangepage.do")
	public ModelAndView showreleasechangepage(){
		//查询出所有提交了的档案
		List<EngageMajorRelease>  list = emrs.queryAllEngageMajorRelease();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("releases", list);
		mav.setViewName("forward:/released_show_list.jsp");
		return mav;
		
	}
	
	@RequestMapping("editrelease.do")
	public ModelAndView editrelease(@RequestParam int mreId){
		
		
		System.out.println("输入的mreId:"+mreId);
		//将mreId传入后台查询
		EngageMajorRelease emr = emrs.queryEngageMajorReleaseBymreId(mreId);
		System.out.println(emr);
		ModelAndView mav = new ModelAndView();
		mav.addObject("emr", emr);
		mav.setViewName("forward:/major_release_change.jsp");
		mav = setMavBaseValue(mav);
		return mav;
	}
	
	
	@RequestMapping("deleterelease.do")
	@ResponseBody
	public boolean deleterelease(@RequestBody int mreId)
	{	
		boolean result = emrs.removeEngageMajorReleaseBymreId(mreId);
		return result;
	}
	
	
	
	/**
	 * 给传进来的mav 设基本的职位分类等等
	 */
	public ModelAndView setMavBaseValue(ModelAndView mav)
	{
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
				
				//查询所有公共字段中是招聘类型的集合
				List<ConfigPublicChar> char_list =  cpcs.queryConfigPublicCharByKey("招聘类型");
				
				
				//存入到nav中
				JSONArray  first = JSONArray.fromObject(first_list);
				JSONArray  second = JSONArray.fromObject(second_list);
				JSONArray  third = JSONArray.fromObject(third_list);
				JSONArray  fourth = JSONArray.fromObject(fourth_list);
				JSONArray  fifth = JSONArray.fromObject(fifth_list);
				JSONArray  sixth = JSONArray.fromObject(char_list);
				
				
				mav.addObject("firstlist", first.toString());
				mav.addObject("secondlist", second.toString());
				mav.addObject("thirdlist", third.toString());
				mav.addObject("fourthlist", fourth.toString());
				mav.addObject("fifthlist", fifth.toString());
				mav.addObject("charlist", sixth);
				return mav;
	}
	
	@RequestMapping("showreleasequerypage.do")
	public ModelAndView showreleasequerypage(){
		List<EngageMajorRelease> realeases = emrs.queryAllEngageMajorRelease();
		ModelAndView mav = new ModelAndView();
		mav.addObject("realeases", realeases);
		mav.setViewName("forward:/released_query_list.jsp");
		return mav;
	}
	
	
	/**
	 * 申请该职位按钮访问处
	 */
	@RequestMapping("applyrelease.do")
	public ModelAndView applyrelease(@RequestParam int mreId)
	{
		ModelAndView mav = new ModelAndView();
		EngageMajorRelease release = emrs.queryEngageMajorReleaseBymreId(mreId);
		mav.addObject("release", release);
		//转跳到简历登记页面,并填写相关的值在上面
		mav.setViewName("forward:/");
		return mav;
		
	}
	
	
	/**
	 * 点击查看职位发布详情
	 * @param arg0
	 * @param type
	 * @return
	 */
	@RequestMapping("showreleasedetail.do")
	public ModelAndView showreleasedetail(@RequestParam int mreId){
		ModelAndView mav = new ModelAndView();
		EngageMajorRelease release = emrs.queryEngageMajorReleaseBymreId(mreId);
		mav.addObject("release", release);
		mav.setViewName("forward:/major_release_detail.jsp");
		return mav;
	}
	
	@SuppressWarnings("deprecation")
	public Timestamp converttime(String arg0,int type) {
		System.out.println(arg0);
		Date d = null;
		if(type == 1 )
		{
			d = new Date(arg0.replace("-", "/")+" 00:00:00");//    
		}
		else
		{
			d = new Date(arg0.replace("-", "/"));//2020-09-20 11:20:20
		}
		long time = d.getTime();//long 
		return new Timestamp(time);
	}
	
}
