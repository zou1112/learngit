package cn.appinfo.dao.backenduser;

import org.apache.ibatis.annotations.Param;

import cn.appinfo.pojo.BackendUser;

public interface BackendUserMapper {
	
	public BackendUser toLogin(@Param("userCode")String userCode,@Param("pwd")String pwd);

}
