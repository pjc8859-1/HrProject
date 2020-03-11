
package cn.storm.test.pjctest;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.storm.pojo.EngageAnswerDetails;
import cn.storm.service.EngageAnswerDetailsService;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
		EngageAnswerDetailsService ss = (EngageAnswerDetailsService)ac.getBean("engageAnswerDetailsServiceImpl");
		List<EngageAnswerDetails> list = ss.queryAllEngageAnswerDetails();
		System.out.println(list.size());
		 
//		Student s = new Student();
//		s.setSid(5);
//		s.setSname("张三");
//		s.setSex("男");
//		s.setScore(65);
//		
//		ss.addStudent(s);
//		System.out.println("保存!");
		
		
//		Student s = ss.queryStudentBySid(1);
//		s.setScore(85);
//		
//		int updateResult = ss.modifyStudent(s);
//		System.out.println(updateResult);
//		List<Student> list = ss.queryAllStudent();
//		for (Student student : list) {
//			System.out.println(student.getSName());
//		}

//		
//		System.out.println(ac.getBean("studentMapper"));
		
		
	}

}




