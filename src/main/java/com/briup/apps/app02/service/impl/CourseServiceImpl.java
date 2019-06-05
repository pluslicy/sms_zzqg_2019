package com.briup.apps.app02.service.impl;

import com.briup.apps.app02.bean.Course;
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
        return courseMapper.selectAll();
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
