package cn.storm.web.controller.kqx_controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.storm.dto.Xcxm;
import cn.storm.pojo.SalaryStandard;
import cn.storm.service.ConfigPublicCharService;
import cn.storm.service.SalaryStandardDetailsService;
import cn.storm.service.SalaryStandardService;

/**
 * 
 * @author
 * 
 */
@Controller
public class SalaryStandardCheckController {
	private List<SalaryStandard> slist;
	@Autowired
	private ConfigPublicCharService cpcs;
	@Autowired
	private SalaryStandardService sss;
	@Autowired
	private SalaryStandardDetailsService ssds;
	private SalaryStandard cstandardid;

	private Object sid;

	private Object String;

	// 点击薪酬标准登记复核时执行的方法
	@RequestMapping("/toqueryf.do")
	public String queryf(Map map) {
		slist = sss.queryAllSalaryStandard();
		map.put("sslist", slist);
		map.put("count", slist.size());
		return "salarystandard_check_list";
	}

	// 在薪酬标准登记复核中点击复核执行的方法
	@RequestMapping("/queryfh.do")
	public String queryfh(Map map, String sstid) {
		SalaryStandard sa = sss.querySalaryStandardBySsd(sstid);
		map.put("sa", sa);
		List<Xcxm> salist = ssds.querystid(sa);
		map.put("slist", salist);
		map.put("sstid", sstid);
		return "salarystandard_check";
	}

	// 在薪酬标准登记复核中点击复核通过执行的方法
	@RequestMapping("/updatexc.do")
	public String updatexc(SalaryStandard sa, Map map,
			@RequestParam List<Double> csum, @RequestParam List<Integer> pbcid,
			@RequestParam List<String> name, @RequestParam String standardName,
			@RequestParam String checker, @RequestParam String checkComment,
			@RequestParam String standardId) {

		Date date = new Date();
		Timestamp nousedate = new Timestamp(date.getTime());
		double count = 0;
		for (int i = 0; i < csum.size(); i++) {
			count += csum.get(i);
		}
		sa.setStandardId(standardId);
		sa.setStandardName(standardName);
		sa.setChecker(checker);
		sa.setCheckComment(checkComment);
		sa.setCheckTime(nousedate);
		sa.setSalarySum(count);
		sss.updatesa(sa);
		ssds.deleteByStandardId(sa.getStandardId());
		for (int i = 0; i < pbcid.size(); i++) {
			String name2 = name.get(i);
			int pid = pbcid.get(i);// id
			double money = csum.get(i);
			Map map2 = new HashMap();
			map2.put("item_name", name2);
			map2.put("standard_id", sa.getStandardId());
			map2.put("standard_name", sa.getStandardName());
			map2.put("item_id", pid);
			map2.put("salary", money);
			ssds.add(map2);
		}

		return "salarystandard_check_success";
	}

	// 在薪酬标准变更列表中点击变更执行的方法
	@RequestMapping("/change.do")
	public String change(Map map, String sstid) {
		SalaryStandard sa = sss.querySalaryStandardBySsd(sstid);
		map.put("sa", sa);
		List<Xcxm> salist = ssds.querystid(sa);
		map.put("slist", salist);
		map.put("sstid", sstid);
		return "salarystandard_change";
	}

	// 在薪酬标准变更中点击重新提交的方法
	@RequestMapping("/upchange.do")
	public String upchange(SalaryStandard sa, Map map,
			@RequestParam List<Double> csum, @RequestParam List<Integer> pbcid,
			@RequestParam List<String> name, @RequestParam String standardName,
			@RequestParam String changer, @RequestParam String remark,
			@RequestParam String standardId) {

		Date date = new Date();
		Timestamp nousedate = new Timestamp(date.getTime());
		double count = 0;
		for (int i = 0; i < csum.size(); i++) {
			count += csum.get(i);
		}
		sa.setStandardId(standardId);
		sa.setStandardName(standardName);
		sa.setChanger(changer);
		sa.setRemark(remark);
		sa.setChangeTime(nousedate);
		sa.setSalarySum(count);
		sss.updatechange(sa);
		ssds.deleteByStandardId(sa.getStandardId());
		for (int i = 0; i < pbcid.size(); i++) {
			String name2 = name.get(i);
			int pid = pbcid.get(i);// id
			double money = csum.get(i);
			Map map2 = new HashMap();
			map2.put("item_name", name2);
			map2.put("standard_id", sa.getStandardId());
			map2.put("standard_name", sa.getStandardName());
			map2.put("item_id", pid);
			map2.put("salary", money);
			ssds.add(map2);
		}
		return "salarystandard_change_success";
	}
}
