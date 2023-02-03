package com.defineX.OrderApp.service;

import com.defineX.OrderApp.model.Bill;
import com.defineX.OrderApp.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private List<Order> orderList = new ArrayList<>();
    private List<Bill> billList = new ArrayList<>();

    public Order createOrder(Order orderRequest){
        orderList.add(orderRequest);
        billList.add(Bill.builder().date(orderRequest.getDate()).price(orderRequest.getPrice()).build());
        return orderRequest;
    }

    public List<Bill> getAllBill(){
        return billList;
    }

    public Integer filterDate(String letter){
        return billList.stream().filter(x->x.getDate().equals(letter)).map(x -> x.getPrice()).reduce(0,Integer::sum);
    }

    public List<Bill> filterPriceForBill(Integer price){
        return billList.stream().filter(x -> x.getPrice() > price).collect(Collectors.toList());
    }

    public Integer averagePriceForFilteredBill(Integer price){
        int sumOfPrice = billList.stream().filter(x -> x.getPrice() > price).map(x -> x.getPrice()).reduce(0,Integer::sum);
        int size = billList.stream().filter(x -> x.getPrice() > price).collect(Collectors.toList()).size();
        return sumOfPrice/size;
    }
}
