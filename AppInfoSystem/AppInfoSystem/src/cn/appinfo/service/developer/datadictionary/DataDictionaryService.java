package cn.appinfo.service.developer.datadictionary;

import java.util.List;

import cn.appinfo.pojo.DataDictionary;

public interface DataDictionaryService {
	public List<DataDictionary> dataList(String status);
}
