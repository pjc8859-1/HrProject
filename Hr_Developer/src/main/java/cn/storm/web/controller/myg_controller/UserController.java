package cn.storm.web.controller.myg_controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;















import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.storm.pojo.Users;
import cn.storm.service.UsersService;
@Controller
public class UserController {
	@Autowired
	private UsersService user = null;
	/**
	 * 登录
	 * @param session
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/users.do")
	public void login(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws Exception
	{    
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		boolean flag=user.queryUserByNameAndPass(uname, upass);
		if(flag==true)
		{
			session.setAttribute("username", uname);
			String flgs = "{flag:"+"true"+"}";
			JSONObject flg = JSONObject.fromObject(flgs);
			PrintWriter out = response.getWriter();
			out.print(flg.toString());
			System.out.println("成功！");
		}
		else if(flag==false)
		{
			String fl = "{flag:"+"false"+"}";
			JSONObject fls = JSONObject.fromObject(fl);
			PrintWriter out = response.getWriter();
			out.print(fls.toString());
			System.out.println("失败");
		}
	}
	/**
	 * 用户注册
	 */
	@RequestMapping("userregister.do")
	public ModelAndView userRegister(@RequestParam("item.UName") String UName,
			@RequestParam("item.UTrueName") String UTrueName,
			@RequestParam("item.UPassword") String UPassword,
			@RequestParam("profix") String UPosition)
	{
		ModelAndView model = new ModelAndView();
		System.out.println("我的昵称："+UName);
		Users flag = user.querryUsersByUname(UName);
		Users users = new Users();
		users.setUName(UName);
		users.setUTrueName(UTrueName);
		users.setUPassword(UPassword);
		users.setUPosition(UPosition);
		model.addObject("users",users );
		String exist="exist";
		String error="error";
		if(flag==null)
		{
			boolean fl = user.addUsers(users);
			if(fl==true)
			{
				model.setViewName("forward:/registersuccess.jsp");
			}
			else
			{
				model.addObject("exist", error);
				model.setViewName("forward:/register.jsp?"+error);
			}
		}
		else{
			model.addObject("exist", exist);
			model.setViewName("forward:/register.jsp?"+exist);
		}
		return model;
	}
}
