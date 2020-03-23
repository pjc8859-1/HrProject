package cn.storm.web.controller.kqx_controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.storm.pojo.SalaryStandard;
import cn.storm.service.SalaryStandardService;

@Controller
public class SalaryStandardQueryController {
	private List<SalaryStandard> slist;
	@Autowired
	private SalaryStandardService salaryService;

	// 在薪酬标准查询中点击查询执行的方法
	@RequestMapping("queryBySalary.do")
	public String queryBySalary(@RequestParam Map params, Map map, String[] key) {
		if (key != null && key.length > 0) {
			for (String string : key) {
				System.out.println(string);
				params.put(string, 1);
			}
		}
		slist = salaryService.queryBySalary(params);
		map.put("slist", slist);
		map.put("count", slist.size());
		return "salarystandard_query_list";
	}

	// 在薪酬标准变更中点击查询执行的方法
	@RequestMapping("salarychange2.do")
	public String querybzbg(@RequestParam Map params, Map map, String[] key) {
		if (key != null && key.length > 0) {
			for (String string : key) {
				System.out.println(string);
				params.put(string, 1);
			}
		}
		slist = salaryService.queryBySalary(params);
		map.put("slist", slist);
		map.put("count", slist.size());
		return "salarystandard_change_list";
	}

}
