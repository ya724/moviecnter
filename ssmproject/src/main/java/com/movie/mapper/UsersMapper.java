package com.movie.mapper;

import com.movie.bean.Users;
import org.apache.ibatis.annotations.Param;

public interface UsersMapper {

    int addUsers(Users users);

    Users getById(Integer user_id);

    Users getAUser(Users users);

    int updateUser(Users users);

    int updatephoto(@Param("user_id") Integer user_id,@Param("img_url") String photoUrl);
}
