package com.abnamro.recipes.controller.user;

import com.abnamro.recipes.dao.model.user.UserModel;
import com.abnamro.recipes.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserModel> signup(@RequestBody UserModel input) {

        UserModel userModel = userService.signup(input);
        return new ResponseEntity<>(userModel, HttpStatus.OK);
    }

}
