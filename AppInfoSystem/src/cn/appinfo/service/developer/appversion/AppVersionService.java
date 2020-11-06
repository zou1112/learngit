package cn.appinfo.service.developer.appversion;

import java.util.List;

import cn.appinfo.pojo.AppVersion;

public interface AppVersionService {
	public int deleteVerSion(Integer id);

	public AppVersion queryAppVersion(Integer id);
	
	public int addVerSion(AppVersion appVersion);
	
	public List<AppVersion> queryAppVerSionList(Integer id);
	
	public boolean addVersion(AppVersion appVersion);
	
	public int modifyVersion(AppVersion appVersion);
	
	public AppVersion queryAppVersionByAppId(Integer id);


}
