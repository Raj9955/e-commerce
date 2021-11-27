package com.leadsquared.ecommerceapi.service;

import com.leadsquared.ecommerceapi.Constants;
import com.leadsquared.ecommerceapi.model.Book;
import com.leadsquared.ecommerceapi.persistence.Cart;
import com.leadsquared.ecommerceapi.repository.BookRepository;
//import com.leadsquared.ecommerceapi.repository.BookRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookRepository bookRepository;

/*    @Autowired
    private BookRepositoryImpl bookRepositoryImpl;*/

    public void addBooks(Book book)
    {
        logger.info("Book service called book ID : {}",book.getId());
       // bookRepositoryImpl.saveorUpdate(book);

        Cart c =new Cart();
        c.setId(book.getId());
        c.setName(book.getName());
        c.setDescription(book.getDescription());
        c.setPrice(book.getPrice());
        c.setType(book.getType());

        bookRepository.save(c);
    }

    public double computTotalBookPrice(Cart book)
    {
        logger.info("computing tax");
        double totalPrice = (book.getPrice() + (book.getPrice()* Constants.SALES_TAX));
        totalPrice = totalPrice + (totalPrice*Constants.VAT);

/*        if(book.isImported()==true)
        {
            totalPrice = totalPrice + (totalPrice*Constants.IMPORT_TAX);
        }*/

        return totalPrice;

    }


}
