package cn.storm.web.controller.myg_controller;

import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sun.misc.BASE64Decoder;
import cn.storm.dto.HumanFileQuerryDto;
import cn.storm.pojo.ConfigFileFirstKind;
import cn.storm.pojo.ConfigFileSecondKind;
import cn.storm.pojo.ConfigFileThirdKind;
import cn.storm.pojo.ConfigMajor;
import cn.storm.pojo.ConfigMajorKind;
import cn.storm.pojo.ConfigPublicChar;
import cn.storm.pojo.HumanFile;
import cn.storm.service.ConfigFileFirstKindService;
import cn.storm.service.ConfigFileSecondKindService;
import cn.storm.service.ConfigFileThirdKindService;
import cn.storm.service.ConfigMajorKindService;
import cn.storm.service.ConfigMajorService;
import cn.storm.service.HumanFileService;
import cn.storm.service.SalaryStandardService;
import cn.storm.util.myg.service.MygConfigPublicCharService;

@Controller
@RequestMapping("/hr")
public class HumanFileController {

	@Autowired
	private ConfigFileFirstKindService configfkfs=null;
	@Autowired
	private ConfigFileSecondKindService configfsks=null;
	@Autowired
	private ConfigFileThirdKindService configftks=null;
	@Autowired
	private HumanFileService humanfs=null;
	@Autowired
	private ConfigMajorService configms = null ;
	@Autowired
	private MygConfigPublicCharService mygconfigpcs=null;
	@Autowired
	private SalaryStandardService salaryss=null;
	@Autowired
	private ConfigMajorKindService configmks=null;
	@Autowired
	public ConfigFileFirstKindService firstKind = null;
	@Autowired
	public ConfigFileSecondKindService secondkind=null;
	@Autowired
	public ConfigFileThirdKindService thirdkind = null;
	@Autowired
	public ConfigMajorKindService majorkind = null;
	@Autowired
	public ConfigMajorService major = null;
	
	/**
	 * first 查询一级机构
	 * 查询职位分类
	 * 查询公共表中字段
	 */
	
	@RequestMapping("/humanfile.do")
	
	public ModelAndView queryfirstkind_register()
	{
		
		Map<String, Object> map = new HashMap<String,Object>();
		
		/**
			查询一级机构
		 */
		List<ConfigFileFirstKind> listconfigfirstkind = configfkfs.queryAllConfigFileFirstKind();
		JSONArray  first = JSONArray.fromObject(listconfigfirstkind);
		
		/**
		 * 查询二级机构
		 */
		List<ConfigFileSecondKind> listconfigsecondkind = configfsks.queryAllConfigFileSecondKind();
		JSONArray  second = JSONArray.fromObject(listconfigsecondkind);
		
		/**
		 * 查询三级机构
		 */
		List<ConfigFileThirdKind> listconfigthridkind = configftks.queryAllConfigFileThirdKind();
		JSONArray  third = JSONArray.fromObject(listconfigthridkind);
		
		/**
		 * 查询职位分类
		 */
		List<ConfigMajor> listconfigmajor = configms.queryAllConfigMajor();
		JSONArray  zwfl = JSONArray.fromObject(listconfigmajor);
		
		/**
		 * 查询职位
		 */
		List<ConfigMajorKind> listmajorkind = configmks.queryAllConfigMajorKind();
		JSONArray  zw = JSONArray.fromObject(listmajorkind);
		
		/**
		 * 职称
		 */
		List<ConfigPublicChar> listzc = mygconfigpcs.queryzc();
		map.put("listzc", listzc);
		
		/**
		 * 国籍
		 */
		List<ConfigPublicChar> listgj = mygconfigpcs.querygj();
		map.put("listgj", listgj);
		
		/**
		 * 民族
		 */
		List<ConfigPublicChar> listmz = mygconfigpcs.querymz();
		map.put("listmz", listmz);

		/**
		 * 宗教信仰
		 */
		List<ConfigPublicChar> listzjxy = mygconfigpcs.queryzjxy();
		map.put("listzjxy", listzjxy);

		/**
		 * 政治面貌
		 */
		List<ConfigPublicChar> listzzmm = mygconfigpcs.queryzzmm();
		map.put("listzzmm", listzzmm);

		
		/**
		 * 学历
		 */
		List<ConfigPublicChar> listxl = mygconfigpcs.queryxl();
		map.put("listxl", listxl);

		/**
		 * 教育年限
		 */
		List<ConfigPublicChar> listjynx = mygconfigpcs.queryjynx();
		map.put("listjynx", listjynx);
		
		/**
		 * 专业
		 */
		List<ConfigPublicChar> listzy = mygconfigpcs.queryzy();
		map.put("listzy", listzy);

		/**
		 * 薪酬标准
		 */
		List<ConfigPublicChar> listxcbz = mygconfigpcs.queryxcbz();
		map.put("listzzmm", listzzmm);
		
		/**
		 * 特长
		 */
		List<ConfigPublicChar> listtc = mygconfigpcs.querytc();
		map.put("listtc", listtc);

		/**
		 * 爱好
		 */
		List<ConfigPublicChar> listah = mygconfigpcs.queryah();
		map.put("listah", listah);

		
		ModelAndView modelview = new ModelAndView();
		modelview.addAllObjects(map);
		
		modelview.addObject("listconfigfirstkind", first.toString());
		modelview.addObject("listconfigsecondkind", second.toString());
		modelview.addObject("listconfigthridkind", third.toString());
		modelview.addObject("listconfigmajor", zwfl.toString());
		modelview.addObject("listmajorkind", zw.toString());
		
		modelview.setViewName("forward:/human_register.jsp");
		
		
		System.out.println("进入了这个contralto。。。。。。");
		return modelview;
	}
	
