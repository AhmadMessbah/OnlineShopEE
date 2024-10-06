package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.User;
import com.mftplus.demo.model.repository.UserRepository;

public class UserService {

    public static void save(User user) throws Exception {

        try (UserRepository userRepository = new UserRepository()) {
            userRepository.save(user);
        }
    }

    public static void edit(User user) throws Exception {

        try (UserRepository userRepository = new UserRepository()) {
            userRepository.edit(user);
        }
    }
}
