package com.leadsquared.ecommerceapi.controller.books;

import com.leadsquared.ecommerceapi.Constants;
import com.leadsquared.ecommerceapi.model.CheckoutResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface CheckoutApi {

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PostMapping(value = Constants.REST_API_CHECKOUT_FULL_PATH)
    public CheckoutResponse checkout();
}
