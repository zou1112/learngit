package cn.appinfo.controller.developer.datadictonary;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.jdbc.StringUtils;

import cn.appinfo.pojo.DataDictionary;
import cn.appinfo.service.developer.datadictionary.DataDictionaryService;
import cn.appinfo.tools.HttpResult;

@Controller
@RequestMapping("/dictionary")
public class DataDictionaryController {
	@Resource
	private DataDictionaryService dataDictionaryService;
	
	@RequestMapping("/dataList")
	@ResponseBody
	public HttpResult<List<DataDictionary>> dataList(String status){
		HttpResult<List<DataDictionary>> result=new HttpResult<List<DataDictionary>>();
		List<DataDictionary> dataList=null;
		if(!StringUtils.isEmptyOrWhitespaceOnly(status)){
			dataList=dataDictionaryService.dataList(status);
			result.setCode(0);
			result.setData(dataList);
			result.setSuccess(true);
		}else{
			result.setSuccess(false);
			result.setMsg("参数为空");
		}
		return result;
	}
	
}
