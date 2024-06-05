package com.microServiceArch.order_service.controllers;


import com.microServiceArch.order_service.dto.OrderReq;
import com.microServiceArch.order_service.dto.OrderRes;
import com.microServiceArch.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OderController {

    private final OrderService orderService ;
    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody OrderReq orderReq){
        orderService.createOrder(orderReq);
        return new ResponseEntity<>(HttpStatus.CREATED) ;
    }

}
