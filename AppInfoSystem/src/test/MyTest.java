package test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;

import cn.appinfo.pojo.AppInfo;
import cn.appinfo.service.developer.appinfo.AppInfoService;
import cn.appinfo.service.developer.appinfo.AppInfoServiceImpl;
public class MyTest {
		private Logger logger=Logger.getLogger(getClass());
	@Test
	public void test() {
		AppInfoService appInfoService=new AppInfoServiceImpl();
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("softwareName", 1);
		map.put("status", 1);
		map.put("categoryLevel1", 1);
		map.put("categoryLevel2", 1);
		map.put("categoryLevel3", 1);
		map.put("flatformId", 1);
		map.put("devId", 1);
		map.put("page", 0);
		map.put("limit", 10);
		List<AppInfo> appInfos=appInfoService.queryAppInfoList(map);
		
		System.out.println(appInfos.size());
	}

}
