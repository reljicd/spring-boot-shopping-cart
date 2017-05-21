package com.reljicd.service;

import com.reljicd.model.User;

/**
 * Created by Dusan on 19-May-17.
 */
public interface UserService {

    User findByUsername(String username);

    User findByEmail(String email);

    User saveUser(User user);

}
