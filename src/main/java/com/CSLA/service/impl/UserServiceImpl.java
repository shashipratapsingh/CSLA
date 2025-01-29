package com.CSLA.service.impl;

import com.CSLA.entity.Users;
import com.CSLA.mapper.UserMapper;
import com.CSLA.model.request.UsersRequest;
import com.CSLA.repository.UsersRepository;
import com.CSLA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository repository;

    @Override
    public int createUser(UsersRequest usersRequest) {
        Users users = UserMapper.toUser(usersRequest);
        users = repository.save(users);
        return users.getId();
    }
}
