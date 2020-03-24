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

import cn.storm.pojo.ConfigMajorKind;
import cn.storm.pojo.ConfigPublicChar;
import cn.storm.service.ConfigPublicCharService;

@Controller
public class PublicCharController {
	@Autowired
	private ConfigPublicCharService service=null;
	@RequestMapping("/showPublicChar.do")
	public ModelAndView showConfigFileSecondKind(ModelAndView view){
		//System.out.println(service.queryAllConfigPublicChar());
	    JSONArray array=JSONArray.fromObject(service.queryAllConfigPublicChar());
		view.addObject("configlist",array);
		view.setViewName("public_char");
		return view;
	}
	
	@RequestMapping("registerpublicchar.do")
	public String registerMajorKind(@RequestParam("item.attributeKind") String attributeKind,
			@RequestParam("item.attributeName") String attributeName){
		
		ConfigPublicChar config=new ConfigPublicChar();
		int maxid=service.queryMaxId();
		config.setAttributeKind(attributeKind);
		config.setAttributeName(attributeName);
		config.setPbcId((short) maxid);
		service.addConfigPublicChar(config);
		return "public_char_register_success";
	}
	
	@RequestMapping("/publiccharregistersuccess.do")
	public String firstkindregistersuccess(@RequestParam("operate") String operate) {
		if(operate.equals("doAdd")) {
			return "public_char_register";
		}
		if(operate.equals("list")) {
			return "redirect:/showPublicChar.do";
		}
		return null;
	}
	
	@RequestMapping(value="/changepublicchar.do")
	@ResponseBody
	public  ConfigPublicChar changesecondkind(@RequestBody String id) {
	ConfigPublicChar con=service.queryConfigPublicCharBypbcId(Integer.parseInt(id));

		return con;
	}
	
	@RequestMapping("/publicchardelectsuccess/{id}.do")
	public String secondkinddelectsuccess(@PathVariable("id")Integer id){
		service.removeConfigPublicCharBypbcId(id);
		return "redirect:/public_char_delete_success.jsp";
		
	}

}
