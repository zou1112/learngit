package cn.appinfo.dao.appcategory;

import java.util.List;

import cn.appinfo.pojo.AppCategory;

public interface AppCategoryMapper {
	
	public List<AppCategory> cateList(String parentId);
	

}
