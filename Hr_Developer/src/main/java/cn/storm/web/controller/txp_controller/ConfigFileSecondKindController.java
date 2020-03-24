package cn.storm.web.controller.txp_controller;

import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.storm.pojo.ConfigFileFirstKind;
import cn.storm.pojo.ConfigFileSecondKind;
import cn.storm.service.ConfigFileFirstKindService;
import cn.storm.service.ConfigFileSecondKindService;

@Controller
public class ConfigFileSecondKindController {
	@Autowired
	private ConfigFileSecondKindService secondservice=null;
	@Autowired
	private ConfigFileFirstKindService  firstservice=null;
	
	@RequestMapping("/registerConfigFileSecondKind.do")
	public ModelAndView registerConfigFileSecondKind(ModelAndView view){
		view.setViewName("second_kind_register");
		view.addObject("secondlist",firstservice.queryAllConfigFileFirstKind()  );
		 return view;
	}
	
	@RequestMapping("/showConfigFileSecondKind.do")
	public ModelAndView showConfigFileSecondKind(ModelAndView view){
	    JSONArray array=JSONArray.fromObject(secondservice.queryAllConfigFileSecondKind());
		view.addObject("configlist",array);
		view.setViewName("second_kind");
		return view;
	}
@RequestMapping("/registerSuccess/{id}/{name}.do")	
public String registerSuccess(@PathVariable("id") String id,
		@PathVariable("name") String name,
		@RequestParam("item.secondKindName") String secondKindName,
		@RequestParam("item.secondKindSalaryId") String secondKindSalaryId,
		@RequestParam("item.secondKindSaleId") String secondKindSaleId){
	int maxid= secondservice.queryMaxId();
	ConfigFileSecondKind second=new ConfigFileSecondKind();
	second.setFirstKindId(id);
	second.setFirstKindName(name);
	second.setFskId((short) maxid);
	second.setSecondKindName(secondKindName);
	second.setSecondKindId(Integer.toString(maxid));
	second.setSecondSalaryId(secondKindSalaryId);
	second.setSecondSaleId(secondKindSaleId);
	
	secondservice.addConfigFileSecondKind(second);
	
	return "redirect:/second_kind_register_success.jsp";
}

@RequestMapping("/secondkindregistersuccess.do")
public String firstkindregistersuccess(@RequestParam("operate") String operate) {
	if(operate.equals("doAdd")) {
		return "forward:/registerConfigFileSecondKind.do";
	}
	if(operate.equals("list")) {
		return "forward://showConfigFileSecondKind.do";
	}
	return null;
}

@RequestMapping("/secondkinddelectsuccess/{id}.do")
public String secondkinddelectsuccess(@PathVariable("id")Integer id){
	secondservice.removeConfigFileSecondKindByfskId(id);
	return "redirect:/second_kind_change_success.jsp";
	
}

@RequestMapping(value="/changesecondkind.do")
@ResponseBody
public  ConfigFileSecondKind changesecondkind(@RequestBody String id) {
ConfigFileSecondKind con=secondservice.queryConfigFileSecondKindByfskId(Integer.parseInt(id));

	return con;
}

@RequestMapping("/secondkindchangesuccess/{id}.do")
public ModelAndView fisrtkindchangesuccess(@PathVariable("id")Integer id,
		@RequestParam("item.secondKindSalaryId") String secondKindSalaryId,
		@RequestParam("item.secondKindSaleId") String secondKindSaleId,ModelAndView view){
	ConfigFileSecondKind config=secondservice.queryConfigFileSecondKindByfskId(id);
	config.setSecondSalaryId(secondKindSalaryId);;
    config.setSecondSaleId(secondKindSaleId);;		
    secondservice.modifyConfigFileSecondKind(config);
    view.setViewName("redirect:/second_kind_change_success.jsp");
	return view;
}

}
