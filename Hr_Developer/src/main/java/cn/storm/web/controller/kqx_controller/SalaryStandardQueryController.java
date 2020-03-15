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

	@RequestMapping("queryBySalary.do")
	public String queryBySalary(@RequestParam Map params, Map map) {
		slist = salaryService.queryBySalary(params);
		map.put("slist", slist);
		map.put("stdid", params.get("stdid"));
		map.put("sdesigner", params.get("sdesigner"));
		map.put("srtime1", params.get("srtime1"));
		map.put("srtime2", params.get("srtime2"));
		map.put("count", slist.size());
		return "salarystandard_query_list";
	}
}