	@RequestMapping("/humanfilregister.do")
	public ModelAndView add(
			HumanFile humanfile,
			@RequestParam("item.firstKindId") String firstKindId,
			@RequestParam("item.secondKindId") String secondKindId,
			@RequestParam("item.thirdKindId") String thirdKindId,
			@RequestParam("item.humanMajorKindId") String humanMajorKindId,
			@RequestParam("item.hunmaMajorId") String hunmaMajorId,
			@RequestParam("item.humanProDesignation") String humanProDesignations,
			@RequestParam("item.humanName") String humanNames,
			@RequestParam("item.humanSex") String humanSexs,
			@RequestParam("item.humanEmail") String humanEmails,
			@RequestParam("item.humanTelephone") String humanTelephones,
			@RequestParam("item.humanQq") String humanQqs,
			@RequestParam("item.humanMobilephone") String humanMobilephones,
			@RequestParam("item.humanAddress") String humanAddresss,
			@RequestParam("item.humanPostcode") String humanPostcodes,
			@RequestParam("item.humanNationality") String humanNationalitys,
			@RequestParam("item.humanBirthplace") String humanBirthplaces,
			@RequestParam("item.str_humanBirthday") String str_humanBirthdays,
			@RequestParam("item.humanRace") String humanRaces,
			@RequestParam("item.humanReligion") String humanReligions,
			@RequestParam("item.humanParty") String humanPartys,
			@RequestParam("item.humanIdCard") String humanIdCards,
			@RequestParam("item.humanSocietySecurityId") String humanSocietySecurityIds,
			@RequestParam("item.humanAge") String humanAges,
			@RequestParam("item.humanEducatedDegree") String humanEducatedDegrees,
			@RequestParam("item.humanEducatedYears") String humanEducatedYearss,
			@RequestParam("item.humanEducatedMajor") String humanEducatedMajors,
			@RequestParam("item.salaryStandardName") String salaryStandardNames,
			@RequestParam("item.humanBank") String humanBanks,
			@RequestParam("item.humanAccount") String humanAccounts,
			@RequestParam("item.register") String registers,
			@RequestParam("item.str_registTime") String str_registTimes,
			@RequestParam("item.humanSpeciality") String humanSpecialitys,
			@RequestParam("item.humanHobby") String humanHobbys,
			@RequestParam("item.humanHistroyRecords") String humanHistroyRecordss,
			@RequestParam("item.humanFamilyMembership") String humanFamilyMemberships,
			@RequestParam("item.remark") String remarks,
			@RequestParam("item.picture") String picture,
			HttpServletRequest request,
			HttpSession session,
			HttpServletResponse response	)throws Exception
	{
		
//		System.out.println("三级机构："+thirdKindId);
//		System.out.println("职位分类："+humanMajorKindId);
//		System.out.println("职位："+hunmaMajorId);
//		
		if(picture!=null && picture.equals(""))
		{
			//解码图片并上传	
			int index = picture.indexOf(",");
			picture = picture.substring(index+1);
			System.out.println("我的图片："+picture);
			String path = session.getServletContext().getRealPath("/upload");
			System.out.println("我的图片保存路径："+path);
			BASE64Decoder decoder = new BASE64Decoder();
			byte [] b = decoder.decodeBuffer(picture);
			String uuid = UUID.randomUUID().toString();
			FileOutputStream fos = new FileOutputStream(path+uuid+".jpg");
			fos.write(b);
			fos.flush();
			fos.close();
			System.out.println("上传完毕！");
			
		}
		/**
		 * 一级机构的ID
		 */
		String fileFirstKindName=firstKind.selectIdByNames(firstKindId);
		System.out.println("一级机构："+fileFirstKindName);
		/**
		 * 二级机构的id
		 */
		String secondName = secondkind.queryNameByFirstIdAndSecondId(firstKindId, secondKindId);
		System.out.println("二级机构："+secondName);
		/**
		 * 三级机构
		 */
		String thirdName = thirdkind.querryNamesByFirstSceondThrid(firstKindId, secondKindId, thirdKindId);
		System.out.println("三级机构："+thirdName);
		/**
		 * 职称分类
		 */
		String majorkindName= majorkind.querryIdByNames(humanMajorKindId);
		System.out.println("职位分类："+majorkindName);
		/**
		 * 职位
		 */
		String majorName = major.queryNamesByIds(humanMajorKindId, hunmaMajorId);
		System.out.println("职位："+majorName);
		/**
		 * 开始给humanfile赋值
		 */
		//一级机构
		humanfile.setFirstKindName(fileFirstKindName);
		humanfile.setFirstKindId(firstKindId);
		//二级机构
		humanfile.setSecondKindName(secondName);
		humanfile.setSecondKindId(secondKindId);
		//三级机构
		humanfile.setThirdKindName(thirdName);
		humanfile.setThirdKindId(thirdKindId);
		//职位分类
		humanfile.setHumanMajorKindName(majorkindName);
		humanfile.setHumanMajorKindId(humanMajorKindId);
		//职位
		humanfile.setHunmaMajorName(majorName);
		humanfile.setHumanMajorId(hunmaMajorId);
		//职称
		humanfile.setHumanProDesignation(humanProDesignations);
		//姓名
		humanfile.setHumanName(humanNames);
		//性别
		humanfile.setHumanSex(humanSexs);
		//邮箱
		humanfile.setHumanEmail(humanEmails);
		//电话
		humanfile.setHumanTelephone(humanTelephones);
		//QQ
		humanfile.setHumanQq(humanQqs);
		//手机
		humanfile.setHumanMobilephone(humanMobilephones);
		//住址
		humanfile.setHumanAddress(humanAddresss);
		//邮编
		humanfile.setHumanPostcode(humanPostcodes);
		//国籍
		humanfile.setHumanNationality(humanNationalitys);
		//出生地
		humanfile.setHumanBirthplace(humanBirthplaces);
		//生日
		humanfile.setHumanBirthday(converttime(str_humanBirthdays, 1));
		//民族
		humanfile.setHumanRace(humanRaces);
		//宗教信仰
		humanfile.setHumanReligion(humanReligions);
		//政治面貌
		humanfile.setHumanParty(humanPartys);
		//身份证
		humanfile.setHumanIdCard(humanIdCards);
		//社会保障号码
		humanfile.setHumanSocietySecurityId(humanSocietySecurityIds);
		//年龄
		humanfile.setHumanAge(Short.parseShort(humanAges));
		//学历
		humanfile.setHumanEducatedDegree(humanEducatedDegrees);
		//教育年限
		humanfile.setHumanEducatedYears(Short.parseShort(humanEducatedYearss));
		//学历专业
		humanfile.setHumanEducatedMajor(humanEducatedMajors);
		//薪酬标准
		humanfile.setSalaryStandardName(salaryStandardNames);
		//开户行
		humanfile.setHumanBank(humanBanks);
		//账号
		humanfile.setHumanAccount(humanAccounts);
		//登记人
		humanfile.setRegister(registers);
		//建档时间
		humanfile.setRegistTime(converttime(str_registTimes, 2));
		//特长
		humanfile.setHumanSpeciality(humanSpecialitys);
		//爱好
		humanfile.setHumanHobby(humanHobbys);
		//个人履历
		humanfile.setHumanHistroyRecords(humanHistroyRecordss);
		//家庭关系
		humanfile.setHumanFamilyMembership(humanFamilyMemberships);
		//备注
		humanfile.setRemark(remarks);
		//照片
		humanfile.setHumanPicture(picture);
		//humanid
		String humanid = UUID.randomUUID().toString();
		humanfile.setHumanId(humanid);	
		//checkstatus
		humanfile.setCheckStatus((short) 1);
		//checkTime
		humanfile.setCheckTime(null);
		//changeTime
		humanfile.setChangeTime(null);
		//lastlyChangeTime
		humanfile.setLastlyChangeTime(null);
		//deleteTime
		humanfile.setDeleteTime(null);
		//recoveryTime
		humanfile.setRecoveryTime(null);
		//删除状态,1是未进行操作的状态
		humanfile.setHumanFileStatus((short)1);
		System.out.println("打印humanfile："+humanfile);
		ModelAndView model = new ModelAndView();
		boolean flag = humanfs.addHumanFiles(humanfile);
		if(flag=true)
		{
			System.out.println("插入成功");
			model.setViewName("forward:/humanfileregistersuccess.jsp");
			return model;
		}
		if(flag==false)
		{
			System.out.println("插入失败");
			model.setViewName("forward:/commomerror.jsp");
			return model;
		}
		return model;
	}
	
