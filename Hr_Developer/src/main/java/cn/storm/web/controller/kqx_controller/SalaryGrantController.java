package cn.storm.web.controller.kqx_controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.storm.dto.Xcxm;
import cn.storm.pojo.SalaryGrant;
import cn.storm.pojo.SalaryGrantDetails;
import cn.storm.pojo.SalaryStandard;
import cn.storm.service.SalaryGrantDetailsService;
import cn.storm.service.SalaryGrantService;
import cn.storm.service.SalaryStandardDetailsService;
import cn.storm.service.SalaryStandardService;

@Controller
public class SalaryGrantController {
	@Autowired
	private SalaryStandardService SalaryStandardService;
	@Autowired
	private SalaryStandardDetailsService SalaryStandardDetailsService;
	@Autowired
	private SalaryGrantService SalarygrantService;

	@Autowired
	private SalaryGrantDetailsService SalaryGrantDetailsService;

	// 点击薪酬发放登记执行的方法
	@RequestMapping("queryBysalaryid.do")
	public String queryBysalaryid(Map map) {
		List<SalaryGrant> salist = SalarygrantService.queryAllSalaryGrant();
		map.put("salist", salist);
		Map summap = SalarygrantService.SalarySum();
		map.put("count", salist.size());
		map.put("summap", summap);
		return "salarystandard_grant_register_catalog";
	}

	// 在薪酬发放登记list中点击登记执行的方法
	@RequestMapping("toGrantModif.do")
	public String toquery(int sid, String standardid, Map map,
			HttpSession session) {
		List<SalaryGrantDetails> sgdlist = SalaryGrantDetailsService
				.Bysalary_grant_id(sid);
		SalaryStandard sa = SalaryStandardService
				.querySalaryStandardBySsd(standardid);
		SalaryGrant sg = SalarygrantService.querySalaryGrantBysgrId(sid);
		List<Xcxm> salist = SalaryStandardDetailsService.querystid(sa);
		Map summap = SalaryGrantDetailsService.SalarySumByid(sid);
		map.put("summap", summap);
		map.put("sid", sid);
		map.put("sgdlist", sgdlist);
		map.put("count", sgdlist.size());
		map.put("salist", salist);
		map.put("sg", sg);
		return "salarystandard_grant_register_modif";
	}

	// 在薪酬发放登记中点击提交执行的方法
	@RequestMapping("grantSubmit.do")
	public String grantSubmit(Map map, SalaryGrant salarygrant, String sid,
			String register, @RequestParam List<Double> bounsSum,
			@RequestParam List<Double> saleSum,
			@RequestParam List<Double> deductSum,
			@RequestParam List<Double> salaryPaidSum,
			@RequestParam List<String> humanId,
			@RequestParam List<String> humanName) {
		salarygrant.setSalaryGrantId(sid);
		salarygrant.setRegister(register);
		Date date = new Date();
		Timestamp nousedate = new Timestamp(date.getTime());
		double salaryPaidSumCount = 0.0;
		for (int i = 0; i < salaryPaidSum.size(); i++) {
			salaryPaidSumCount += salaryPaidSum.get(i);
		}
		salarygrant.setSalaryPaidSum(salaryPaidSumCount);
		salarygrant.setRegistTime(nousedate);
		SalarygrantService.updateGrant(salarygrant);
		System.out.println(sid);
		for (int i = 0; i < humanId.size(); i++) {
			System.out.println(humanId.get(i) + humanName.get(i)
					+ bounsSum.get(i) + saleSum.get(i) + deductSum.get(i)
					+ salaryPaidSum.get(i));
		}
		for (int i = 0; i < humanId.size(); i++) {
			String humanIdpara = humanId.get(i);
			String humanNamepara = humanName.get(i);
			Double bounsSumpara = bounsSum.get(i);
			Double saleSumpara = saleSum.get(i);
			Double deductSumpara = deductSum.get(i);
			Double salaryPaidSumpara = salaryPaidSum.get(i);
			Map mymap = new HashMap();
			mymap.put("humanId", humanIdpara);
			mymap.put("humanName", humanNamepara);
			mymap.put("bounsSum", bounsSumpara);
			mymap.put("saleSum", saleSumpara);
			mymap.put("deductSum", deductSumpara);
			mymap.put("salaryPaidSum", salaryPaidSumpara);
			mymap.put("sid", sid);
			SalaryGrantDetailsService.add(mymap);
		}
		return "salarystandard_grant_register_success";
	}

