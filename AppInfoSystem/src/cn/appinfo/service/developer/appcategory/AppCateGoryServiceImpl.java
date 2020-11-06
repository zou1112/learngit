package cn.appinfo.service.developer.appcategory;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.appinfo.dao.appcategory.AppCategoryMapper;
import cn.appinfo.pojo.AppCategory;

@Service
public class AppCateGoryServiceImpl implements AppCateGoryService{
	@Resource
	private AppCategoryMapper appCategoryMapper;
	public List<AppCategory> cateList(String parentId) {
		return appCategoryMapper.cateList(parentId);
	}

}