	@RequestMapping("/humanfilecheckshow.do")
	public ModelAndView humanFileCheck(Map m)
	{
		//查询所有待复核状态的档案
		ModelAndView model = new ModelAndView();
		List<HumanFile> humanlist = humanfs.queryAllHumanFileBycheckstu();
		System.out.println("======="+humanlist);
		m.put("humanlist", humanlist);
		 model.setViewName("forward:/check_list.jsp");
		 return model;
		
	}
	
	
	@RequestMapping("/humanfilequery.do")
	public ModelAndView humanHileQuery(Map map ,String huid,HttpServletRequest request,HttpSession session)
	{
		String path = session.getServletContext().getRealPath("/upload");
		System.out.println("图片保存的路径："+path);
		System.out.println("我的档案编号："+huid);
		ModelAndView model = new ModelAndView();
		if(huid!=null)
		{
			HumanFile humanf =  humanfs.queryByhumanid(huid);
			String pic = humanf.getHumanPicture();
			pic =  session.getServletContext().getRealPath("/upload/")+pic;
			request.getSession().setAttribute("pic", pic);
			
			map.put("humanf", humanf);
			
			/**
			 * 职称
			 */
			List<ConfigPublicChar> listzc = mygconfigpcs.queryzc();
			map.put("listzc", listzc);
			
			/**
			 * 国籍
			 */
			List<ConfigPublicChar> listgj = mygconfigpcs.querygj();
			map.put("listgj", listgj);
			
			/**
			 * 民族
			 */
			List<ConfigPublicChar> listmz = mygconfigpcs.querymz();
			map.put("listmz", listmz);

			/**
			 * 宗教信仰
			 */
			List<ConfigPublicChar> listzjxy = mygconfigpcs.queryzjxy();
			map.put("listzjxy", listzjxy);

			/**
			 * 政治面貌
			 */
			List<ConfigPublicChar> listzzmm = mygconfigpcs.queryzzmm();
			map.put("listzzmm", listzzmm);

			
			/**
			 * 学历
			 */
			List<ConfigPublicChar> listxl = mygconfigpcs.queryxl();
			map.put("listxl", listxl);

			/**
			 * 教育年限
			 */
			List<ConfigPublicChar> listjynx = mygconfigpcs.queryjynx();
			map.put("listjynx", listjynx);
			
			/**
			 * 专业
			 */
			List<ConfigPublicChar> listzy = mygconfigpcs.queryzy();
			map.put("listzy", listzy);

			/**
			 * 薪酬标准
			 */
			List<ConfigPublicChar> listxcbz = mygconfigpcs.queryxcbz();
			map.put("listzzmm", listzzmm);
			
			/**
			 * 特长
			 */
			List<ConfigPublicChar> listtc = mygconfigpcs.querytc();
			map.put("listtc", listtc);

			/**
			 * 爱好
			 */
			List<ConfigPublicChar> listah = mygconfigpcs.queryah();
			map.put("listah", listah);
			
			model.setViewName("forward:/human_check.jsp");
		}
		else
		{
			model.setViewName("forward:/commomerror.jsp");
		}
		return model;
	}
	
