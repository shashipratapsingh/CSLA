package com.CSLA.mapper;

import com.CSLA.entity.Users;
import com.CSLA.model.request.UsersRequest;
import org.springframework.beans.BeanUtils;

public class UserMapper {

    public  static Users toUser(UsersRequest usersRequest){
        Users users = new Users();
        BeanUtils.copyProperties(usersRequest, users);
        return users;
    }
}