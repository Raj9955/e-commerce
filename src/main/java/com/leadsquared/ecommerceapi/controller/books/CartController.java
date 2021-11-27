package com.leadsquared.ecommerceapi.controller.books;

import com.leadsquared.ecommerceapi.Constants;
import com.leadsquared.ecommerceapi.model.Book;
import com.leadsquared.ecommerceapi.service.BookService;
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
    private BookService bookService;

    @Override
    public void addCart(@RequestBody Book book) throws Exception {

        int id = book.getId();
        logger.info("Received POST Request For Cart Product : {} ID : {}",book.getType(),book.getId());
        bookService.addBooks(book);
        logger.info("COMPLTED POST Request For Cart Product : {} ID : {}",book.getType(),book.getId());






    }


}
