package cn.appinfo.service.backend.backuser;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appinfo.dao.backenduser.BackendUserMapper;
import cn.appinfo.pojo.BackendUser;

@Service
public class BackUserServiceImpl implements BackendUserService{

	@Resource
	private BackendUserMapper backendUserMapper;
	@Override
	public BackendUser toLogin(String userCode, String pwd) {
		return backendUserMapper.toLogin(userCode, pwd);
	}

}
