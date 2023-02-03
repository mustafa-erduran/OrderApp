package com.defineX.OrderApp.controller;

import com.defineX.OrderApp.model.Bill;
import com.defineX.OrderApp.model.Order;
import com.defineX.OrderApp.model.User;
import com.defineX.OrderApp.service.OrderService;
import com.defineX.OrderApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController()
public class Controller {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/users")
    public ResponseEntity<HashSet<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping(value = "/users" )
    public ResponseEntity<User> createUser(@RequestBody User request) {
        return new ResponseEntity<>(userService.createUser(request), HttpStatus.CREATED);
    }

    @GetMapping(value = "/userfilter")
    public ResponseEntity<List<User>> filterUser(@RequestParam String filter){
        return new ResponseEntity<>(userService.filterUser(filter),HttpStatus.OK);
    }

    @GetMapping(value = "/bills")
    public ResponseEntity<List<Bill>> getAllBill(){
        return new ResponseEntity<>(orderService.getAllBill(),HttpStatus.OK);
    }

    @GetMapping(value = "/billfilter")
    public ResponseEntity<Integer> filterDate(@RequestParam String filter){
        return new ResponseEntity<>(orderService.filterDate(filter),HttpStatus.OK);
    }

    @PostMapping(value = "/order" )
    public ResponseEntity<Order> createOrder(@RequestBody Order request) {
        return new ResponseEntity<>(orderService.createOrder(request), HttpStatus.CREATED);
    }

    @GetMapping(value = "/billaverage")
    public ResponseEntity<Integer> averagePriceForFilteredBill(@RequestParam Integer price){
        return  new ResponseEntity<>(orderService.averagePriceForFilteredBill(price),HttpStatus.OK);
    }
    
}
