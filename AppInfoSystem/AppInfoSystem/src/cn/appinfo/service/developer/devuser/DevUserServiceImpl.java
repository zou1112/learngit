package cn.appinfo.service.developer.devuser;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appinfo.dao.devuser.DevUserMapper;
import cn.appinfo.pojo.DevUser;

@Service("devUserService")
public class DevUserServiceImpl implements DevUserService {
	@Resource
	private DevUserMapper devUserMapper;

	public DevUser toLogin(String userName, String pwd) {
		return devUserMapper.toLogin(userName, pwd);
	}

}
