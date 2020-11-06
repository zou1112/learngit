package cn.appinfo.dao.appinfo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.appinfo.pojo.AppInfo;

public interface AppInfoMapper {
	public List<AppInfo> queryAppInfoList(Map<String, Object> map);
	
	public int queryAppInfoCount(Map<String, Object> map);
	
	public int addAppInfo(AppInfo appInfo);
	
	
	public int deleteAppInfo(Integer id);
	
	public int modifyAppInfo(AppInfo appInfo);
	
	public AppInfo queryAppInfoById(Integer id);
	
	public int modifyVersion(@Param("appId")Integer appId,@Param("versionId")Integer versionId);
	
	public int modifyStatu(@Param("status")Integer status,@Param("id")Integer id);
	
	

}
