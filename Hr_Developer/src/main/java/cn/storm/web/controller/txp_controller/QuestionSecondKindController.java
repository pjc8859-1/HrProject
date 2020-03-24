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
import cn.storm.pojo.ConfigQuestionSecondKind;
import cn.storm.service.ConfigQuestionFirstKindService;
import cn.storm.service.ConfigQuestionSecondKindService;

@Controller
public class QuestionSecondKindController {
	@Autowired
	private ConfigQuestionSecondKindService service=null;
	@Autowired
	private ConfigQuestionFirstKindService service1=null;
	@RequestMapping("/showQuestionSecondkind.do")
	public ModelAndView showConfigFileSecondKind(ModelAndView view){
	    JSONArray array=JSONArray.fromObject(service.queryAllConfigQuestionSecondKind());
		view.addObject("configlist",array);
		view.setViewName("question_second_kind");
		return view;
	}
	
	@RequestMapping("registerQuestionSecond.do")
	public ModelAndView registerMajor(ModelAndView mode){
		mode.addObject("list", service1.queryAllConfigQuestionFirstKind());
		mode.setViewName("question_second_kind_register");
		return mode;
	}
	
	@RequestMapping("registerSecondSuccess/{id}/{name}.do")
	public String registerMajorSuccess(@PathVariable("id") String id,
			@PathVariable("name") String name,
			@RequestParam("item.questionsecondName") String questionsecondName
			){
		ConfigQuestionSecondKind config=new ConfigQuestionSecondKind();
		int maxid=service.queryMaxId();
		config.setFirstKindId(id);
		config.setFirstKindName(name);
		config.setQskId((short) maxid);
		config.setSecondKindId(Integer.toString(maxid));
		config.setSecondKindName(questionsecondName);
		service.addConfigQuestionSecondKind(config);
		
		return "redirect:/question_sceond_kind_register_success.jsp";
	}
	
	@RequestMapping("/Secondregistersuccess.do")
	public String firstkindregistersuccess(@RequestParam("operate") String operate) {
		if(operate.equals("doAdd")) {
			return "redirect:/registerQuestionSecond.do";
		}
		if(operate.equals("list")) {
			return "redirect:/showQuestionSecondkind.do";
		}
		return null;
	}
	
	@RequestMapping(value="/changeQuestionSecondKind.do")
	@ResponseBody
	public  ConfigQuestionSecondKind changesecondkind(@RequestBody String id) {
	ConfigQuestionSecondKind con=service.queryConfigQuestionSecondKindByqskId(Integer.parseInt(id));

		return con;
	}
	
	@RequestMapping("/questionseconddelectsuccess/{id}.do")
	public String secondkinddelectsuccess(@PathVariable("id")Integer id){
		service.removeConfigQuestionSecondKindByqskId(id);
		return "redirect:/question_second_kind_delete_success.jsp";
		
	}
	

}
