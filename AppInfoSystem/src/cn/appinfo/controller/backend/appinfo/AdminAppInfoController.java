package cn.appinfo.controller.backend.appinfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.appinfo.pojo.AppInfo;
import cn.appinfo.service.backend.appinfo.AdminAppInfoService;
import cn.appinfo.service.developer.appinfo.AppInfoService;
import cn.appinfo.service.developer.appversion.AppVersionService;
import cn.appinfo.tools.HttpResult;
@Controller
@RequestMapping("/backend")
public class AdminAppInfoController {
	
	@Resource
	private AppInfoService appInfoService;
	@Resource
	private AdminAppInfoService adminAppInfoService;
	
	@Resource
	private AppVersionService appVersionService;
	@RequestMapping("/appInfoList")
	@ResponseBody
	public HttpResult<List<AppInfo>> appInfoList(String softwareName,
							  Integer categoryLevel1,Integer categoryLevel2,
							  Integer categoryLevel3,
							  Integer flatformId,
							  Integer devId,
							  Integer page,
							  Integer limit){
		Map<String, Object> map=new HashMap<String, Object>();
		HttpResult<List<AppInfo>> result=new HttpResult<List<AppInfo>>();
			map.put("softwareName", softwareName);
			map.put("status", 1);
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
	
	@RequestMapping("/modifyStatus")
	@ResponseBody
	public HttpResult<Integer> modifyStatus(Integer status,Integer id){
		HttpResult<Integer> result=new HttpResult<Integer>();
		if(adminAppInfoService.modifyStatu(status, id)>0){
			result.setCode(0);
			result.setSuccess(true);
		}
		return result;
	}

}
