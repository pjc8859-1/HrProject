package cn.storm.tan;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.ibatis.transaction.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.storm.pojo.Training;
import cn.storm.service.TrainingService;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
		TrainingService service=(TrainingService) ac.getBean("trainingServiceImpl");
		Training training=new Training();
		training.setChecker("123");
		training.setCheckstatus((short) 1);
		training.setCheckTime(new Timestamp(new Date().getTime()));
		training.setHumanId("1");
		training.setHumanName("1");
		training.setMajorId("2");
		training.setMajorKindId("78");
		training.setMajorKindName("32");
		training.setMajorName("45");
		training.setRegister("a");
		training.setRegistTime(new Timestamp(new Date().getTime()));
		training.setRemark("abf");
		training.setTraId((short)3);
		training.setTrainingDegree("abv");
		training.setTrainingHour(3);
		training.setTrainingItem("a");
		training.setTrainingTime(new Timestamp(new Date().getTime()));
		System.out.println(service.modifyTraining(training));
		
		

	}

}