	@RequestMapping("/humancheckfile.do")
	public ModelAndView humanFileCheckOkOrNo(
			@RequestParam("item.humanProDesignation") String humanProDesignation,
			@RequestParam("item.humanName") String humanName,
			@RequestParam("item.humanSex") String humanSex,
			@RequestParam("item.humanEmail") String humanEmail,
			@RequestParam("item.humanTelephone") String humanTelephone,
			@RequestParam("item.humanQq") String humanQq,
			@RequestParam("item.humanMobilephone") String humanMobilephone,
			@RequestParam("item.humanPostcode") String humanPostcode,
			@RequestParam("item.humanAddress") String humanAddress,
			@RequestParam("item.humanNationality") String humanNationality,
			@RequestParam("item.humanBirthplace") String humanBirthplace,
			@RequestParam("item.humanBirthday") String humanBirthday,
			@RequestParam("item.humanRace") String humanRace,
			@RequestParam("item.humanReligion") String humanReligion,
			@RequestParam("item.humanParty") String humanParty,
			@RequestParam("item.humanIdCard") String humanIdCard,
			@RequestParam("item.humanSocietySecurityId") String humanSocietySecurityId,
			@RequestParam("item.humanAge") String humanAge,
			@RequestParam("item.humanEducatedDegree") String humanEducatedDegree,
			@RequestParam("item.humanEducatedYears") String humanEducatedYears,
			@RequestParam("item.humanEducatedMajor") String humanEducatedMajor,
			@RequestParam("item.humanBank") String humanBank,
			@RequestParam("item.humanAccount") String humanAccount,
			@RequestParam("item.checkTime") String checkTime,
			@RequestParam("item.humanSpeciality") String humanSpeciality,
			@RequestParam("item.humanHobby") String humanHobby,
			@RequestParam("item.humanHistroyRecords") String humanHistroyRecords,
			@RequestParam("item.humanFamilyMembership") String humanFamilyMembership,
			@RequestParam("item.remark") String remark,
			@RequestParam("item.huid") String huids
			)
	{
		HumanFile newHumanfiles = new HumanFile();
		//档案编号
		newHumanfiles.setHumanId(huids);
		System.out.println("我的档案编号：====="+huids);
		//职称
		newHumanfiles.setHumanProDesignation(humanProDesignation);
		System.out.println("我的职称：======="+humanProDesignation);
		//姓名
		newHumanfiles.setHumanName(humanName);
		System.out.println("我的职称：======="+humanName);
		//性别
		newHumanfiles.setHumanSex(humanSex);
		System.out.println("我的职称：======="+humanSex);
		//邮箱
		newHumanfiles.setHumanEmail(humanEmail);
		System.out.println("我的职称：======="+humanEmail);
		//电话
		newHumanfiles.setHumanTelephone(humanTelephone);
		System.out.println("我的职称：======="+humanTelephone);
		//QQ
		newHumanfiles.setHumanQq(humanQq);
		System.out.println("我的职称：======="+humanQq);
		//手机号码
		newHumanfiles.setHumanMobilephone(humanMobilephone);
		System.out.println("我的职称：======="+humanMobilephone);
		//邮编
		newHumanfiles.setHumanPostcode(humanPostcode);
		System.out.println("我的职称：======="+humanPostcode);
		//地址
		newHumanfiles.setHumanAddress(humanAddress);
		System.out.println("我的职称：======="+humanAddress);
		//国籍
		newHumanfiles.setHumanNationality(humanNationality);
		System.out.println("我的职称：======="+humanNationality);
		//出生地址
		newHumanfiles.setHumanBirthplace(humanBirthplace);
		System.out.println("我的职称：======="+humanBirthplace);
		//生日
		String mybirthday = (String) humanBirthday.subSequence(0, humanBirthday.indexOf(" "));
		newHumanfiles.setHumanBirthday(converttime(mybirthday,1));
		System.out.println("我的生日："+mybirthday+"================"+converttime(mybirthday, 1));
		//民族
		newHumanfiles.setHumanRace(humanRace);
		System.out.println("我的职称：======="+humanRace);
		//宗教信仰
		newHumanfiles.setHumanReligion(humanReligion);
		//政治面貌
		newHumanfiles.setHumanParty(humanParty);
		//身份证
		newHumanfiles.setHumanIdCard(humanIdCard);
		//设保证
		newHumanfiles.setHumanSocietySecurityId(humanSocietySecurityId);
		//年龄
		System.out.println("我的年龄：=========="+humanAge);
		newHumanfiles.setHumanAge(Short.parseShort(humanAge));
		//学历
		newHumanfiles.setHumanEducatedDegree(humanEducatedDegree);
		//教育年限
		newHumanfiles.setHumanEducatedYears(Short.parseShort(humanEducatedYears));
		//学历专业
		newHumanfiles.setHumanEducatedMajor(humanEducatedMajor);
		//开户行
		newHumanfiles.setHumanBank(humanBank);
		//账号
		newHumanfiles.setHumanAccount(humanAccount);
		//复合时间
		newHumanfiles.setCheckTime(converttime(checkTime, 2));
		System.out.println("我的复核时间："+checkTime+"======================"+converttime(checkTime, 2));
		//特长
		newHumanfiles.setHumanSpeciality(humanSpeciality);
		//爱好
		newHumanfiles.setHumanHobby(humanHobby);
		//个人履历
		newHumanfiles.setHumanHistroyRecords(humanHistroyRecords);
		//家庭关系
		newHumanfiles.setHumanFamilyMembership(humanFamilyMembership);
		//备注
		newHumanfiles.setRemark(remark);
		//设置审核时间
		newHumanfiles.setCheckStatus(Short.parseShort("2"));
		boolean flags =	humanfs.modifysHumanFile(newHumanfiles);
		ModelAndView model = new ModelAndView();
		if(flags==true)
		{
			model.setViewName("forward:/humanfilechecksuccess.jsp");
			System.out.println("档案更新完成"+"=======================");
		}
		else
		{
			model.setViewName("forward:/commomerror.jsp");
			System.out.println("档案更新失败！数据紊乱！"+"==================");
		}
		return model;
	}
	