	// 点击薪酬发放登记复核应执行的方法
	@RequestMapping("toSalarygrantAll.do")
	public String toSalarygrantAll(Map map) {
		List<SalaryGrant> sglist = SalarygrantService
				.queryAllRegisteredSalaryGrant();
		// Object sgid = session.getAttribute("sgid");
		Map summap = SalarygrantService.SalaryRegisteredSum();
		map.put("summap", summap);
		map.put("sglist", sglist);
		map.put("count", sglist.size());
		return "salarystandard_grant_check_list";
	}

	// 在薪酬登记复核list中点击复核应执行的方法
	@RequestMapping("toGrantCheckModif.do")
	public String toGrantCheckModif(int sid, String standardid, Map map,
			HttpSession session) {
		List<SalaryGrantDetails> sgdlist = SalaryGrantDetailsService
				.Bysalary_grant_id(sid);
		SalaryStandard sa = SalaryStandardService
				.querySalaryStandardBySsd(standardid);
		SalaryGrant sg = SalarygrantService.querySalaryGrantBysgrId(sid);
		List<Xcxm> salist = SalaryStandardDetailsService.querystid(sa);
		Map summap = SalaryGrantDetailsService.SalarySumByid(sid);
		map.put("summap", summap);
		map.put("sid", sid);
		map.put("sgdlist", sgdlist);
		map.put("count", sgdlist.size());
		map.put("salist", salist);
		map.put("sg", sg);
		return "salarystandard_grant_check";
	}

	// 在薪酬登记复核中点击提交应执行的方法
	@RequestMapping("grantCheckSubmit.do")
	public String grantCheckSubmit(Map map, SalaryGrant salarygrant,
			String sid, String checker, @RequestParam List<Double> bounsSum,
			@RequestParam List<Double> saleSum,
			@RequestParam List<Double> deductSum,
			@RequestParam List<Double> salaryPaidSum,
			@RequestParam List<String> humanId,
			@RequestParam List<String> humanName) {
		salarygrant.setSalaryGrantId(sid);
		salarygrant.setChecker(checker);
		Date date = new Date();
		double salaryPaidSumCount = 0.0;
		Timestamp nousedate = new Timestamp(date.getTime());
		salarygrant.setCheckTime(nousedate);
		for (int i = 0; i < salaryPaidSum.size(); i++) {
			salaryPaidSumCount += salaryPaidSum.get(i);
		}
		salarygrant.setSalaryPaidSum(salaryPaidSumCount);
		SalarygrantService.updateCheckGrant(salarygrant);
		System.out.println(sid);
		for (int i = 0; i < humanId.size(); i++) {
			String humanIdpara = humanId.get(i);
			String humanNamepara = humanName.get(i);
			Double bounsSumpara = bounsSum.get(i);
			Double saleSumpara = saleSum.get(i);
			Double deductSumpara = deductSum.get(i);
			Double salaryPaidSumpara = salaryPaidSum.get(i);
			Map mymap = new HashMap();
			mymap.put("humanId", humanIdpara);
			mymap.put("humanName", humanNamepara);
			mymap.put("bounsSum", bounsSumpara);
			mymap.put("saleSum", saleSumpara);
			mymap.put("deductSum", deductSumpara);
			mymap.put("salaryPaidSum", salaryPaidSumpara);
			mymap.put("sid", sid);
			SalaryGrantDetailsService.add(mymap);
		}
		return "salarystandard_grant_check_success";
	}

	// 点击薪酬发放查询应执行的方法
	@RequestMapping("queryGrant.do")
	public String queryGrant(@RequestParam Map params, Map map, String[] key) {
		if (key != null && key.length > 0) {
			for (String string : key) {
				System.out.println(string);
				params.put(string, 1);
			}
		}
		List<SalaryGrant> sglist = SalarygrantService
				.queryAllCheckedSalaryGrantBycondition(params);
		map.put("sglist", sglist);
		map.put("count", sglist.size());
		return "salarystandard_grant_query_list";
	}

	// 在薪酬发放查询list中点击查看应执行的方法
	@RequestMapping("toGrantLook.do")
	public String toGrantLook(int sid, String standardid, Map map) {
		List<SalaryGrantDetails> sgdlist = SalaryGrantDetailsService
				.Bysalary_grant_id(sid);
		SalaryStandard sa = SalaryStandardService
				.querySalaryStandardBySsd(standardid);
		SalaryGrant sg = SalarygrantService.querySalaryGrantBysgrId(sid);
		List<Xcxm> salist = SalaryStandardDetailsService.querystid(sa);
		Map summap = SalaryGrantDetailsService.SalarySumByid(sid);
		map.put("summap", summap);
		map.put("sid", sid);
		map.put("sgdlist", sgdlist);
		map.put("count", sgdlist.size());
		map.put("salist", salist);
		map.put("sg", sg);
		return "salarystandard_grant_query_look";
	}
}
