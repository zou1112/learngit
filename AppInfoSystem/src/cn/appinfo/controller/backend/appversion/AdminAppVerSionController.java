package cn.appinfo.controller.backend.appversion;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.appinfo.pojo.AppVersion;
import cn.appinfo.service.backend.appversion.AdminAppVersionService;
import cn.appinfo.tools.HttpResult;

@Controller
@RequestMapping("/backendversion")
public class AdminAppVerSionController {
	
	@Resource
	private AdminAppVersionService appVersionService;
	
	@RequestMapping("/queryVersionByMaxVerSionId")
	@ResponseBody
	public HttpResult<AppVersion> queryVersionByMaxVerSionId(Integer appId){
		HttpResult<AppVersion> result=new HttpResult<AppVersion>();
		try {
			AppVersion appVersion=appVersionService.queryVersionByMaxVerSionId(appId);
			result.setCode(0);
			result.setData(appVersion);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	

}
