package com.briup.apps.app02.web.controller;

import com.briup.apps.app02.bean.User;
import com.briup.apps.app02.service.IUserService;
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
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @ApiOperation("模糊查询")
    @GetMapping("query")
    public Message query(User user){
        List<User> list = userService.query(user);
        return MessageUtil.success("success",list);
    }


    @GetMapping("findAll")
    public Message findAll(){
        List<User> list = userService.findAll();
        return MessageUtil.success("success",list);
    }

    @ApiOperation("通过id查询")
    @GetMapping("findById")
    public Message findById(
            @ApiParam(value = "主键",required = true)
            @RequestParam(value = "id") long id){
        User user = userService.findById(id);
        return MessageUtil.success("success",user);
    }

    @ApiOperation("保存或更新用户信息")
    @GetMapping("saveOrUpdate")
    public Message saveOrUpdate(User user){
       try {
           userService.saveOrUpdate(user);
           return MessageUtil.success("保存成功!");
       } catch (Exception e) {
           e.printStackTrace();
           return MessageUtil.error(e.getMessage());
       }
    }

    @ApiOperation("通过id删除用户信息")
    @GetMapping("deleteById")
    public Message deleteById(@ApiParam(value = "主键",required = true) @RequestParam("id") long id){
        try {
           userService.deleteById(id);
           return MessageUtil.success("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

}
