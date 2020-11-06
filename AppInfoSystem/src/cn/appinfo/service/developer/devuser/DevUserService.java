package cn.appinfo.service.developer.devuser;
import cn.appinfo.pojo.DevUser;
public interface DevUserService {
	public DevUser toLogin(String userName,String pwd);
}
