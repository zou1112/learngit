package cn.appinfo.service.backend.appversion;

import cn.appinfo.pojo.AppVersion;

public interface AdminAppVersionService {
	
	public AppVersion queryVersionByMaxVerSionId(Integer appId);
}
