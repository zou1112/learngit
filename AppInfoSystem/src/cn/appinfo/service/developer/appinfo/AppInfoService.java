package cn.appinfo.service.developer.appinfo;

import java.util.List;
import java.util.Map;
import cn.appinfo.pojo.AppInfo;

public interface AppInfoService {
	public List<AppInfo> queryAppInfoList(Map<String, Object> map);
	
	public int queryAppInfoCount(Map<String, Object> map);
	
	public int addAppInfo(AppInfo appInfo);

	public int deleteAppInfo(Integer id);
	
	public boolean deleteApp(Integer id);
	
	public int modifyAppInfo(AppInfo appInfo);
	
	public int modifyVersion(Integer appId,Integer versionId);
	
	public AppInfo queryAppInfoById(Integer id);
	
}
