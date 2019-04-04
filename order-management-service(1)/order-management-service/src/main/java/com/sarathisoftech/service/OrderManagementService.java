package com.sarathisoftech.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sarathisoftech.dto.Customer;
import com.sarathisoftech.dto.Item;
import com.sarathisoftech.entity.OrderInfo;
import com.sarathisoftech.entity.OrderedItem;
import com.sarathisoftech.proxyclient.CustomerClient;
import com.sarathisoftech.proxyclient.ItemClient;
import com.sarathisoftech.repository.OrderInfoRepository;
import com.sarathisoftech.repository.OrderedItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderManagementService {
    @Autowired
    private CustomerClient customerClient;
    @Autowired
    private ItemClient itemClient;

    @Autowired
    private OrderedItemRepository itemRepository;
    @Autowired
    private OrderInfoRepository orderInfoRepository;

    public Object portTest(long id) {
        return customerClient.home(id);
    }

    public List<Customer> getAllCustomers() {
        return customerClient.findAll();
    }

    public Customer getCustomerById(long id) {
        return customerClient.getById(id);
    }

    @Transactional
    public void submitOrder(long customerId, String itemId) {

        OrderedItem item = new OrderedItem();
        item.setQuantity(2);
        item.setProductId(Long.valueOf(itemId));

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setCustomerId(customerId);
        orderInfo.setOrderDate(new Date());


        orderInfo.setOrderedItemList(Collections.singletonList(item));

        orderInfoRepository.save(orderInfo);
    }

    @Transactional
    public List<OrderInfo> findOrdersByCustomerId(long id) {
        List<OrderInfo> all = orderInfoRepository.findAllByCustomerId(2l);
        all.forEach(cus -> cus.getOrderedItemList().get(0));
        log.info("printing " + all.toString());
        return all;
    }

    @Transactional
    public List<Item> ordersByCustomerId(long id) {
        List<Item> items;

        List<OrderInfo> allByCustomerId = orderInfoRepository.findAllByCustomerId(id);
        items = allByCustomerId.stream()
                .map(OrderInfo::getOrderedItemList)
                .flatMap(Collection::stream)
                .map(item -> itemClient.findById(item.getProductId()))
                .collect(Collectors.toList());

        return items;

    }


}
