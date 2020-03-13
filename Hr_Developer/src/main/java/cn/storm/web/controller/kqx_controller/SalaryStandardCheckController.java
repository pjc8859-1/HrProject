package cn.storm.web.controller.kqx_controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.storm.pojo.SalaryStandard;
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
	private SalaryStandardService sss;
	@Autowired
	private SalaryStandardDetailsService ssds;
	private SalaryStandard cstandardid;

	private Object sid;

	private Object String;

	@RequestMapping("/toqueryf.do")
	public String queryf(Map map) {
		slist = sss.queryAllSalaryStandard();
		map.put("sslist", slist);
		map.put("count", slist.size());
		return "salarystandard_check_list";
	}

}
