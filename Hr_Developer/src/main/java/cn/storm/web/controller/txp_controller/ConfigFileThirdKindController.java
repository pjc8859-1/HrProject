package cn.storm.web.controller.txp_controller;

import java.util.ArrayList;
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
import cn.storm.pojo.ConfigFileThirdKind;
import cn.storm.service.ConfigFileFirstKindService;
import cn.storm.service.ConfigFileSecondKindService;
import cn.storm.service.ConfigFileThirdKindService;

@Controller
public class ConfigFileThirdKindController {
	@Autowired
	ConfigFileThirdKindService thirdservice = null;
	@Autowired
	ConfigFileSecondKindService secondservice = null;
	@Autowired
	ConfigFileFirstKindService firstserviace = null;

	@RequestMapping("/showConfigFileThirdKind.do")
	public ModelAndView showConfigFileSecondKind(ModelAndView view) {
		JSONArray array = JSONArray.fromObject(thirdservice
				.queryAllConfigFileThirdKind());
		view.addObject("configlist", array);
		view.setViewName("third_kind");
		return view;
	}

	@RequestMapping("/registerConfigFileThirdKind.do")
	public ModelAndView registerConfigFileSecondKind(ModelAndView view) {
		view.setViewName("third_kind_register");
		List<ConfigFileFirstKind> firstlist = firstserviace
				.queryAllConfigFileFirstKind();
		List<ConfigFileSecondKind> seconlist = secondservice
				.queryAllConfigFileSecondKind();
		List<Object> list = new ArrayList<>();
		list.add(firstlist);
		list.add(seconlist);
		view.addObject("list", JSONArray.fromObject(list));
		return view;
	}

	@RequestMapping("/registerThirdSuccess/{firstname}/{secondname}/{firstKindId}/{secondKindId}.do")
	public String registerSuccess(@PathVariable("firstname") String firstname,
			@PathVariable("secondname") String secondname,
			@PathVariable("firstKindId") String firstKindId,
			@PathVariable("secondKindId") String secondKindId,
			@RequestParam("item.thirdKindName") String thirdKindName,
			@RequestParam("item.thirdKindSaleId") String thirdKindSaleId,
			@RequestParam("item.thirdKindIsRetail") String thirdKindIsRetail) {
		int maxid = thirdservice.queryMaxId();
		ConfigFileThirdKind t = new ConfigFileThirdKind();
		t.setFirstKindId(firstKindId);
		t.setFtkId((short) maxid);
		t.setFirstKindName(firstname);
		t.setSecondKindId(secondKindId);
		t.setSecondKindName(secondname);
		t.setThirdKindId(Integer.toString(maxid));
		t.setThirdKindIsRetail(thirdKindIsRetail);
		t.setThirdKindName(thirdKindName);
		t.setThirdKindSaleId(thirdKindSaleId);
		thirdservice.addConfigFileThirdKind(t);

		return "redirect:/third_kind_register_success.jsp";
	}

	@RequestMapping("/thirdkindregistersuccess.do")
	public String firstkindregistersuccess(
			@RequestParam("operate") String operate) {
		if (operate.equals("doAdd")) {
			return "forward:/registerConfigFileThirdKind.do";
		}
		if (operate.equals("list")) {
			return "forward://showConfigFileThirdKind.do";
		}
		return null;
	}

	@RequestMapping(value = "/changethirdkind.do")
	@ResponseBody
	public ConfigFileThirdKind changesecondkind(@RequestBody String id) {

		return thirdservice.queryConfigFileThirdKindByftkId(Integer
				.parseInt(id));
	}

	@RequestMapping("/thirdkindchangesuccess/{id}.do")
	public ModelAndView fisrtkindchangesuccess(@PathVariable("id") Integer id,
			@RequestParam("item.thirdKindSaleId") String thirdKindSaleId,
			@RequestParam("item.thirdKindIsRetail") String thirdKindIsRetail,
			ModelAndView view) {
		ConfigFileThirdKind config = thirdservice
				.queryConfigFileThirdKindByftkId(id);
		config.setThirdKindSaleId(thirdKindSaleId);
		config.setThirdKindIsRetail(thirdKindIsRetail);
		thirdservice.modifyConfigFileThirdKind(config);
		view.setViewName("redirect:/third_kind_change_success.jsp");
		return view;
	}

	@RequestMapping("/thirdkinddelectsuccess/{id}.do")
	public String secondkinddelectsuccess(@PathVariable("id") Integer id) {
		thirdservice.removeConfigFileThirdKindByftkId(id);
		return "redirect:/third_kind_change_success.jsp";

	}

}
