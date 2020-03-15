package cn.storm.web.controller.myg_controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.storm.pojo.ConfigFileFirstKind;
import cn.storm.pojo.ConfigFileSecondKind;
import cn.storm.pojo.ConfigFileThirdKind;
import cn.storm.pojo.ConfigMajor;
import cn.storm.pojo.ConfigMajorKind;
import cn.storm.pojo.ConfigPublicChar;
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
}