package com.leadsquared.ecommerceapi.controller.books;

import com.leadsquared.ecommerceapi.Constants;
import com.leadsquared.ecommerceapi.model.Book;
import com.leadsquared.ecommerceapi.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface CartApi {

    //TODO need to generate api responce through swagger

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PostMapping(value = Constants.REST_API_BOOKS_FULL_PATH,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    void addCart(@RequestBody Product body) throws Exception;


}
