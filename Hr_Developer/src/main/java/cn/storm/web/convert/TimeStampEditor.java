package cn.storm.web.convert;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.PropertiesEditor;
public class TimeStampEditor extends PropertiesEditor{

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = sdf.parse(text);
			setValue(new Timestamp(date.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public String getAsText() {
		// TODO Auto-generated method stub
        return getValue().toString();
	}

	
	

}
