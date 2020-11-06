package cn.appinfo.dao.appversion;

import java.util.List;

import cn.appinfo.pojo.AppVersion;

public interface AppVersionMapper {
	
	public int deleteVerSion(Integer id);
	
	public AppVersion queryAppVersion(Integer id);
	
	public AppVersion queryAppVersionByAppId(Integer id);
	
	public int addVerSion(AppVersion appVersion);
	
	public List<AppVersion> queryAppVerSionList(Integer id);

	public int modifyVersion(AppVersion appVersion);
	
	public AppVersion queryVersionByMaxVerSionId(Integer appId);
}
