package cn.storm.web.controller.kqx_controller;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.storm.pojo.SalaryStandard;
import cn.storm.pojo.SalaryStandardDetails;
import cn.storm.service.SalaryStandardDetailsService;
import cn.storm.service.SalaryStandardService;

@Controller
@RequestMapping("/hr")
public class SalaryStandardRegisterController {
	@Autowired
	private SalaryStandardService sss = null;
	@Autowired
	private SalaryStandardDetailsService ssds = null;

	@RequestMapping("/salarystandard.do")
	public String RegisterPage(@RequestParam("item.standardId") String id,
			@RequestParam("item.standardName") String name,
			@RequestParam("item.designer") String designer,
			@RequestParam("item.register") String register,
			@RequestParam("item.remark") String remark,
			@RequestParam("list[0].itemId") short itemId0,
			@RequestParam("list[0].itemName") String itemName0,
			@RequestParam("list[0].salary") double salary0,
			@RequestParam("list[1].itemId") short itemId1,
			@RequestParam("list[1].itemName") String itemName1,
			@RequestParam("list[1].salary") double salary1,
			@RequestParam("list[2].itemId") short itemId2,
			@RequestParam("list[2].itemName") String itemName2,
			@RequestParam("list[2].salary") double salary2,
			@RequestParam("list[3].itemId") short itemId3,
			@RequestParam("list[3].itemName") String itemName3,
			@RequestParam("list[3].salary") double salary3,
			@RequestParam("list[4].itemId") short itemId4,
			@RequestParam("list[4].itemName") String itemName4,
			@RequestParam("list[4].salary") double salary4,
			@RequestParam("list[5].itemId") short itemId5,
			@RequestParam("list[5].itemName") String itemName5,
			@RequestParam("list[5].salary") double salary5) {
		double count = salary0 + salary1 + salary2 + salary3 + salary4
				+ salary5;
		Date date = new Date();
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
		// String date1 = sdf.format(date);
		Timestamp nousedate = new Timestamp(date.getTime());
		System.out.println(nousedate);
		SalaryStandard ss = new SalaryStandard();
		ss.setStandardId(id);
		ss.setStandardName(name);
		ss.setDesigner(designer);
		ss.setRegister(register);
		ss.setRegistTime(nousedate);
		ss.setRemark(remark);
		ss.setSalarySum(count);
		ss.setCheckStatus((short) 0);
		sss.addSalaryStandard(ss);
		SalaryStandardDetails ssd0 = new SalaryStandardDetails();
		ssd0.setStandardId(id);
		ssd0.setStandardName(name);
		ssd0.setItemId(itemId0);
		ssd0.setItemName(itemName0);
		ssd0.setSalary(salary0);
		SalaryStandardDetails ssd1 = new SalaryStandardDetails();
		ssd1.setStandardId(id);
		ssd1.setStandardName(name);
		ssd1.setItemId(itemId1);
		ssd1.setItemName(itemName1);
		ssd1.setSalary(salary1);
		SalaryStandardDetails ssd2 = new SalaryStandardDetails();
		ssd2.setStandardId(id);
		ssd2.setStandardName(name);
		ssd2.setItemId(itemId2);
		ssd2.setItemName(itemName2);
		ssd2.setSalary(salary2);
		SalaryStandardDetails ssd3 = new SalaryStandardDetails();
		ssd3.setStandardId(id);
		ssd3.setStandardName(name);
		ssd3.setItemId(itemId3);
		ssd3.setItemName(itemName3);
		ssd3.setSalary(salary3);
		SalaryStandardDetails ssd4 = new SalaryStandardDetails();
		ssd4.setStandardId(id);
		ssd4.setStandardName(name);
		ssd4.setItemId(itemId4);
		ssd4.setItemName(itemName4);
		ssd4.setSalary(salary4);
		SalaryStandardDetails ssd5 = new SalaryStandardDetails();
		ssd5.setStandardId(id);
		ssd5.setStandardName(name);
		ssd5.setItemId(itemId5);
		ssd5.setItemName(itemName5);
		ssd5.setSalary(salary5);
		ssds.addSalaryStandardDetails(ssd0);
		ssds.addSalaryStandardDetails(ssd1);
		ssds.addSalaryStandardDetails(ssd2);
		ssds.addSalaryStandardDetails(ssd3);
		ssds.addSalaryStandardDetails(ssd4);
		ssds.addSalaryStandardDetails(ssd5);
		return "redirect:/salarystandard_register_success.jsp";
	}

	public static void main(String[] args) {
		Date date = new Date();
		Timestamp nousedate = new Timestamp(date.getTime());
		System.out.println(nousedate);
	}
}
