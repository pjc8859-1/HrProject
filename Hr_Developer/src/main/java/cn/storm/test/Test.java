package cn.storm.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.storm.pojo.Student;
import cn.storm.service.StudentService;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
		StudentService ss = (StudentService)ac.getBean("studentServiceImpl");
		List<Student> list = ss.queryAllStudent();
		for (Student student : list) {
			System.out.println(student.getSname());
			
		}
	}

}
