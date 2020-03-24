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
import cn.storm.pojo.ConfigQuestionFirstKind;
import cn.storm.service.ConfigQuestionFirstKindService;

@Controller
public class QuestionFirstKindController {
	@Autowired
	private ConfigQuestionFirstKindService service=null;
	@RequestMapping("/showQuestionFirstKind.do")
	public ModelAndView showConfigFileSecondKind(ModelAndView view){
	    JSONArray array=JSONArray.fromObject(service.queryAllConfigQuestionFirstKind());
		view.addObject("configlist",array);
		view.setViewName("question_first_kind");
		return view;
	}
	
	@RequestMapping("registerQuestionFirstKind.do")
	public String registerMajorKind(@RequestParam("item.questionFirstKindName") String questionFirstKindName){
		
		int maxid=service.queryMaxId();
		ConfigQuestionFirstKind config=new ConfigQuestionFirstKind();
		config.setQfkId((short) maxid);
		config.setFirstKindId(Integer.toString(maxid));
		config.setFirstKindName(questionFirstKindName);
		service.addConfigQuestionFirstKind(config);
		return "question_first_kind_register_success";
	}
	
	@RequestMapping("/questionfirstkindregistersuccess.do")
	public String firstkindregistersuccess(@RequestParam("operate") String operate) {
		if(operate.equals("doAdd")) {
			return "question_first_kind_register";
		}
		if(operate.equals("list")) {
			return "redirect:/showQuestionFirstKind.do";
		}
		return null;
	}
	
	@RequestMapping(value="/changequestionfirrstkind.do")
	@ResponseBody
	public  ConfigQuestionFirstKind changesecondkind(@RequestBody String id) {
	ConfigQuestionFirstKind con=service.queryConfigQuestionFirstKindByqfkId(Integer.parseInt(id));

		return con;
	}
	
	@RequestMapping("/questionfirstkinddelectsuccess/{id}.do")
	public String secondkinddelectsuccess(@PathVariable("id")Integer id){
		service.removeConfigQuestionFirstKindByqfkId(id);
		return "redirect:/question_first_kind_delete_success.jsp";
		
	}
	
	


}
