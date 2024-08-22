package com.example.mailregister.controller;

import com.example.mailregister.entity.User;
import com.example.mailregister.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserInfoController {
    //@CrossOrigin(originPatterns = "",allowCredentials = "true")
    @Autowired
    private UserService userService;

    @GetMapping(value="/userinfo")
    public User userinfo(int id){
        return userService.getUserById(id);
    }

    /**
     * 用户id的转发
     * */
    @GetMapping(value="/getuserid")
    public User getuserid(){
        return UserController.userid;
    }

    @GetMapping(value="/login")
    public String login(User user){
        User u = userService.get(user);
        if (u !=null){
            return "welcome";
        }
        return "error";
    }
}
