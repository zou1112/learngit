package cn.appinfo.service.developer.appversion;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.appinfo.dao.appversion.AppVersionMapper;
import cn.appinfo.pojo.AppVersion;
import cn.appinfo.service.developer.appinfo.AppInfoService;

@Service
@Transactional
public class AppVersionServiceImpl implements AppVersionService {

	@Resource
	private AppInfoService appInfoService;
	@Resource
	private AppVersionMapper appVersionMapper;

	public int deleteVerSion(Integer id) {
		return appVersionMapper.deleteVerSion(id);
	}

	public AppVersion queryAppVersion(Integer id) {
		return appVersionMapper.queryAppVersion(id);
	}

	public int addVerSion(AppVersion appVersion) {
		return appVersionMapper.addVerSion(appVersion);
	}

	public List<AppVersion> queryAppVerSionList(Integer id) {
		return appVersionMapper.queryAppVerSionList(id);
	}
	@Transactional
	public boolean addVersion(AppVersion appVersion) {
		if(addVerSion(appVersion)>0){
			if(appInfoService.modifyVersion(appVersion.getAppId(), appVersion.getId())>0){
				return true;
			}
		}
		return false;
	}
	public int modifyVersion(AppVersion appVersion) {
		return appVersionMapper.modifyVersion(appVersion);
	}

	@Override
	public AppVersion queryAppVersionByAppId(Integer id) {
		return appVersionMapper.queryAppVersionByAppId(id);
	}
}
