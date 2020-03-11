package cn.storm.tan;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.ibatis.transaction.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.storm.pojo.SalaryStandard;
import cn.storm.pojo.SalaryStandardDetails;
import cn.storm.pojo.Training;
import cn.storm.service.SalaryStandardDetailsService;
import cn.storm.service.SalaryStandardService;
import cn.storm.service.TrainingService;
import cn.storm.service.impl.SalaryStandardDetailsServiceImpl;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
		SalaryStandardService service=   (SalaryStandardService) ac.getBean("salaryStandardServiceImpl");
		SalaryStandard sala=new SalaryStandard();
		sala.setChanger("1");
		sala.setChangeStatus((short)2);
		sala.setChangeTime(new Timestamp(new Date().getTime()));
		sala.setDesigner("1");
		sala.setRegister("a");
		sala.setRegistTime(new Timestamp(new Date().getTime()));
		sala.setRemark("c");
		sala.setSalarySum(10.0);
		sala.setSsdId((short)1);
		sala.setStandardId("asd");
		sala.setStandardName("asd");
		
		sala.setChecker("aa");
		sala.setCheckComment("aaa");
		sala.setCheckStatus((short)4);
		
		System.out.println(service.removeSalaryStandardBySsd(1));
		
		

	}

}
