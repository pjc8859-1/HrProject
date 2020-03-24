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

import cn.storm.pojo.ConfigMajor;
import cn.storm.pojo.ConfigMajorKind;
import cn.storm.service.ConfigMajorKindService;
import cn.storm.service.ConfigMajorService;

@Controller
public class MajorController {
	@Autowired
	private ConfigMajorService service=null;
	@Autowired
	private ConfigMajorKindService servicekind=null;
	@RequestMapping("/showMajor.do")
	public ModelAndView showConfigFileSecondKind(ModelAndView view){
	    JSONArray array=JSONArray.fromObject(service.queryAllConfigMajor());
		view.addObject("configlist",array);
		view.setViewName("major");
		return view;
	}
	
	@RequestMapping("registerMajor.do")
	public ModelAndView registerMajor(ModelAndView mode){
		mode.addObject("list", servicekind.queryAllConfigMajorKind());
		mode.setViewName("major_register");
		return mode;
	}
	
	@RequestMapping("registerMajorSuccess/{id}/{name}.do")
	public String registerMajorSuccess(@PathVariable("id") String id,
			@PathVariable("name") String name,
			@RequestParam("item.majorName") String majorname
			){
		ConfigMajor config=new ConfigMajor();
		int maxid=service.queryMaxId();
		config.setMakId((short) maxid);
		config.setMajorId(Integer.toString(maxid));
		config.setMajorKindName(name);
		config.setMajorName(majorname);
		config.setMajorKindId(id);
		config.setTestAmount((short) 0);
		service.addConfigMajor(config);
		return "redirect:/major_register_success.jsp";
	}
	
	
	
	@RequestMapping("/majorregistersuccess.do")
	public String firstkindregistersuccess(@RequestParam("operate") String operate) {
		if(operate.equals("doAdd")) {
			return "redirect:/registerMajor.do";
		}
		if(operate.equals("list")) {
			return "redirect:/showMajor.do";
		}
		return null;
	}
	
	
	
	@RequestMapping(value="/changemajor.do")
	@ResponseBody
	public  ConfigMajor changesecondkind(@RequestBody String id) {
	ConfigMajor con=service.queryConfigMajorBymakId(Integer.parseInt(id));

		return con;
	}
	
	@RequestMapping("/majordelectsuccess/{id}.do")
	public String secondkinddelectsuccess(@PathVariable("id")Integer id){
		service.removeConfigMajorBymakId(id);
		return "redirect:/major_delect_success.jsp";
		
	}
}
