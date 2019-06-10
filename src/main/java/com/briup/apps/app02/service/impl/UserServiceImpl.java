package com.briup.apps.app02.service.impl;

import com.briup.apps.app02.bean.User;
import com.briup.apps.app02.bean.UserExample;
import com.briup.apps.app02.dao.UserMapper;
import com.briup.apps.app02.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    // 自动注入mapper实例
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> query(User user) {
        // 创建空模板
        UserExample example = new UserExample();
        // 在模板中添加条件
        if(user.getRealname()!=null){
            example
            .createCriteria()
            .andRealnameLike("%"+user.getRealname()+"%");
        }
        if(user.getTelephone()!=null){
            example
            .createCriteria()
            .andTelephoneLike("%"+user.getTelephone()+"%");
        }
        if(user.getGender()!=null){
            example.createCriteria().andGenderEqualTo(user.getGender());
        }

        return userMapper.selectByExample(example);
    }

    @Override
    public List<User> findAll() {
        UserExample example = new UserExample();
        return userMapper.selectByExample(example);
    }

    @Override
    public User findById(long id) {
        // 调用mapper层代码完成查询操作
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(User user) throws Exception {
        if(user.getId() == null){
            // 初始化属性
            user.setStatus("正常");
            userMapper.insert(user);
        } else {
            userMapper.updateByPrimaryKey(user);
        }
    }

    @Override
    public void deleteById(long id) throws Exception {
        User user = userMapper.selectByPrimaryKey(id);
        if(user == null){
            throw new Exception("要删除的用户不存在");
        } else {
            userMapper.deleteByPrimaryKey(id);
        }
    }
}
