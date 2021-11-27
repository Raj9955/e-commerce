package com.leadsquared.ecommerceapi.controller.books;

import com.leadsquared.ecommerceapi.model.CheckoutResponse;
import com.leadsquared.ecommerceapi.service.CheckoutService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckoutController implements CheckoutApi {

    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    @Autowired
    CheckoutService checkoutService;

    @Override
    public CheckoutResponse checkout() {
        logger.info("checkout controller ");
        return checkoutService.checkout();
    }
}
