package com.abnamro.recipes.service.user;

import com.abnamro.recipes.dao.entity.user.UserEntity;
import com.abnamro.recipes.dao.implementation.user.UserDAOImpl;
import com.abnamro.recipes.dao.model.user.UserModel;
import com.abnamro.recipes.mapper.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDAOImpl userDAOImpl;

/*    @Autowired
    private PasswordEncoder passwordEncoder;*/

    @Autowired
    private UserMapper userMapper;



    public UserModel signup(UserModel userModel) {
/*        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));

        UserEntity userEntity = userMapper.toDto(userModel);
        UserEntity returnEntity = userDAOImpl.createUser(userEntity);

        return userMapper.toModel(returnEntity);*/

        return null;
    }

}