	@RequestMapping("/humanfilequerry.do")
	/**
	 * 展示查询可变更职位的职员的controller
	 * 首先需要查询系统中状态为"正常"的员工。查询条件包括：员工所在机构和建档时间。
	 * @return
	 */
	public ModelAndView showChangePage(){
		ModelAndView modelview = new ModelAndView();
		/**
		查询一级机构
	 */
	List<ConfigFileFirstKind> listconfigfirstkind = configfkfs.queryAllConfigFileFirstKind();
	JSONArray  first = JSONArray.fromObject(listconfigfirstkind);
	
	/**
	 * 查询二级机构
	 */
	List<ConfigFileSecondKind> listconfigsecondkind = configfsks.queryAllConfigFileSecondKind();
	JSONArray  second = JSONArray.fromObject(listconfigsecondkind);
	
	/**
	 * 查询三级机构
	 */
	List<ConfigFileThirdKind> listconfigthridkind = configftks.queryAllConfigFileThirdKind();
	JSONArray  third = JSONArray.fromObject(listconfigthridkind);
	
	/**
	 * 查询职位分类
	 */
	List<ConfigMajor> listconfigmajor = configms.queryAllConfigMajor();
	JSONArray  zwfl = JSONArray.fromObject(listconfigmajor);
	
	/**
	 * 查询职位
	 */
	List<ConfigMajorKind> listmajorkind = configmks.queryAllConfigMajorKind();
	JSONArray  zw = JSONArray.fromObject(listmajorkind);
		modelview.addObject("listconfigfirstkind", first.toString());
		modelview.addObject("listconfigsecondkind", second.toString());
		modelview.addObject("listconfigthridkind", third.toString());
		modelview.addObject("listconfigmajor", zwfl.toString());
		modelview.addObject("listmajorkind", zw.toString());
		modelview.setViewName("forward:/query_locate.jsp");
		return modelview;
	}
	
	
	
