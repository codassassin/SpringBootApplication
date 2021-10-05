package com.codassassin.tourmanagement.services.impl;


import com.codassassin.tourmanagement.model.Bookings;
import com.codassassin.tourmanagement.model.User;
import com.codassassin.tourmanagement.repository.UserRepository;
import com.codassassin.tourmanagement.services.UserService;
import com.codassassin.tourmanagement.services.UserManagementService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService, UserManagementService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User saveTourOperator(User user) {
        User new_user = new User();
        new_user.setFirstName(user.getFirstName());
        new_user.setLastName(user.getLastName());
        new_user.setEmail(user.getEmail());
        new_user.setUserType(user.getUserType());
        new_user.setUsername(user.getUsername());
        new_user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(new_user);
    }

    @Override
    public User updateTourOperator(long id, User user) {
        User existingUser = userRepository.getUserById(id);

        if(user.getFirstName() != null) {
            existingUser.setFirstName(user.getFirstName());
        }

        if(user.getLastName() != null) {
            existingUser.setLastName(user.getLastName());
        }

        if(user.getEmail() != null) {
            existingUser.setEmail(user.getEmail());
        }

        if(user.getUserType() != null) {
            existingUser.setUserType(user.getUserType());
        }

        if(user.getUsername() != null) {
            existingUser.setUsername(user.getUsername());
        }

        return existingUser;
    }

    @Override
    public User getUserOperator(long id, User user) {
        return userRepository.getUserById(id);
    }

    @Override
    public List<User> getAllEmployees() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(long id) {
        User newUser =  userRepository.getUserById(id);
        userRepository.delete(newUser);
    }
}
