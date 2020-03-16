package cn.storm.web.controller.myg_controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;










import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.storm.service.UsersService;
@Controller
public class UserLoginController {
	@Autowired
	private UsersService user = null;
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
	
}
