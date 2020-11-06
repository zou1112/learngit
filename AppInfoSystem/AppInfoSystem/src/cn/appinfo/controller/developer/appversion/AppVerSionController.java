package cn.appinfo.controller.developer.appversion;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import cn.appinfo.pojo.AppVersion;
import cn.appinfo.pojo.DevUser;
import cn.appinfo.service.developer.appversion.AppVersionService;
import cn.appinfo.tools.Constants;
import cn.appinfo.tools.HttpResult;

@Controller
@RequestMapping("/version")
public class AppVerSionController {
	@Resource
	private AppVersionService appVersionService;

	public HttpResult<Integer> deleteVerSion() {
		HttpResult<Integer> result = new HttpResult<Integer>();

		return result;
	}

	@RequestMapping("/addVerSion")
	@ResponseBody
	public HttpResult<String> addVerSion(AppVersion appVersion,
			HttpSession session) {
		HttpResult<String> result = new HttpResult<String>();
		if(appVersion.getId()!=null){
			appVersion.setModifyBy(((DevUser) session
					.getAttribute(Constants.USER_SESSION)).getId());
			appVersion.setModifyDate(new Date());
			if(appVersionService.modifyVersion(appVersion)>0){
				result.setCode(0);
			}else{
				result.setMsg("修改失败");
			}
		}else{
			appVersion.setCreatedBy(((DevUser) session
					.getAttribute(Constants.USER_SESSION)).getId());
			appVersion.setCreationDate(new Date());
		
			if (appVersionService.addVersion(appVersion)) {
				result.setSuccess(true);
			}
		}
		return result;
	}

	@RequestMapping("/queryAppVersionList")
	@ResponseBody
	public HttpResult<List<AppVersion>> queryAppVersionList(Integer id) {
		HttpResult<List<AppVersion>> result = new HttpResult<List<AppVersion>>();
		List<AppVersion> verSionList = appVersionService
				.queryAppVerSionList(id);
			result.setSuccess(true);
			result.setData(verSionList);
			result.setCode(0);
		return result;
	}
	
	@RequestMapping("/upload")
	@ResponseBody
	public HttpResult<List<String>> apkUpload(MultipartFile file) {
		HttpResult<List<String>> result = new HttpResult<List<String>>();
		List<String> strings=new ArrayList<String>();
		String fileName = null;
		String path = "D:" + File.separator + "appInfoImg";
		if (file != null) {
			fileName = RandomUtils.nextInt(1000000) + "version.apk";
			try {
				File save = new File(path, fileName);
				file.transferTo(save);
				strings.add(path);
				strings.add(fileName);
				result.setData(strings);
				result.setSuccess(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	@RequestMapping("queryVersion")
	@ResponseBody
	public HttpResult<AppVersion> queryVersion(Integer id){
		HttpResult<AppVersion> result=new HttpResult<AppVersion>();
		AppVersion version=	appVersionService.queryAppVersion(id);
		if(version!=null){
			result.setCode(0);
			result.setData(version);
		}else{
			result.setMsg("版本不存在");
		}
		return result;
	}
	
	@RequestMapping("deleteapk")
	@ResponseBody
	public HttpResult<Integer> deleteApk(String apkName){
		HttpResult<Integer> result=new HttpResult<Integer>();
		String path="D:"+File.separator+"appInfoImg";
		File file=new File(path,apkName);
		if(file.exists()){
			result.setCode(0);
			result.setSuccess(file.delete());
		}
		return result;
	}
	
	@RequestMapping("modifyVersion")
	@ResponseBody
	public HttpResult<AppVersion> modifyVersion(AppVersion version,HttpSession session){
		HttpResult<AppVersion> result=new HttpResult<AppVersion>();
		
		return result;
	}
}
