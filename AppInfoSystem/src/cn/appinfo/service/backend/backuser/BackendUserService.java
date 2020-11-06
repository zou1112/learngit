package cn.appinfo.service.backend.backuser;

import cn.appinfo.pojo.BackendUser;

public interface BackendUserService {
	public BackendUser toLogin(String userCode,String pwd);
}
