package cn.storm.web.controller.txp_controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.storm.service.ConfigFileFirstKindService;

@Controller
@RequestMapping("/configfirstkind")
public class ConfigFileFirstKind {
	@Autowired
	private ConfigFileFirstKindService service=null;
	@ResponseBody
	@RequestMapping("/showconfigfirstkind.do")
	
	public List<cn.storm.pojo.ConfigFileFirstKind> showConfigFirstKind(){
		
		return service.queryAllConfigFileFirstKind();
	}

}
