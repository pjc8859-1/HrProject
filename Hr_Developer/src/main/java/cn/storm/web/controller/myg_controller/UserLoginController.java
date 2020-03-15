package cn.storm.web.controller.myg_controller;


import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.storm.service.UsersService;
@Controller
public class UserLoginController {
	@Autowired
	private UsersService user = null;
	@RequestMapping("/users.do")
	public ModelAndView login(@RequestParam("item.UName") String uname,@RequestParam("item.UPassword") String upass ,HttpSession session)
	{
		ModelAndView model = new ModelAndView();
		System.out.println("到登录里面来了");
		boolean flag = user.queryUserByNameAndPass(uname, upass);
		JSONArray yesOrno = JSONArray.fromObject(flag);
		model.addObject("yesOrno", yesOrno);
		if(flag=true)
		{
			session.setAttribute("unam", uname);
			model.setViewName("forward:/index.jsp");
		}
		return model;
	}
	
}
