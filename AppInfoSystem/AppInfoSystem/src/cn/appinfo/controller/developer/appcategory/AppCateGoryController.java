package cn.appinfo.controller.developer.appcategory;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.appinfo.pojo.AppCategory;
import cn.appinfo.service.developer.appcategory.AppCateGoryService;
import cn.appinfo.tools.HttpResult;

@Controller
@RequestMapping("/cate")
public class AppCateGoryController {
	@Resource
	private AppCateGoryService appCateGoryService;
	@RequestMapping("/category")
	@ResponseBody
	public HttpResult<List<AppCategory>> cateList(String parentId){
		HttpResult<List<AppCategory>> result=new HttpResult<List<AppCategory>>();
		List<AppCategory> cateList=appCateGoryService.cateList(parentId);
		result.setData(cateList);
		result.setSuccess(true);
		return result;
	}
}