	@RequestMapping("formquerry.do")
	public ModelAndView toShowQuerry(@RequestParam("item.firstKindId") String firstKindId,
			@RequestParam("item.secondKindId") String secondKindId,
			@RequestParam("item.thirdKindId") String thirdKindId,
			@RequestParam("item.humanMajorKindName") String humanMajorKindId,
			@RequestParam("item.hunmaMajorName") String hunmaMajorId,
			@RequestParam("item.str_startTime") String begintime,
			@RequestParam("item.str_endTime") String endtime)
	{
		HumanFileQuerryDto hfqd = new HumanFileQuerryDto();
		hfqd.setFirstkindid(firstKindId);
		hfqd.setSecondkindid(secondKindId);
		hfqd.setThirdkindid(thirdKindId);
		hfqd.setMajorkindid(humanMajorKindId);
		hfqd.setMajorid(hunmaMajorId);
		hfqd.setBegintime(converttime(begintime));
		hfqd.setEndtime(converttime(endtime));
		
		List<HumanFile> humanfileqd = humanfs.querryByHumanFileDto(hfqd);
		System.out.println("查出符合条件的为："+humanfileqd);
		ModelAndView model = new ModelAndView();
		model.addObject("humanfileqd", humanfileqd);
		model.setViewName("forward:/query_list.jsp");

		return model;
	}
	
	/**
	 * 通过关键字查找员工人力资源的档案
	 * @return
	 */
	@RequestMapping("/humannamesearch.do")
	public ModelAndView toHumanFileKeyWordsSearch(@RequestParam("keywords") String keywords)
	{
		HumanFile humanfile = humanfs.querryHumanFileByNames(keywords);
		ModelAndView model = new ModelAndView();
		model.addObject("humanfilebykey", humanfile);
		model.setViewName("forward:/query_list_bykeywords.jsp");
		return model;
	}
	
	@RequestMapping("/humanfilechange.do")
	public ModelAndView humanfileChange()
	{
		ModelAndView model = new ModelAndView();
		List<HumanFile> humanlists = humanfs.queryAllHumanFile();
		model.addObject("humanlists", humanlists);
		model.setViewName("forward:/change_locate.jsp");
		return model;
	}
	
	/**
	 * 档案变更
	 * @param huid
	 * @return
	 */
	@RequestMapping("/humanfilechangeing.do")
	public ModelAndView showHumanFileChange(String huid,HttpSession session , Map map ,HttpServletRequest request)
	{
		ModelAndView model =new ModelAndView();
		System.out.println("我的档案编号："+huid+"========");
		String path = session.getServletContext().getRealPath("/upload");
		System.out.println("图片保存的路径："+path);
		System.out.println("我的档案编号："+huid);
		if(huid!=null)
		{
			HumanFile humanf =  humanfs.queryByhumanid(huid);
			String pic = humanf.getHumanPicture();
			pic =  session.getServletContext().getRealPath("/upload/")+pic;
			request.getSession().setAttribute("pic", pic);
			
			map.put("humanf", humanf);
			
			/**
			 * 职称
			 */
			List<ConfigPublicChar> listzc = mygconfigpcs.queryzc();
			map.put("listzc", listzc);
			
			/**
			 * 国籍
			 */
			List<ConfigPublicChar> listgj = mygconfigpcs.querygj();
			map.put("listgj", listgj);
			
			/**
			 * 民族
			 */
			List<ConfigPublicChar> listmz = mygconfigpcs.querymz();
			map.put("listmz", listmz);

			/**
			 * 宗教信仰
			 */
			List<ConfigPublicChar> listzjxy = mygconfigpcs.queryzjxy();
			map.put("listzjxy", listzjxy);

			/**
			 * 政治面貌
			 */
			List<ConfigPublicChar> listzzmm = mygconfigpcs.queryzzmm();
			map.put("listzzmm", listzzmm);

			
			/**
			 * 学历
			 */
			List<ConfigPublicChar> listxl = mygconfigpcs.queryxl();
			map.put("listxl", listxl);

			/**
			 * 教育年限
			 */
			List<ConfigPublicChar> listjynx = mygconfigpcs.queryjynx();
			map.put("listjynx", listjynx);
			
			/**
			 * 专业
			 */
			List<ConfigPublicChar> listzy = mygconfigpcs.queryzy();
			map.put("listzy", listzy);

			/**
			 * 薪酬标准
			 */
			List<ConfigPublicChar> listxcbz = mygconfigpcs.queryxcbz();
			map.put("listzzmm", listzzmm);
			
			/**
			 * 特长
			 */
			List<ConfigPublicChar> listtc = mygconfigpcs.querytc();
			map.put("listtc", listtc);

			/**
			 * 爱好
			 */
			List<ConfigPublicChar> listah = mygconfigpcs.queryah();
			map.put("listah", listah);
			model.setViewName("forward:/change_list_information.jsp");
		}
		else
		{
			model.setViewName("forward:/commomerror.jsp");
		}
		return model;
	}
	
