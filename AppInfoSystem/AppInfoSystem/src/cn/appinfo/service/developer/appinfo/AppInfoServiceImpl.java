package cn.appinfo.service.developer.appinfo;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.appinfo.dao.appinfo.AppInfoMapper;
import cn.appinfo.dao.appversion.AppVersionMapper;
import cn.appinfo.pojo.AppInfo;
import cn.appinfo.pojo.AppVersion;

@Service
@Transactional
public class AppInfoServiceImpl implements AppInfoService {

	@Resource
	private AppInfoMapper appInfoMapper;

	@Resource
	private AppVersionMapper appVersionMapper;

	public List<AppInfo> queryAppInfoList(Map<String, Object> map) {
		return appInfoMapper.queryAppInfoList(map);
	}

	public int queryAppInfoCount(Map<String, Object> map) {
		return appInfoMapper.queryAppInfoCount(map);
	}

	public int addAppInfo(AppInfo appInfo) {
		return appInfoMapper.addAppInfo(appInfo);
	}

	public int deleteAppInfo(Integer id) {
		return appInfoMapper.deleteAppInfo(id);
	}

	@Transactional
	public boolean deleteApp(Integer id) {
		List<AppVersion> appVersions = appVersionMapper.queryAppVerSionList(id);
		AppInfo appInfo = queryAppInfoById(id);
		boolean flag = false;
		boolean check=true;
		try {
			if (appVersionMapper.deleteVerSion(id) >= 0) {
				if (deleteAppInfo(id) > 0) {
					flag = true;
				}
			}
			if (flag) {
				if(appVersions!=null && appVersions.size()>0){
					for (AppVersion appVersion : appVersions) {
						File file = new File(appVersion.getApkLocPath(),
								appVersion.getApkFileName());
						System.out.println(appVersion.getApkLocPath());
						if (file.exists()) {
							if(!file.delete()){
								check=false;
							}
						}
				}
			}
				if (appInfo != null) {
					File file = new File(appInfo.getLogoPicPath(),
							appInfo.getLogoLocPath());
					if (file.exists()) {
						if(!file.delete()){
							check=false;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	public int modifyAppInfo(AppInfo appInfo) {
		return appInfoMapper.modifyAppInfo(appInfo);
	}

	@Override
	public int modifyVersion(Integer appId, Integer versionId) {
		return appInfoMapper.modifyVersion(appId, versionId);
	}

	@Override
	public AppInfo queryAppInfoById(Integer id) {
		return appInfoMapper.queryAppInfoById(id);
	}

}
