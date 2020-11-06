package cn.appinfo.controller.developer.appinfo;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.appinfo.pojo.AppInfo;
import cn.appinfo.pojo.AppVersion;
import cn.appinfo.pojo.DevUser;
import cn.appinfo.service.developer.appinfo.AppInfoService;
import cn.appinfo.service.developer.appversion.AppVersionService;
import cn.appinfo.tools.Constants;
import cn.appinfo.tools.HttpResult;

@Controller
@RequestMapping("/appinfo")
public class AppInfoController {
	@Resource
	private AppInfoService appInfoService;
	
	@Resource
	private AppVersionService appVersionService;
	@RequestMapping("/appInfoList")
	@ResponseBody
	public HttpResult<List<AppInfo>> appInfoList(String softwareName,Integer status,
							  Integer categoryLevel1,Integer categoryLevel2,
							  Integer categoryLevel3,
							  Integer flatformId,
							  Integer devId,
							  Integer page,
							  Integer limit){
		Map<String, Object> map=new HashMap<String, Object>();
		HttpResult<List<AppInfo>> result=new HttpResult<List<AppInfo>>();
			map.put("softwareName", softwareName);
			map.put("status", status);
			map.put("categoryLevel1", categoryLevel1);
			map.put("categoryLevel2", categoryLevel2);
			map.put("categoryLevel3", categoryLevel3);
			map.put("flatformId", flatformId);
			map.put("devId", devId);
			map.put("page", (page-1)*limit);
			map.put("limit", limit);
		Integer count=appInfoService.queryAppInfoCount(map);
		List<AppInfo> appInfos=appInfoService.queryAppInfoList(map);
		result.setData(appInfos);
		result.setCode(0);
		result.setCount(count);
		return result;
	}
	
	
	@RequestMapping("/addAppInfo")
	@ResponseBody
	public HttpResult<Object> addAppInfo(AppInfo appInfo,HttpSession session){
		appInfo.setDevId(((DevUser)session.getAttribute(Constants.USER_SESSION)).getId());
		HttpResult<Object> result=new HttpResult<Object>();
		if(appInfo.getId()!=null){
			appInfo.setModifyDate(new Date());
			appInfo.setModifyBy(((DevUser)session.getAttribute(Constants.USER_SESSION)).getId());		
			if(appInfoService.modifyAppInfo(appInfo)>0){
				result.setCode(0);
				result.setSuccess(true);
			}   
		}else{
			appInfo.setCreationDate(new Date());
			appInfo.setCreatedBy(((DevUser)session.getAttribute(Constants.USER_SESSION)).getId());
			if(appInfoService.addAppInfo(appInfo)>0){
				result.setCode(0);
				result.setSuccess(true);
			}     
		}
		return result;
	}
	/**
	 * 上传图片
	 * @param file
	 * @param request
	 * @return 图片路径
	 */
	@RequestMapping("/add")
	@ResponseBody
	public HttpResult<String> add(MultipartFile file){
		HttpResult<String>  result=new HttpResult<String>();
		String path="D:"+File.separator+"appInfoImg";
		try {
			String fileName = RandomUtils.nextInt(1000000) + "appinfo.jpg";
			File save = new File(path, fileName);
			file.transferTo(save);
			result.setCode(0);
			result.setSuccess(true);
			result.setPath(path);
			result.setImgName(fileName);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
	@RequestMapping("/delete")
	@ResponseBody
	public HttpResult<Integer> deleteAppInfo(Integer id){
		HttpResult<Integer> result=new HttpResult<Integer>();
		if(appInfoService.deleteApp(id)){
			result.setCode(0);
			result.setSuccess(true);
		}
		return result;
	}
	@RequestMapping("/deleteLogo")
	@ResponseBody
	public HttpResult<Integer> deleteLogo(String logoName){
		HttpResult<Integer> result=new HttpResult<Integer>();
		String path="D:"+File.separator+"appInfoImg";
		File file=new File(path,logoName);
		if(file.exists()){
			result.setCode(0);
			result.setSuccess(file.delete());
		}
		return result;
	}
}
