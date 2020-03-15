package cn.storm.web.convert;

import java.sql.Timestamp;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

public class TimeStampEditorIniter implements WebBindingInitializer {

	@Override
	public void initBinder(WebDataBinder binder, WebRequest arg1) {
		// TODO Auto-generated method stub
		binder.registerCustomEditor(Timestamp.class, new TimeStampEditor());
	}

}
