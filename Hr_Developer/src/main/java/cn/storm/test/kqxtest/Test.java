package cn.storm.test.kqxtest;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.storm.pojo.ConfigPrimaryKey;
import cn.storm.service.ConfigPrimaryKeyService;

public class Test {

	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"/applicationContext.xml");
		ConfigPrimaryKeyService ss = (ConfigPrimaryKeyService) ac
				.getBean("configPrimaryKeyServiceImpl");
		ConfigPrimaryKey c = new ConfigPrimaryKey();
		c.setPrkId((short) 999);
		c.setPrimaryKey("a");
		ss.addConfigPrimaryKey(c);
		ss.removeConfigPrimaryKeyByprkId(999);
		List<ConfigPrimaryKey> list = ss.queryAllConfigPrimaryKey();
		for (ConfigPrimaryKey ccc : list) {
			System.out.println(ccc);
		}
	}
}
