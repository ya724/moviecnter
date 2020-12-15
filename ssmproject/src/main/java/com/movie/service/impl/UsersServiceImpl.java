package com.movie.service.impl;

import com.movie.bean.Users;
import com.movie.mapper.UsersMapper;
import com.movie.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UsersServiceImpl implements UsersService {
    @Resource
    UsersMapper usersMapper;
    @Override
    public int addUsers(Users users) {
        return usersMapper.addUsers(users);
    }

    @Override
    public Users getById(Integer user_id) {
        return usersMapper.getById(user_id);
    }

    @Override
    public Users getAUser(Users users) {
        return usersMapper.getAUser(users);
    }

    @Override
    public int updateUser(Users users) {
        return usersMapper.updateUser(users);
    }

    @Override
    public int updatePhoto(Integer user_id, String photoUrl) {
        return usersMapper.updatephoto(user_id,photoUrl);
    }
}
