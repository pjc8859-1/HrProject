package cn.storm.web.controller.pjc_controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
   


import cn.storm.pojo.ConfigMajor;
import cn.storm.pojo.ConfigMajorKind;
import cn.storm.pojo.ConfigPublicChar;
import cn.storm.pojo.EngageInterview;
import cn.storm.pojo.EngageResume;
import cn.storm.service.ConfigFileFirstKindService;
import cn.storm.service.ConfigFileSecondKindService;
import cn.storm.service.ConfigFileThirdKindService;
import cn.storm.service.ConfigMajorKindService;
import cn.storm.service.ConfigMajorService;
import cn.storm.service.ConfigPublicCharService;
import cn.storm.service.EngageInterviewService;
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
	@Autowired
	private EngageInterviewService eis = null;
	
	
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
			 EngageResume er,
			MultipartFile file,
			@RequestParam String humanBirthday1,
			@RequestParam String registTime1,
			HttpServletRequest request
			)
	{	
		ModelAndView mav = new ModelAndView();
		//处理文件
		//获取项目运行的路径
		String realPath = request.getSession().getServletContext().getRealPath("/upload");
		//判断该路径是否存在
		File realFile = new File(realPath);
		if(!realFile.exists()){
			realFile.mkdirs();
		} 
		//2. 获取唯一的文件名称(包含扩展名)
		String uuidName = UUID.randomUUID().toString().replace("-", "");
		//获取扩展名: 获取文件名
		//获取真实的文件名
		String originalFilename = file.getOriginalFilename();
		//截取字符串，获取文件的扩展名
		String extendName = originalFilename.substring(originalFilename.lastIndexOf("."));
		System.out.println(extendName);
		//唯一的文件名UUID.JPG
		String fileName = uuidName + extendName;
		//上传文件
		try {
				file.transferTo(new File(realFile, fileName));
				mav.addObject("resumeregistmessage","简历提交成功!!" );
			} catch (IOException e) {
			e.printStackTrace();
			mav.addObject("resumeregistmessage","简历提交失败!!<文件上传>" );
			} 
			
			mav.setViewName("forward:/resumeregistsuccess.jsp");
			
			//插入对象
			er.setHumanPicture(fileName);
			er.setHumanBirthday(converttime(humanBirthday1, 1));
			er.setRegistTime(converttime(registTime1, 0));
			System.out.println(er);
			
			boolean result = ers.addEngageResume(er);
			if(!result)
			{
				mav.addObject("resumeregistmessage","简历提交失败!!<数据保存失败>" );
			}
		return  mav;
	}
	
	/**
	 * 展示简历筛选页面
	 */
	@RequestMapping("screenresume.do")
	public ModelAndView screenresume(){
		ModelAndView mav = new ModelAndView();
		//查询出所有请选择职位分类
		List<ConfigMajorKind> fourth_list = this.cmks.queryAllConfigMajorKind();
		//查询出所有请选择职位
		List<ConfigMajor> fifth_list =this.cms.queryAllConfigMajor();
		JSONArray  fourth = JSONArray.fromObject(fourth_list);
		JSONArray  fifth = JSONArray.fromObject(fifth_list);
		mav.addObject("fourthlist", fourth.toString());
		mav.addObject("fifthlist", fifth.toString());
		mav.setViewName("forward:/resume_screen.jsp");
		return mav;
	}
	
	/**
	 * 处理从筛选界面传上来的查询条件
	 */
	@RequestMapping("submitresumescreen.do")
	public ModelAndView submitresumescreen(
			@RequestParam("MajorKindName") String majorkindname,
			@RequestParam("MajorName") String majorname,
			 String[] key,
			@RequestParam String starttime,
			@RequestParam String endtime,
			String keywords
			){
		System.out.println(majorkindname);
		System.out.println(majorname);
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
		
		System.out.println("=====================两个时间");
		System.out.println(map.get("starttime"));
		System.out.println(map.get("endtime"));
		
		List<EngageResume> list = 	ers.queryByDiction(map);
		for (EngageResume engageResume : list) {
			System.out.println(engageResume);
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("resumes", list);
		mav.setViewName("forward:/resume_screen_result_list.jsp");
		return mav;
		
	}
	/**
	 * 这个方法是点击"审核按钮后跳到另外页面展示,不能修改"
	 * @param reId
	 * @return
	 */
	@RequestMapping("resumescreen.do")
	public ModelAndView resumescreen(int reId)
	{	
		ModelAndView mav = new ModelAndView();
		EngageResume er =  ers.queryEngageResumeByresid(reId);
		mav.addObject("er", er);
		mav.setViewName("forward:/resume_screen_check.jsp");
		return mav;
	}
	
	/**
	 * 这个方法是点击"修改"后转跳到其他页面,可以修改简历信息
	 * @param reId
	 * @return
	 */
	@RequestMapping("resumeedit.do")
	public ModelAndView resumeedit(int reId)
	{	
		ModelAndView mav = new ModelAndView();
		EngageResume er =  ers.queryEngageResumeByresid(reId);
		mav.addObject("er", er);
		mav = setMavBaseValue(mav);
		mav.setViewName("forward:/resume_edit.jsp");
		
		return mav;
	}
	/**
	 * 接受从修改页面传来的值进行update操作
	 */
	@RequestMapping("editsubmit.do")
	public ModelAndView editsubmit(
			 EngageResume er,
			MultipartFile file,
			@RequestParam String humanBirthday1,
			@RequestParam String registTime1,
			HttpServletRequest request
			)
	{	
		EngageResume er2 = ers.queryEngageResumeByresid(er.getResId());
		ModelAndView mav = new ModelAndView();
		//处理文件
		//获取项目运行的路径
		String realPath = request.getSession().getServletContext().getRealPath("/upload");
		//判断该路径是否存在
		File realFile = new File(realPath);
		if(!realFile.exists()){
			realFile.mkdirs();
		} 
		System.out.println((er2.getHumanPicture() != null) +""+(er2.getHumanPicture() != ""));
		System.out.println("file.getSize() <= 0"+(file.getSize() <= 0));
		//得到真实路径下已经存在的文件并删除原来的文件
		if(er2.getHumanPicture() != null && er2.getHumanPicture() != "" )
		{	
			String existfilepath =realPath+ er2.getHumanPicture();
			System.out.println("existfilepath:"+existfilepath);
			File existfile = new File(existfilepath);
			if(existfile.exists()){
				if(existfile.delete())
				{
					System.out.println("文件删除成功");
				}
			} 
		}
		
		//2. 获取唯一的文件名称(包含扩展名)
		String uuidName = UUID.randomUUID().toString().replace("-", "");
		//获取扩展名: 获取文件名
		
		
		
		String extendName;
		String originalFilename=null ;
		if(file.getSize() <= 0)
		{
			
			//截取字符串，获取文件的扩展名
			extendName = er2.getHumanPicture().substring(er2.getHumanPicture().lastIndexOf("."));
			
		}else{
			//获取真实的文件名
			originalFilename = file.getOriginalFilename();
			extendName = originalFilename.substring(originalFilename.lastIndexOf("."));
		}
		//唯一的文件名UUID.JPG
		String fileName = uuidName + extendName;
		//上传文件
		if(!(file.getSize() <= 0) )
		{
			//文件没有上传
			try {
				file.transferTo(new File(realFile, fileName));
				mav.addObject("resumeregistmessage","简历修改成功!!" );
				System.out.println("文件进行了上传:路径为"+realFile+fileName);
			} catch (IOException e) {
			e.printStackTrace();
			mav.addObject("resumeregistmessage","简历修改失败!!<文件上传>" );
			} 
		}else{
			//文件已经存在
			mav.addObject("resumeregistmessage","简历修改成功!!<" );
			fileName=er2.getHumanPicture();
			System.out.println("修改了fileName"+fileName);
		}
			mav.setViewName("forward:/resumeregistsuccess.jsp");
			
			//插入对象
			er.setHumanPicture(fileName);
			er.setHumanBirthday(converttime(humanBirthday1, 1));
			er.setRegistTime(converttime(registTime1, 0));
			System.out.println("update的对象:"+er);
			
			int result = ers.modifyEngageResume(er);
			if(result <= 0)
			{
				mav.addObject("resumeregistmessage","简历修改失败!!<数据保存失败>" );
			}
		
		
		return  mav;
	}
	
	
	
	@RequestMapping("checkresume.do")
	public ModelAndView checkresume(
			short suggest,
			int resId,
			String checker,
			String checkTime,
			String suggestion
			){
		ModelAndView mav = new ModelAndView();
		//查出id的简历
		EngageResume er = ers.queryEngageResumeByresid(resId);
		er.setCheckStatus(suggest);
		er.setChecker(checker);
		er.setCheckTime(converttime(checkTime, 0));
		er.setHumanHistoryRecords(suggestion);
		 int result = ers.modifyEngageResume(er);
		if(result > 0)
		{
			mav.addObject("resumeregistmessage", "审核成功!!!");
		}else{
			mav.addObject("resumeregistmessage", "审核失败!!!");
		}
		mav.setViewName("forward:/resumeregistsuccess.jsp");
		return mav;
	}
	
	/**
	 * 查询出有效简历,就是可以面试的
	 */
	@RequestMapping("effectsresumelist.do")
	public ModelAndView effectsresumelist(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("checkStatus", 0);
		List<EngageResume> list = ers.queryByDiction(map);
		ModelAndView mav = new ModelAndView();
		mav.addObject("resumes", list);
		mav.setViewName("forward:/resume_effect_query.jsp");
		return mav;
	}
	/**
	 * 开始,面试
	 * @param resId
	 * @return
	 */
	@RequestMapping("interviewregist.do")
	public ModelAndView interviewregist(int resId)
	{	
		ModelAndView mav = new ModelAndView();
		EngageResume er = ers.queryEngageResumeByresid(resId);
		//首先查询有没有这一个人的面试记录
		short amount = 1;
		EngageInterview ei = eis.queryEngageInterviewByeinResumeId(resId);
		System.out.println(ei);
		if(ei == null)
		{
			System.out.println("进入了插入"+(ei==null));
			//说明没有这个人的面试信息
			ei = new EngageInterview();
			ei.setHumanName(er.getHumanName());
			ei.setHumanMajorKindId(er.getHumanMajorKindId());
			ei.setHumanMajorKindName(er.getHumanMajorKindName());
			ei.setHumanMajorId(er.getHumanMajorId());
			ei.setHumanMajorName(er.getHumanMajorName());
			ei.setResumeId(er.getResId());
			ei.setInterviewAmount(amount);
			boolean result = eis.addEngageInterview(ei);
			
		}
		
		mav.addObject("er", er);
		mav.addObject("ei", ei);
		mav.setViewName("forward:/resume_interview.jsp");
		return mav ;
	}
	
	/**
	 * 处理来自面试页面的结果
	 */
	@RequestMapping("interviewsubmit.do")
	public ModelAndView interviewsubmit(
			int interviewAmount,
			String imageDegree,
			String nativeLanguageDegree,
			String foreignLanguageDegree,
			String responseSpeedDegree,
			String eqDegree,
			String iqDegree,
			String multiQualityDegree,
			String register,
			String registeTime,
			String interviewComment,
			int suggest,
			int resId,
			int einId
			){
		
		ModelAndView mav = new ModelAndView();
		EngageResume er = ers.queryEngageResumeByresid(resId);
		er.setCheckStatus((short)suggest);
		ers.modifyEngageResume(er);
		EngageInterview  ei = eis.queryEngageInterviewByeinId(einId);
		ei.setInterviewAmount((short)interviewAmount);
		ei.setImageDegree(imageDegree);
		ei.setNativeLanguageDegree(nativeLanguageDegree);
		ei.setForeignLanguageDegree(foreignLanguageDegree);
		ei.setResponseSpeedDegree(responseSpeedDegree);
		ei.setEqDegree(eqDegree);
		ei.setIqDegree(iqDegree);
		ei.setMultiQualityDegree(multiQualityDegree);
		ei.setRegister(register);
		ei.setRegisteTime(converttime(registeTime, 2));
		ei.setInterviewComment(interviewComment);
		ei.setInterviewStatus((short)1);//0:未面试,1:已面试
		int result = eis.modifyEngageInterview(ei);
		if(result > 0)
		{
			mav.addObject("interviewmessage", "登记成功");
		}else{
			mav.addObject("interviewmessage", "登记失败");
		}
		mav.setViewName("forward:/interview_regist_success.jsp");
		return mav;
	}
	
	/**
	 * 面试结果登记
	 */
	@RequestMapping("interviewresult.do")
	public ModelAndView interviewresult(){
		ModelAndView mav =new ModelAndView();
		return mav;
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
