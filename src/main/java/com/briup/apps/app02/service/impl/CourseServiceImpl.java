package com.briup.apps.app02.service.impl;

import com.briup.apps.app02.bean.Course;
import com.briup.apps.app02.bean.CourseExample;
import com.briup.apps.app02.bean.extend.CourseExtend;
import com.briup.apps.app02.dao.CourseMapper;
import com.briup.apps.app02.dao.extend.CourseExtendMapper;
import com.briup.apps.app02.service.ICourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {
    @Resource
    private CourseMapper courseMapper;
    @Resource
    private CourseExtendMapper courseExtendMapper;

    @Override
    public List<Course> findAll() {
        //创建空模块
        CourseExample example = new CourseExample();
        return courseMapper.selectByExample(example);
    }

    @Override
    public Course findById(long id) {
        return courseMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CourseExtend> findAllWithTeacher() {
        return courseExtendMapper.selectAll();
    }
}
