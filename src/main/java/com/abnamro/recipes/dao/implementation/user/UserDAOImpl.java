package com.abnamro.recipes.dao.implementation.user;

import com.abnamro.recipes.dao.definition.user.IUserDAO;
import com.abnamro.recipes.dao.entity.user.UserEntity;
import com.abnamro.recipes.dao.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDAOImpl implements IUserDAO {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserEntity createUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

}
