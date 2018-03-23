package com.reljicd.service;

import com.reljicd.model.User;

import java.util.Optional;

/**
 * Created by Dusan on 19-May-17.
 */
public interface UserService {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    User saveUser(User user);

}
