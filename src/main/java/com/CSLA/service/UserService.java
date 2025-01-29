package com.CSLA.service;

import com.CSLA.model.request.UsersRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    int createUser(UsersRequest usersRequest);
}