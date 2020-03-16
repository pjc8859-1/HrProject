
package cn.storm.web.controller.pjc_controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

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
import cn.storm.pojo.MajorChange;
import cn.storm.pojo.SalaryStandard;
import cn.storm.service.ConfigFileFirstKindService;
import cn.storm.service.ConfigFileSecondKindService;
import cn.storm.service.ConfigFileThirdKindService;
import cn.storm.service.ConfigMajorKindService;
import cn.storm.service.ConfigMajorService;
import cn.storm.service.HumanFileService;
import cn.storm.service.MajorChangeService;
import cn.storm.service.SalaryStandardService;

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
	@Autowired
	private SalaryStandardService sss = null;
	@Autowired
	private MajorChangeService mcs = null;
	
	
	
	
	@RequestMapping("/majorchange.do")
	/**
	 * 展示查询可变更职位的职员的controller
	 * 首先需要查询系统中状态为"正常"的员工。查询条件包括：员工所在机构和建档时间。
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
			@RequestParam("item.str_startTime") String begintime,
			@RequestParam("item.str_endTime") String endtime
			){
		MajorManagerDto mmd = new MajorManagerDto();
		mmd.setFirstkindid(firstkindid);
		mmd.setSecondkindid(secondkindid);
		mmd.setThirdkindid(thirdkindid);
		mmd.setMajorkindid(majorkindid);
		mmd.setMajorid(majorid);
		mmd.setBegintime(converttime(begintime));
		mmd.setEndtime(converttime(endtime));
		List<HumanFile> humanfilelist = hfs.queryByCondition(mmd);
//		for (HumanFile humanFile : list) {
//			System.out.println(humanFile.getHumanName());
//		}
		//查询到信息之后存入到mav中ModelAndView中
		ModelAndView mav = new ModelAndView();
		//往ModelAndView中存入数据相当于request.setAtribute("","");
		mav.addObject("humanlist", humanfilelist);
		//ModelAndView告诉执行完之后往哪里转跳
		mav.setViewName("forward:/showhumanfilelist.jsp");
		return mav;
		
		
	}
	
	/**
	 * 传入id并展示调动登记页面
	 * @param binder
	 */
	@RequestMapping("/showmove.do")
	public ModelAndView showmove(@RequestParam("humanid") int humanid){
		ModelAndView mv = new ModelAndView();
		//查出id为humanid的人力资源档案
		HumanFile hf = 	hfs.queryHumanFileByHufid(humanid);
		mv.addObject("humanfile", hf);
		//查询薪资标准列表
		List<SalaryStandard>  ss = sss.queryAllSalaryStandard();
		mv.addObject("salarystandardlist", ss);
		mv.setViewName("forward:/major_change.jsp");
		//===============================
		
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
			
//			保存所有的集合的json字符串
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
	
			return mv;
		
	}
	/**
	 * 获取职位修改提交页面的值from : major_change.jsp
	 * @param binder
	 */
	@RequestMapping("/commitmajorchange")
	public ModelAndView commitMajorChange(
			@RequestParam String humanId ,
			@RequestParam String firstKindId,
			@RequestParam String firstKindName,
			@RequestParam String secondKindId,
			@RequestParam String secondKindName,
			@RequestParam String thirdKindId,
			@RequestParam String thirdKindName,//
			@RequestParam String humanName,//
			@RequestParam String majorKindId,//
			@RequestParam String humanMajorKindName,//
			@RequestParam String humanMajorId,//
			@RequestParam String humanMajorName,//
			@RequestParam String salaryStandardId,//
			@RequestParam String salaryStandardName,//
			@RequestParam String newFirstKindId,//
			@RequestParam String newFirstKindName,//
			@RequestParam String newSecondKindId,//
			@RequestParam String newSecondKindName,//
			@RequestParam String newThirdKindId,//
			@RequestParam String newThirdKindName,//
			@RequestParam String newMajorKindId,//
			@RequestParam String newMajorKindName,//
			@RequestParam String newMajorId,//
			@RequestParam String newMajorName,//
			@RequestParam String register,//
			@RequestParam String registTime,
			@RequestParam String reason,
			@RequestParam Short checkStatus
			
			){
		ModelAndView mav = new ModelAndView();
//		System.out.println(humanId+"=="+firstKindId+"=="+firstKindName+"=="+secondKindId+"=="+secondKindName+"=="+
//				thirdKindId+"=="+thirdKindName+"=="+humanName+"=="+majorKindId+"=="+humanMajorKindName+"=="+humanMajorId+"=="
//				+hunmaMajorName+"=="+salaryStandardId+"=="+salaryStandardName+"=="+newFirstKindId+"=="+
//				newFirstKindName+"=="+newSecondKindId+"=="+newSecondKindName+"=="+newThirdKindId+"=="+
//				newThirdKindName+"=="+newMajorKindId+"=="+newMajorKindName+"=="+newMajorId+
//				"=="+newMajorName+"=="+register+"=="+register+"=="+registTime+"=="+reason);
		MajorChange mc = new MajorChange();
		mc.setHumanId(humanId);
		mc.setFirstKindId(firstKindId);
		mc.setFirstKindName(firstKindName);
		mc.setSecondKindId(secondKindId);
		mc.setSecondKindName(secondKindName);
		mc.setThirdKindId(thirdKindId);
		mc.setThirdKindName(thirdKindName);
		mc.setHumanName(humanName);
		mc.setMajorKindId(majorKindId);
		mc.setMajorKindName(humanMajorKindName);
		mc.setMajorId(humanMajorId);
		mc.setMajorName(humanMajorName);
		mc.setSalaryStandardId(salaryStandardId);
		mc.setSalaryStandardName(salaryStandardName);
		mc.setNewFirstKindId(newFirstKindId);
		mc.setNewFirstKindName(newFirstKindName);
		mc.setNewSecondKindId(newSecondKindId);
		mc.setNewSecondKindName(newSecondKindName);
		mc.setNewThirdKindId(newThirdKindId);
		mc.setNewThirdKindName(newThirdKindName);
		mc.setNewMajorKindId(newMajorKindId);
		mc.setNewMajorKindName(newMajorKindName);
		mc.setNewMajorId(newMajorId);
		mc.setNewMajorName(newMajorName);
		//mc.setCheckTime(checkTime);//没有检查时间
		mc.setRegistTime(converttime(registTime));
		mc.setRegister(register);
		mc.setChangeReason(reason);
		mc.setCheckStatus(checkStatus);
		boolean result= mcs.addMajorChange(mc);
		if(result)
		{	
//			mav.setViewName(viewName);
			System.out.println("提交成功");
			mav.setViewName("forward:/submit_major_change_success.jsp");
			return mav;
		}
		return null;
		
	}
	//===========================调动审核===============================================
	/**
	 * 请求这个controller将展示所有审核信息在页面上 to  major_change_show_check.jsp
	 * @return
	 */
	@RequestMapping("/showcheckpage.do")
	public ModelAndView showcheckpage(){
		List<MajorChange> changes = mcs.queryAllMajorChange();
//		JSONArray  data1 = JSONArray.fromObject(changes);
		ModelAndView mav = new ModelAndView();
		//存入mav
		mav.addObject("changes", changes);
		mav.setViewName("forward:/major_change_show_check.jsp");
		return mav;
	}
	/**
	 * 查询majorchange的详情通过mchId
	 * @param mchId
	 * @return
	 */
	
	@RequestMapping("/majorchangecheck.do")
	public ModelAndView majorChangeCheck(@RequestParam int mchId )
	{
		MajorChange mc = mcs.querySMajorChangeMchId(mchId);
		
		System.out.println(mc);
		ModelAndView mav = new ModelAndView();
		mav.addObject("majorchange",mc );
		mav.addObject("mchId", mchId);
		mav.setViewName("forward:/major_change_check.jsp");
		return mav;
		
	}
	
	
	/**
	 * 接收调动审核详情页面的数据,并update相应的majorchange
	 * 如果radio的value是1就update,是0就只update状态属性
	 * @return
	 */
	@RequestMapping("/submitcheck.do")
	public ModelAndView majorChangeCheck1(MajorChange  mg,
			@RequestParam String registTime1,
			@RequestParam String checkTime1
//			@RequestParam Short mchId,//
//			@RequestParam String humanId,//
//			@RequestParam String firstKindId,//
//			@RequestParam String firstKindName,//
//			@RequestParam String secondKindId,//
//			@RequestParam String secondKindName,
//			@RequestParam String thirdKindId,
//			@RequestParam String thirdKindName,
//			@RequestParam String humanName,
//			@RequestParam String majorKindId,
//			@RequestParam String humanMajorKindName,
//			@RequestParam String humanMajorId,
//			@RequestParam String humanMajorName,
//			@RequestParam String salaryStandardId,
//			@RequestParam String salaryStandardName,
//			@RequestParam String newFirstKindId,
//			@RequestParam String newFirstKindName,
//			@RequestParam String newSecondKindId,
//			@RequestParam String newSecondKindName,
//			@RequestParam String newThirdKindId,
//			@RequestParam String newThirdKindName,
//			@RequestParam String newMajorKindId,
//			@RequestParam String newMajorKindName,
//			@RequestParam String newMajorId,
//			@RequestParam String newMajorName,
//			@RequestParam String register,
//			@RequestParam Date registTime,
//			@RequestParam Date checkTime,
//			@RequestParam String reason,
//			@RequestParam Short reasoncheckStatus,
//			@RequestParam String checkReason,
//			@RequestParam String checker
			
			){
		
//			MajorChange mg = new MajorChange();
			ModelAndView mav = new ModelAndView();
			mg.setRegistTime(converttime(registTime1));
			mg.setCheckTime(converttime(checkTime1));
			System.out.println(mg);
			int result=-1 ;
//			checkStatus:0:未审核,1:审核通过,3,审核未通过
			if(mg.getCheckStatus() == 1)
			{
				result = mcs.modifyMajorChange(mg);
				//改变原来的人的数据
				HumanFile old_hf = hfs.queryHumanFileByHufid(Integer.parseInt(mg.getHumanId()));
				old_hf.setFirstKindId(mg.getNewFirstKindId());
				old_hf.setFirstKindName(mg.getNewFirstKindName());
				old_hf.setSecondKindId(mg.getNewSecondKindId());
				old_hf.setSecondKindName(mg.getNewSecondKindName());
				old_hf.setThirdKindId(mg.getNewThirdKindId());
				old_hf.setThirdKindName(mg.getNewThirdKindName());
				
				//职位分类
				old_hf.setHumanMajorKindId(mg.getNewMajorKindId());
				old_hf.setHumanMajorKindName(mg.getNewMajorKindName());
				
				//职位
				old_hf.setHumanMajorId(mg.getNewMajorId());
				old_hf.setHunmaMajorName(mg.getNewMajorKindName());
				
				//更改人
				old_hf.setChanger(mg.getRegister());
				
				//保存
				hfs.modifyHumanFile(old_hf);
				//转跳到审核成功页面
				mav.addObject("checkresultmessage", "<center><h2>审核<bold>成功!!</bold><h2></center>");
				mav.setViewName("forward:/submit_major_change_success.jsp");
				
				return mav;
			}else
			{
				//查出humanid所代表的人
				HumanFile old_hf = hfs.queryHumanFileByHufid(Integer.parseInt(mg.getHumanId()));
				old_hf.setCheckStatus(mg.getCheckStatus());
				System.out.println(old_hf.getCheckStatus());
				//更新
				mg.setCheckStatus(mg.getCheckStatus());//此处因改为3
				mcs.modifyMajorChange(mg);
				hfs.modifyHumanFile(old_hf);
				//转跳到审核成功页面
				mav.addObject("checkresultmessage", "<center><h2>审核<bold>未成功</bold>!!<h2></center>");
				mav.setViewName("forward:/submit_major_change_success.jsp");
				
			}
			
			
			
			
		return mav;
		
	}
	
	public Timestamp converttime(String arg0) {
		Date d = new Date(arg0.replace("-", "/")+" 00:00:00");
		long time = d.getTime();//long
		return new Timestamp(time);
	}
	
	
	
	
//	@InitBinder 
//	 public void initBinder(WebDataBinder binder) {  
//	 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
//	 dateFormat.setLenient(false);  
//	 binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，false:不能为空值 
//	 
//	}
}
