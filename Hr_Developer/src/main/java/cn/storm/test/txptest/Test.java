
package cn.storm.test.txptest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.storm.pojo.HumanFileDig;
import cn.storm.pojo.SalaryGrant;
import cn.storm.pojo.Student1;
import cn.storm.pojo.Users;
import cn.storm.service.ConfigFileFirstKindService;
import cn.storm.service.HumanFileDigService;
import cn.storm.service.HumanFileService;
import cn.storm.service.SalaryGrantService;
import cn.storm.service.StudentService;
import cn.storm.service.UsersService;


public class Test {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
		ConfigFileFirstKindService service=  (ConfigFileFirstKindService) ac.getBean("configFileFirstKindServiceImpl");
		
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

//		SalaryGrant sg=new SalaryGrant();
//		sg.setSgrId((short) 1);
//		sg.setChecker("aaaaaaaaaaaaa");
//		sg.setSalaryStandardId("a");
//		sg.setFirstKindName("ssssssssssssss");
		System.out.println(service.queryMaxId());

//		HumanFile human=new HumanFile();
//		human.setAttachmentName("1");
//		human.setHufId((short) 2);
//		human.setHumanId("4");
//		System.out.println();

		
	}

}




