package cn.appinfo.service.backend.appinfo;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appinfo.dao.appinfo.AppInfoMapper;

@Service
public class AdminAppInfoServiceImpl implements AdminAppInfoService{
	@Resource
	private AppInfoMapper appInfoMapper;
	
	public int modifyStatu(Integer status, Integer id) {
		return appInfoMapper.modifyStatu(status, id);
	}

}
