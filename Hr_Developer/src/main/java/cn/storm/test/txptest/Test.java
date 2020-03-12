
package cn.storm.test.txptest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.storm.pojo.HumanFileDig;
import cn.storm.service.HumanFileDigService;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
		HumanFileDigService service=(HumanFileDigService) ac.getBean("humanFileDigServiceImpl");
		
//		StudentService ss = (StudentService)ac.getBean("studentServiceImpl");
//		
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
//			System.out.println(student.getSname());
//			
//		}
//		UsersService userservice=(UsersService) ac.getBean("usersServiceImpl");
//		Users user =new Users();
//		user.setUId((short) 2);
//		user.setUName("张三");
//		user.setUPassword("45678945");
//		user.setUTrueName("张英俊");

		HumanFileDig dig=new HumanFileDig();
		dig.setHfdId((short) 1);
		dig.setFirstKindId("a");
		dig.setHumanBirthplace("aaaaaaaaaaaaaaaaaaaaaaaaabbbbb");
		dig.setChecker("aaaaaaaaaaaaaaaaaaaaaaaaa");
		System.out.println(service.queryHumanFileDigByHfdid(1));

//		HumanFile human=new HumanFile();
//		human.setAttachmentName("1");
//		human.setHufId((short) 2);
//		human.setHumanId("4");
//		System.out.println();

		
	}

}




