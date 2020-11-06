package cn.appinfo.controller.backend;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.appinfo.pojo.BackendUser;
import cn.appinfo.service.backend.backuser.BackendUserService;
import cn.appinfo.tools.Constants;
import cn.appinfo.tools.HttpResult;

@Controller
@RequestMapping("/admin")
public class AdminLogionController {
	@Resource
	private BackendUserService backendUserService;
	@RequestMapping("/toLogin")
	@ResponseBody
	public HttpResult<BackendUser> toLogin(String userCode,String pwd,HttpSession session){
		HttpResult<BackendUser> result=new HttpResult<BackendUser>();
		BackendUser user=backendUserService.toLogin(userCode, pwd);
		if(null!=user){
			session.setAttribute(Constants.USER_SESSION, user);
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
	public HttpResult<BackendUser> toLoginOut(HttpSession session){
		HttpResult<BackendUser> result=new HttpResult<BackendUser>();
		session.removeAttribute(Constants.USER_SESSION);
		result.setSuccess(true);
		return result;
	}

}
