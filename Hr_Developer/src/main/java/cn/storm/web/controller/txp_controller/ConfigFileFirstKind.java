
package cn.storm.web.controller.txp_controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.storm.service.ConfigFileFirstKindService;

@Controller

public class ConfigFileFirstKind {
	@Autowired
	private ConfigFileFirstKindService service=null;
	@ResponseBody
	@RequestMapping("/configfirstkind/showconfigfirstkind.do")
	
	public List<cn.storm.pojo.ConfigFileFirstKind> showConfigFirstKind(){
		List<cn.storm.pojo.ConfigFileFirstKind> list=service.queryAllConfigFileFirstKind();
		System.out.println(list);
		return list;
	}
	@RequestMapping("/firstkindregister.do")
	public String firstkindregister(@RequestParam("item.firstKindName") String firstKindName
			,@RequestParam("item.firstKindSalaryId")String firstKindSalaryId
			,@RequestParam("item.firstKindSaleId")String firstKindSaleId) {
		cn.storm.pojo.ConfigFileFirstKind config=new cn.storm.pojo.ConfigFileFirstKind();
		
		config.setFirstKindName(firstKindName);
		config.setFirstKindId("01");
		config.setFirstKindSaleId(firstKindSaleId);
		config.setFirstKindSalaryId(firstKindSalaryId);
		service.addConfigFileFirstKind(config);
		return "redirect:first_kind_register_success.jsp";
	}
	@RequestMapping("/firstkindregistersuccess.do")
	public String firstkindregistersuccess(@RequestParam("operate") String operate) {
		if(operate.equals("doAdd")) {
			return "first_kind_register";
		}
		if(operate.equals("list")) {
			return "first_kind";
		}
		return null;
	}
	
	@RequestMapping(value="/changefirstkind.do")
	@ResponseBody
	public  cn.storm.pojo.ConfigFileFirstKind changefirstkind(@RequestBody String id) {
	cn.storm.pojo.ConfigFileFirstKind con=service.queryConfigFileFirstKindByffkId(Integer.parseInt(id));
	System.out.println(con);
		return con;
	}
	
	@RequestMapping("/fisrtkindchangesuccess/{id}.do")
	public ModelAndView fisrtkindchangesuccess(@PathVariable("id")Integer id,
			@RequestParam("item.firstKindSalaryId") String firstKindSalaryId,
			@RequestParam("item.firstKindSaleId") String firstKindSaleId,ModelAndView view){
		cn.storm.pojo.ConfigFileFirstKind config=service.queryConfigFileFirstKindByffkId(id);
		config.setFirstKindSalaryId(firstKindSalaryId);
        config.setFirstKindSaleId(firstKindSaleId);		
        service.modifyConfigFileFirstKind(config);
        view.setViewName("redirect:/first_kind_change_success.jsp");
		return view;
	}
	@RequestMapping("/fisrtkinddelectsuccess/{id}.do")
	public String fisrtkinddelectsuccess(@PathVariable("id")Integer id){
		service.removeConfigFileFirstKindByffkId(id);
		return "redirect:/first_kind_change_success.jsp";
		
	}

}

