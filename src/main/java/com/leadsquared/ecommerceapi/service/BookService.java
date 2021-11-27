package com.leadsquared.ecommerceapi.service;

import com.leadsquared.ecommerceapi.Constants;
import com.leadsquared.ecommerceapi.persistence.Cart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    public double computFinalPriceAfterTax(Cart book)
    {
        logger.info("computing tax on Books");
        double totalPrice = (book.getPrice() + (book.getPrice()* Constants.SALES_TAX));
        totalPrice = totalPrice + (totalPrice*Constants.VAT);

        if(book.isImported()==true)
        {
            totalPrice = totalPrice + (totalPrice*Constants.IMPORT_TAX);
        }
        return totalPrice;
    }
}
