
package cn.storm.test.pjctest;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.storm.pojo.ConfigPublicChar;
import cn.storm.service.ConfigPublicCharService;

public class Test {
	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
		ConfigPublicCharService ss = (ConfigPublicCharService)ac.getBean("configPublicCharServiceImpl");
		List<ConfigPublicChar> list = ss.queryConfigPublicCharByKey("招聘类型");
//		System.out.println(list.size());
		for (ConfigPublicChar configPublicChar : list) {
			System.out.println(configPublicChar);
		}
		 
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




