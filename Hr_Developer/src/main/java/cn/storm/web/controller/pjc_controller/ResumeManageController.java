package cn.storm.web.controller.pjc_controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.storm.pojo.ConfigFileFirstKind;
import cn.storm.pojo.ConfigFileSecondKind;
import cn.storm.pojo.ConfigFileThirdKind;
import cn.storm.pojo.ConfigMajor;
import cn.storm.pojo.ConfigMajorKind;
import cn.storm.pojo.ConfigPublicChar;
import cn.storm.pojo.EngageResume;
import cn.storm.service.ConfigFileFirstKindService;
import cn.storm.service.ConfigFileSecondKindService;
import cn.storm.service.ConfigFileThirdKindService;
import cn.storm.service.ConfigMajorKindService;
import cn.storm.service.ConfigMajorService;
import cn.storm.service.ConfigPublicCharService;
import cn.storm.service.EngageMajorReleaseService;
import cn.storm.service.EngageResumeService;

/**
 * 简历管理
 * @author 17834
 *
 */
@Controller
@RequestMapping("/resumemanage")
public class ResumeManageController {
	//注入相关service
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
	@Autowired
	private EngageResumeService ers = null;
	
	
	/**
	 * 展示简历登记页面
	 */
	@RequestMapping("showresumepage.do")
	public ModelAndView showresumepage()
	{	
		ModelAndView mav = new ModelAndView();
		mav = setMavBaseValue(mav);
		mav.setViewName("forward:/resume_regist.jsp");
		return  mav;
	}
	@RequestMapping("submitresumeregist.do")
	public ModelAndView submitresumeregist(
			@RequestParam EngageResume er,MultipartFile file,
			@RequestParam String humanBirthday1,
			@RequestParam String registTime1
			)
	{	
		ModelAndView mav = new ModelAndView();
		mav = setMavBaseValue(mav);
		mav.setViewName("forward:/resume_regist.jsp");
		return  mav;
	}
	
	
	
	
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
				
				//查询所有公共字段中是招聘类型的集合
				List<ConfigPublicChar> char_list =  cpcs.queryConfigPublicCharByKey("招聘类型");
				//查询所有公共字段中是性别的集合
				List<ConfigPublicChar> sex_list =  cpcs.queryConfigPublicCharByKey("性别");
				//查询所有公共字段中是国籍的集合
				List<ConfigPublicChar> country_list =  cpcs.queryConfigPublicCharByKey("国籍");
				//查询所有公共字段中是民族的集合
				List<ConfigPublicChar> nation_list =  cpcs.queryConfigPublicCharByKey("民族");
				//查询所有公共字段中是宗教信仰的集合
				List<ConfigPublicChar>  religious_list =  cpcs.queryConfigPublicCharByKey("宗教信仰");
				//查询所有公共字段中是政治面貌的集合
				List<ConfigPublicChar>  political_list =  cpcs.queryConfigPublicCharByKey("政治面貌");
				//查询所有公共字段中是学历的集合
				List<ConfigPublicChar>  education_list =  cpcs.queryConfigPublicCharByKey("学历");
				//查询所有公共字段中是教育年限的集合
				List<ConfigPublicChar>  educationyears_list =  cpcs.queryConfigPublicCharByKey("教育年限");
				//查询所有公共字段中是专业的集合
				List<ConfigPublicChar>  major_list =  cpcs.queryConfigPublicCharByKey("专业");
				//查询所有公共字段中是特长的集合
				List<ConfigPublicChar>  speciality_list =  cpcs.queryConfigPublicCharByKey("特长");
				//查询所有公共字段中是爱好的集合
				List<ConfigPublicChar>  hobby_list =  cpcs.queryConfigPublicCharByKey("爱好");
				
				
				
				
				
				//存入到nav中
				JSONArray  fourth = JSONArray.fromObject(fourth_list);
				JSONArray  fifth = JSONArray.fromObject(fifth_list);
				JSONArray  sixth = JSONArray.fromObject(char_list);
				JSONArray  sexlist = JSONArray.fromObject(sex_list);
				JSONArray  countrylist = JSONArray.fromObject(country_list);
				JSONArray  nationlist = JSONArray.fromObject(nation_list);
				JSONArray  religiouslist = JSONArray.fromObject(religious_list);
				JSONArray  politicallist = JSONArray.fromObject(political_list);
				JSONArray  educationlist = JSONArray.fromObject(education_list);
				JSONArray  educationyearslist = JSONArray.fromObject(educationyears_list);
				JSONArray  majorlist = JSONArray.fromObject(major_list);
				JSONArray  specialitylist = JSONArray.fromObject(speciality_list);
				JSONArray  hobbylist = JSONArray.fromObject(hobby_list);
				
				
				mav.addObject("fourthlist", fourth.toString());
				mav.addObject("fifthlist", fifth.toString());
				mav.addObject("charlist", sixth);
				mav.addObject("sexlist", sexlist);
				mav.addObject("countrylist", countrylist);
				mav.addObject("nationlist", nationlist);
				mav.addObject("religiouslist", religiouslist);
				mav.addObject("politicallist", politicallist);
				mav.addObject("educationlist", educationlist);
				mav.addObject("educationyearslist", educationyearslist);
				mav.addObject("majorlist", majorlist);
				mav.addObject("specialitylist", specialitylist);
				mav.addObject("hobbylist", hobbylist);
				
				return mav;
	}
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
