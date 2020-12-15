package com.movie.service;

import com.movie.bean.Users;

public interface UsersService {
    int addUsers(Users users);

    Users getById(Integer user_id);

    Users  getAUser(Users users);

    int updateUser(Users users);

    int updatePhoto(Integer user_id, String photoUrl);
}
