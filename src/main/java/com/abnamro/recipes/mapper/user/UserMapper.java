package com.abnamro.recipes.mapper.user;

import com.abnamro.recipes.dao.entity.user.UserEntity;
import com.abnamro.recipes.dao.model.user.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserModel toModel(final UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }

        return UserModel.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .password(userEntity.getPassword())
                .build();
    }

    public UserEntity toDto(final UserModel userModel) {
        return UserEntity.builder()
                .id(userModel.getId())
                .name(userModel.getName())
                .password(userModel.getPassword())
                .build();
    }

}