	@RequestMapping("/humanfilechangesave.do")
	public ModelAndView humanFileChangeSave(
			@RequestParam("item.humanProDesignation") String humanProDesignation,
			@RequestParam("item.humanName") String humanName,
			@RequestParam("item.humanSex") String humanSex,
			@RequestParam("item.humanEmail") String humanEmail,
			@RequestParam("item.humanTelephone") String humanTelephone,
			@RequestParam("item.humanQq") String humanQq,
			@RequestParam("item.humanMobilephone") String humanMobilephone,
			@RequestParam("item.humanPostcode") String humanPostcode,
			@RequestParam("item.humanAddress") String humanAddress,
			@RequestParam("item.humanNationality") String humanNationality,
			@RequestParam("item.humanBirthplace") String humanBirthplace,
			@RequestParam("item.humanBirthday") String humanBirthday,
			@RequestParam("item.humanRace") String humanRace,
			@RequestParam("item.humanReligion") String humanReligion,
			@RequestParam("item.humanParty") String humanParty,
			@RequestParam("item.humanIdCard") String humanIdCard,
			@RequestParam("item.humanSocietySecurityId") String humanSocietySecurityId,
			@RequestParam("item.humanAge") String humanAge,
			@RequestParam("item.humanEducatedDegree") String humanEducatedDegree,
			@RequestParam("item.humanEducatedYears") String humanEducatedYears,
			@RequestParam("item.humanEducatedMajor") String humanEducatedMajor,
			@RequestParam("item.humanBank") String humanBank,
			@RequestParam("item.humanAccount") String humanAccount,
			@RequestParam("item.checkTime") String checkTime,
			@RequestParam("item.humanSpeciality") String humanSpeciality,
			@RequestParam("item.humanHobby") String humanHobby,
			@RequestParam("item.humanHistroyRecords") String humanHistroyRecords,
			@RequestParam("item.humanFamilyMembership") String humanFamilyMembership,
			@RequestParam("item.remark") String remark,
			@RequestParam("item.huid") String huids
			)
	{
		HumanFile newHumanfiles = new HumanFile();
		//档案编号
		newHumanfiles.setHumanId(huids);
		System.out.println("我的档案编号：====="+huids);
		//职称
		newHumanfiles.setHumanProDesignation(humanProDesignation);
		System.out.println("我的职称：======="+humanProDesignation);
		//姓名
		newHumanfiles.setHumanName(humanName);
		System.out.println("我的职称：======="+humanName);
		//性别
		newHumanfiles.setHumanSex(humanSex);
		System.out.println("我的职称：======="+humanSex);
		//邮箱
		newHumanfiles.setHumanEmail(humanEmail);
		System.out.println("我的职称：======="+humanEmail);
		//电话
		newHumanfiles.setHumanTelephone(humanTelephone);
		System.out.println("我的职称：======="+humanTelephone);
		//QQ
		newHumanfiles.setHumanQq(humanQq);
		System.out.println("我的职称：======="+humanQq);
		//手机号码
		newHumanfiles.setHumanMobilephone(humanMobilephone);
		System.out.println("我的职称：======="+humanMobilephone);
		//邮编
		newHumanfiles.setHumanPostcode(humanPostcode);
		System.out.println("我的职称：======="+humanPostcode);
		//地址
		newHumanfiles.setHumanAddress(humanAddress);
		System.out.println("我的职称：======="+humanAddress);
		//国籍
		newHumanfiles.setHumanNationality(humanNationality);
		System.out.println("我的职称：======="+humanNationality);
		//出生地址
		newHumanfiles.setHumanBirthplace(humanBirthplace);
		System.out.println("我的职称：======="+humanBirthplace);
		//生日
		String mybirthday = (String) humanBirthday.subSequence(0, humanBirthday.indexOf(" "));
		newHumanfiles.setHumanBirthday(converttime(mybirthday,1));
		System.out.println("我的生日："+mybirthday+"================"+converttime(mybirthday, 1));
		//民族
		newHumanfiles.setHumanRace(humanRace);
		System.out.println("我的职称：======="+humanRace);
		//宗教信仰
		newHumanfiles.setHumanReligion(humanReligion);
		//政治面貌
		newHumanfiles.setHumanParty(humanParty);
		//身份证
		newHumanfiles.setHumanIdCard(humanIdCard);
		//设保证
		newHumanfiles.setHumanSocietySecurityId(humanSocietySecurityId);
		//年龄
		System.out.println("我的年龄：=========="+humanAge);
		newHumanfiles.setHumanAge(Short.parseShort(humanAge));
		//学历
		newHumanfiles.setHumanEducatedDegree(humanEducatedDegree);
		//教育年限
		newHumanfiles.setHumanEducatedYears(Short.parseShort(humanEducatedYears));
		//学历专业
		newHumanfiles.setHumanEducatedMajor(humanEducatedMajor);
		//开户行
		newHumanfiles.setHumanBank(humanBank);
		//账号
		newHumanfiles.setHumanAccount(humanAccount);
		//复合时间
		newHumanfiles.setCheckTime(converttime(checkTime, 2));
		System.out.println("我的复核时间："+checkTime+"======================"+converttime(checkTime, 2));
		//特长
		newHumanfiles.setHumanSpeciality(humanSpeciality);
		//爱好
		newHumanfiles.setHumanHobby(humanHobby);
		//个人履历
		newHumanfiles.setHumanHistroyRecords(humanHistroyRecords);
		//家庭关系
		newHumanfiles.setHumanFamilyMembership(humanFamilyMembership);
		//备注
		newHumanfiles.setRemark(remark);
		//设置审核时间
		newHumanfiles.setCheckStatus(Short.parseShort("2"));
		boolean flags =	humanfs.modifyHumanFileChange(newHumanfiles);
		ModelAndView model = new ModelAndView();
		if(flags==true)
		{
			model.setViewName("forward:/humanfilechangesuccess.jsp");
			System.out.println("档案更新完成"+"=======================");
		}
		else
		{
			model.setViewName("forward:/commomerror.jsp");
			System.out.println("档案更新失败！数据紊乱！"+"==================");
		}
		return model;
	}
	
