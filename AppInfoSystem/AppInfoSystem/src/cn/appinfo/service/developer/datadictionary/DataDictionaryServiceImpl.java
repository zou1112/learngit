package cn.appinfo.service.developer.datadictionary;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appinfo.dao.datadictionary.DataDictionaryMapper;
import cn.appinfo.pojo.DataDictionary;
@Service
public class DataDictionaryServiceImpl implements DataDictionaryService{
	@Resource
	private DataDictionaryMapper dataDictionaryMapper;
	public List<DataDictionary> dataList(String status) {
		return dataDictionaryMapper.dataList(status);
	}

}
