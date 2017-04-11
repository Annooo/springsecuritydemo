package com.study.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.dao.ResourcesDao;
import com.study.model.RResources;
import com.study.model.Resources;
import com.study.service.ResourcesService;
@Service("resourcesService")
public class ResourcesServiceImpl implements ResourcesService{
	
	@Resource
	private ResourcesDao resourcesDao;
	
	@Override
	public List<RResources> resourcesListWithRole(Integer rid) {
		return resourcesDao.resourcesListWithRole(rid);
	}

	@Override
	public PageInfo<Resources> selectByPage(Resources resources, int start, int length) {
		int page = start/length+1;  
		PageHelper.startPage(page, length);
        List<Resources> resourcelist = resourcesDao.queryAll(resources);
        return new PageInfo<>(resourcelist);
	}

	@Override
	public void addResources(Resources resources) {
		resourcesDao.addEntity(resources);
	}

	@Override
	public void delResources(Integer id) {
		resourcesDao.deleteEntity(id);
	}

	@Override
	public List<Resources> loadMenu(Resources resources) {
		return resourcesDao.loadMenu(resources);
	}

	@Override
	public List<Resources> queryAll() {
		return resourcesDao.queryAll(new Resources());
	}
	
}
