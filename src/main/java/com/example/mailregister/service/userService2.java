package com.example.mailregister.service;

import com.example.mailregister.entity.User2;
import com.example.mailregister.entity.dto.userDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class userService2 {
    @Autowired
    private com.example.mailregister.repository.userRepository userRepository;

    public User2 createUser(userDto userDto) {
        User2 user2 = new User2();

        user2.setVipid(userDto.getVipid());
        user2.setViptype(userDto.getViptype());
        user2.setPrice(userDto.getPrice());
        user2.setEmail(userDto.getEmail());
        user2.setStart(userDto.getStart());
        user2.setEnd(userDto.getEnd());

        return userRepository.save(user2);
    }

}
