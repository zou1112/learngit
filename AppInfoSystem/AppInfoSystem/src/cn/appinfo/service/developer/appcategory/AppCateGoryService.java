package cn.appinfo.service.developer.appcategory;

import java.util.List;

import cn.appinfo.pojo.AppCategory;

public interface AppCateGoryService {
	
	public List<AppCategory> cateList(String parentId);

}
