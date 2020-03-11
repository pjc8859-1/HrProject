package cn.storm.tan;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.ibatis.transaction.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.storm.pojo.SalaryGrantDetails;
import cn.storm.pojo.SalaryStandard;
import cn.storm.pojo.SalaryStandardDetails;
import cn.storm.pojo.Training;
import cn.storm.service.SalaryGrantDetailsService;
import cn.storm.service.SalaryStandardDetailsService;
import cn.storm.service.SalaryStandardService;
import cn.storm.service.TrainingService;
import cn.storm.service.impl.SalaryStandardDetailsServiceImpl;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
		SalaryGrantDetailsService service=    (SalaryGrantDetailsService) ac.getBean("salaryGrantDetailsServiceImpl");
	   
		SalaryGrantDetails s=new SalaryGrantDetails();
		s.setBounsSum(200.0);
		s.setDeductSum(300.0);
		s.setGrdId((short) 1);
		s.setHumanId("a");
		s.setHumanName("3");
		s.setSalaryGrantId("a");
		s.setSalaryPaidSum(500.0);
		s.setSalaryStandardSum(800.0);
		s.setSaleSum(1000.0);
		
		System.out.println(service.removeSalaryGrantDetailsByGrdId(1));
		
		

	}

}
