package com.briup.apps.app02.web.controller;

import com.briup.apps.app02.bean.Course;
import com.briup.apps.app02.bean.extend.CourseExtend;
import com.briup.apps.app02.service.ICourseService;
import com.briup.apps.app02.utils.Message;
import com.briup.apps.app02.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private ICourseService courseService;

    @ApiOperation("查询所有,课程中携带任课老师的信息")
    @GetMapping("findAllWithTeacher")
    public Message findAllWithTeacher(){
        List<CourseExtend> list = courseService.findAllWithTeacher();
        return MessageUtil.success("success",list);
    }

    @ApiOperation("查询所有")
    @GetMapping("findAll")
    public Message findAll(){
        List<Course> list = courseService.findAll();
        return MessageUtil.success("success",list);
    }

    @ApiOperation("通过id查询")
    @GetMapping("findById")
    public Message findById(@ApiParam(required = true) @RequestParam(value = "id") long id){
        Course course = courseService.findById(id);
        return MessageUtil.success("success",course);
    }
}
