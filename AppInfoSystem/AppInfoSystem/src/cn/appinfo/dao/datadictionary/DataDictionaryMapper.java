package cn.appinfo.dao.datadictionary;

import java.util.List;

import cn.appinfo.pojo.DataDictionary;

public interface DataDictionaryMapper {
	
	public List<DataDictionary> dataList(String status);

}
