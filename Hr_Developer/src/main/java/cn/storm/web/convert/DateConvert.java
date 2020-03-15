package cn.storm.web.convert;

import java.sql.Timestamp;
import java.util.Date;



import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
@Component
public class DateConvert  implements Converter<String, Timestamp>{
		public DateConvert() {
			System.out.println("出生=======================================");
		}
	@Override
	public Timestamp convert(String arg0) {
		Date d = new Date(arg0.replace("-", "/")+" 00:00:00");
		long time = d.getTime();//long
		System.out.println("进入了转换");
		return new Timestamp(time);
	}



}
