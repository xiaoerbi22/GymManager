﻿package com.scut.GymManager.service.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scut.GymManager.mapper.CourseInfoMapper;
import com.scut.GymManager.entity.CourseInfo;
import com.scut.GymManager.exception.CrudException;
import com.scut.GymManager.service.CourseInfoService;



@Service
public class CourseInfoServiceImpl implements CourseInfoService {

	private Logger log=LoggerFactory.getLogger(getClass());
	@Autowired
	private CourseInfoMapper courseInfoMapper;
	@Override
	public void createCourse(CourseInfo courseInfo) throws CrudException {
		int x=courseInfoMapper.insert(courseInfo);
		if(x==0) throw new CrudException("insert 出错");
	}

	@Override
	public void updateCourse(CourseInfo courseInfo) throws CrudException {
		int x=courseInfoMapper.updateById(courseInfo);
		if(x==0) throw new CrudException("update 出错");
	}

	@Override
	public void deleteCourse(String CourseId) throws CrudException {
		int x=courseInfoMapper.deleteById(CourseId);
		if(x==0) throw new CrudException("delete 出错");
	}

	@Override
	public List<CourseInfo> viewTable()  {
		
		return courseInfoMapper.selectList(null);
	}

	@Override
	public List<CourseInfo> viewCoachCourseTable(String coachId) {
		
		return courseInfoMapper.searchCoachList(coachId);
	}

	@Override
	public List<CourseInfo> viewVIPCourseTable(String VIPId) {
		return courseInfoMapper.searchVIPList(VIPId);
	}

}