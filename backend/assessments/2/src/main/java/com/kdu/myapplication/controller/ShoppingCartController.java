//package com.kdu.myapplication.controller;
//
//import com.kdu.myapplication.dto.ShoppingCartDTO;
//import com.kdu.myapplication.mapper.ShoppingCartMapper;
//import com.kdu.myapplication.service.ShoppingCartService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/shopping-cart")
//public class ShoppingCartController {
//
//    private ShoppingCartService shoppingCartService;
//
//    private ShoppingCartMapper shoppingCartMapper;
//
//    @Autowired
//
//    public ShoppingCartController(ShoppingCartService shoppingCartService, ShoppingCartMapper shoppingCartMapper) {
//        this.shoppingCartService = shoppingCartService;
//        this.shoppingCartMapper = shoppingCartMapper;
//    }
//
//    @PostMapping("/save")
//    public ResponseEntity<String> saveShoppingCart(@RequestBody ShoppingCartDTO shoppingCartDTO) {
//
//        shoppingCartService.saveShoppingCart(shoppingCartDTO);
//        return ResponseEntity.ok("ShoppingCart saved successfully!");
//    }
//}