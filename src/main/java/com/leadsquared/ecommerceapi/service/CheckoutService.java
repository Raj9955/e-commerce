package com.leadsquared.ecommerceapi.service;

import com.leadsquared.ecommerceapi.controller.books.CartController;
import com.leadsquared.ecommerceapi.model.Book;
import com.leadsquared.ecommerceapi.model.CheckoutResponse;
import com.leadsquared.ecommerceapi.model.Product;
import com.leadsquared.ecommerceapi.persistence.Cart;
import com.leadsquared.ecommerceapi.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CheckoutService {

    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    @Autowired
    BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    public CheckoutResponse checkout()
    {
        logger.info("checkout service started");

        double totalPrice=0;
        //fetch all products from cart table
        //iterate over it and compute price

        List<Cart> products = bookRepository.findAll();

        logger.info("number of elements : {}",products.size());
        CheckoutResponse checkoutResponse = new CheckoutResponse();

        ArrayList<Product> productList = new ArrayList<Product>();
        for(Cart product:products)
        {
            logger.info("product name {} has price {}",product.getName(),product.getPrice());
            Product p = new Product();
            if("book".equalsIgnoreCase(product.getType()))
            {
                double bookPrice = bookService.computTotalBookPrice(product);
                totalPrice += bookPrice;

                p.setId(product.getId());
                p.setName(product.getName());
                p.setDescription(product.getDescription());
                p.setPrice(bookPrice);
                p.setType(product.getType());

                productList.add(p);
                logger.info("product name {} Final price {}",product.getName(),bookPrice);
            }
        }

        logger.info("buying {} elements",productList.size());
        checkoutResponse.setProducts(productList);


        //create seperate method for discounts
        double discountAmount=0;
        if(totalPrice >= 1500)
        {
            discountAmount = (totalPrice*0.05);
        }
        else if(totalPrice >= 2000)
        {
            discountAmount = (totalPrice*0.1);

        }

        checkoutResponse.setDiscount(discountAmount);

        int payableAmount=(int)Math.ceil(totalPrice-discountAmount);

        checkoutResponse.setTotalPrice(payableAmount);

        return checkoutResponse;

    }
}
