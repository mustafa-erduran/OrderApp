package com.defineX.OrderApp.service;

import com.defineX.OrderApp.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private HashSet<User> userList = new HashSet<>();

    public User createUser(User request){
        userList.add(request);
        return request;
    }

    public HashSet<User> getAllUsers() {
        return userList;
    }

    public List<User> filterUser(String letter){
        return userList.stream().filter(x -> x.getName().contains(letter)).collect(Collectors.toList());
    }

    public List<User> dateFilter(String letter){
        return userList.stream().filter(x -> x.getRegisterDate().equals(letter)).collect(Collectors.toList());
    }

}
