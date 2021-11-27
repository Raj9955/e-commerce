package com.leadsquared.ecommerceapi.controller;

import com.leadsquared.ecommerceapi.Constants;
import com.leadsquared.ecommerceapi.model.Book;
import com.leadsquared.ecommerceapi.model.Product;
import com.leadsquared.ecommerceapi.service.BookService;
import com.leadsquared.ecommerceapi.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController implements CartApi{

    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    @Autowired
    private CartService cartService;

    @Override
    public void addCart(@RequestBody Product item) throws Exception {

        int id = item.getId();
        logger.info("Received POST Request For Cart Product Type : {} ID : {}",item.getType(),item.getId());
        //currently only book service is there
        cartService.addToCart(item);
        logger.info("Product Id {} Added to Cart",item.getId());

    }


}
