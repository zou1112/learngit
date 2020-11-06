package cn.appinfo.service.backend.appversion;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appinfo.dao.appversion.AppVersionMapper;
import cn.appinfo.pojo.AppVersion;
@Service
public class AdminAppVersionServiceImpl implements AdminAppVersionService{
	@Resource
	private AppVersionMapper appVersionMapper;
	@Override
	public AppVersion queryVersionByMaxVerSionId(Integer appId) {
		return appVersionMapper.queryVersionByMaxVerSionId(appId);
	}

}