	//人力资源档案删除,查询可删除的档案
	@RequestMapping("/humanfiledeletelist.do")
	public ModelAndView selectHumanFileByDeletestaus()
	{
		ModelAndView model =new ModelAndView();
		short a=1;
		List<HumanFile> humanlist = humanfs.queryAllHumanFileByDeletestu(a);
		System.out.println("======="+humanlist);
		model.addObject("humanlist", humanlist);
		model.setViewName("forward:/delete_locate.jsp");
		return model;
	}
	
	@RequestMapping("/humanfiledelete.do")
	/**
	 * 删除档案，并更新删除档案的状态
	 * @param arg0
	 * @return
	 */
	public ModelAndView deleteHumanFile(String huid)
	{
		HumanFile humanfile = humanfs.queryByhumanid(huid);
		//设置状态为2，状态为2表示可以恢复，状态为1表示从未删除
		humanfile.setHumanFileStatus((short)2);
		//设置删除时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String nowtime = df.format(new Date());
		humanfile.setDeleteTime(converttime(nowtime, 2));
		boolean flag = humanfs.modifyHumanFilesWithDeleteStatus(humanfile);
		ModelAndView model = new ModelAndView();
		if(flag==true)
		{
			model.setViewName("forward:/deletesuccess.jsp");
			return model;
		}
		if(flag==false)
		{
			model.setViewName("forward:/commomerror.jsp");
		}
		return model;
	}
	
	
	
	
	/**
	 * 档案删除恢复
	 * @param arg0
	 * @param type
	 * @return
	 */
	@RequestMapping("/recoverhumanfiles.do")
	public ModelAndView recoverHumanFile()
	{
		ModelAndView model =new ModelAndView();
		short a=2;
		List<HumanFile> humanlist = humanfs.queryAllHumanFileByDeletestu(a);
		System.out.println("======="+humanlist);
		model.addObject("humanlist", humanlist);
		model.setViewName("forward:/recovery_locate.jsp");
		return model;
	}
	
	/**
	 * 恢复
	 * @param arg0
	 * @return
	 */
	@RequestMapping("/humanfilerecovery.do")
	public ModelAndView recoverHumanFile(String huid)
	{
		HumanFile humanfile = humanfs.queryByhumanid(huid);
		//设置状态为2，状态为2表示可以恢复，状态为1表示从未删除
		humanfile.setHumanFileStatus((short)1);
		//设置删除时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String nowtime = df.format(new Date());
		humanfile.setRecoveryTime(converttime(nowtime, 2));
		boolean flag = humanfs.modifyHumanFileRecovery(humanfile);
		ModelAndView model = new ModelAndView();
		if(flag==true)
		{
			model.setViewName("forward:/humanfilerecoverysuccess.jsp");
			return model;
		}
		if(flag==false)
		{
			model.setViewName("forward:/commomerror.jsp");
		}
		return model;
	}
	
	/**
	 * 人力资源永久删除显示
	 * @param arg0
	 * @return
	 */
	@RequestMapping("/deleteforver.do")
	public ModelAndView showDeleteHumanFileForver()
	{
		ModelAndView model =new ModelAndView();
		List<HumanFile> humanlist = humanfs.queryAllHumanFile();
		System.out.println("======="+humanlist);
		model.addObject("humanlist", humanlist);
		model.setViewName("forward:/delete_forever_list.jsp");
		return model;
	}
	
	/**
	 * 永久删除
	 * @param arg0
	 * @return
	 */
	@RequestMapping("/deletefilesforvery.do")
	public ModelAndView deleteForver(String huid)
	{
		boolean flag = humanfs.removeHumanFileByhuid(huid);
		ModelAndView model = new ModelAndView();
		if(flag==true)
		{
			model.setViewName("forward:/deleteforverysuccess.jsp");
			return model;
		}
		if(flag==false)
		{
			model.setViewName("forward:/commomerror.jsp");
			return model;
		}
		return model;
	}
	
	
	
	
	
	
	
	public Timestamp converttime(String arg0) {
		Date d = new Date(arg0.replace("-", "/")+" 00:00:00");
		long time = d.getTime();//long
		return new Timestamp(time);
	}
	public Timestamp converttime(String arg0,int type) {
		System.out.println(arg0);
		Date d = null;
		if(type == 1 )
		{
			d = new Date(arg0.replace("-", "/")+" 00:00:00");
		}
		else if(type==2)
		{
			d = new Date(arg0.replace("-", "/"));
		}
		long time = d.getTime();//long
		return new Timestamp(time);
	}
//	public static void main(String[] args) {
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//		String nowtime = df.format(new Date());
//		System.out.println(converttime(nowtime,2));
//	}

}
