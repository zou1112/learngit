package cn.appinfo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import cn.appinfo.pojo.DevUser;
import cn.appinfo.service.developer.devuser.DevUserService;
import cn.appinfo.tools.Constants;
import cn.appinfo.tools.HttpResult;
@Controller
@RequestMapping("/login")
public class LogionController {
	@Resource
	private DevUserService devUserService;
	@RequestMapping("/toLogin")
	@ResponseBody
	public HttpResult<DevUser> toLogin(String userCode,String pwd,HttpSession session){
		System.out.println(session.getId());
		HttpResult<DevUser> result=new HttpResult<DevUser>();
		DevUser user=devUserService.toLogin(userCode, pwd);
		if(null!=user){
			session.setAttribute(Constants.USER_SESSION, user);
			System.out.println(session.getId());
			result.setSuccess(true);
			result.setData(user);
		}else{
			result.setSuccess(false);
			result.setMsg("账号或者密码不正确");
		}
		return result;
	}
	
	@RequestMapping("/toLoginOut")
	@ResponseBody
	public HttpResult<DevUser> toLoginOut(HttpSession session){
		HttpResult<DevUser> result=new HttpResult<DevUser>();
		session.removeAttribute(Constants.USER_SESSION);
		result.setSuccess(true);
		return result;
	}
}
