package cn.storm.web.controller.txp_controller;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.storm.pojo.ConfigFileSecondKind;
import cn.storm.pojo.ConfigMajorKind;
import cn.storm.service.ConfigMajorKindService;
import cn.storm.service.impl.ConfigMajorKindServiceImpl;

@Controller
public class MajorKindController {
	@Autowired
	ConfigMajorKindService service=null;
	@RequestMapping("registerMajorKind.do")
	public String registerMajorKind(@RequestParam("item.majorKindName") String majorKindName){
		
		ConfigMajorKind major=new ConfigMajorKind();
		major.setMajorKindName(majorKindName);
		int id= service.queryMaxId();
		major.setMfkId((short) id);
		major.setMajorKindId(Integer.toString(id));
		service.addConfigMajorKind(major);
		return "major_kind_register_success";
	}
	
	@RequestMapping("/majorkindregistersuccess.do")
	public String firstkindregistersuccess(@RequestParam("operate") String operate) {
		if(operate.equals("doAdd")) {
			return "major_kind_register";
		}
		if(operate.equals("list")) {
			return "redirect:/showMajorKind.do";
		}
		return null;
	}
	
	@RequestMapping("/showMajorKind.do")
	public ModelAndView showConfigFileSecondKind(ModelAndView view){
	    JSONArray array=JSONArray.fromObject(service.queryAllConfigMajorKind());
		view.addObject("configlist",array);
		view.setViewName("major_kind");
		return view;
	}
	
	@RequestMapping(value="/changemajorkind.do")
	@ResponseBody
	public  ConfigMajorKind changesecondkind(@RequestBody String id) {
	ConfigMajorKind con=service.queryConfigMajorKindBymfkId(Integer.parseInt(id));

		return con;
	}
	
	@RequestMapping("/majorkinddelectsuccess/{id}.do")
	public String secondkinddelectsuccess(@PathVariable("id")Integer id){
		service.removeConfigMajorKindBymfkId(id);
		return "redirect:/major_kind_change_success.jsp";
		
	}

}
