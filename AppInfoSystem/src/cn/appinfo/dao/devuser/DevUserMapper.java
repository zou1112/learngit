package cn.appinfo.dao.devuser;
import org.apache.ibatis.annotations.Param;
import cn.appinfo.pojo.DevUser;
public interface DevUserMapper {
	public DevUser toLogin(@Param("userCode")String userName,@Param("pwd")String pwd);
}
