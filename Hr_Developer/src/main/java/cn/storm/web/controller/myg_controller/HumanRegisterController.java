package cn.storm.web.controller.myg_controller;

import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.misc.BASE64Decoder;
import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
public class HumanRegisterController {

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
	
	@RequestMapping("/humanfilechecklist.do")
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
