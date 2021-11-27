package com.leadsquared.ecommerceapi.service;

import com.leadsquared.ecommerceapi.Constants;
import com.leadsquared.ecommerceapi.model.Book;
import com.leadsquared.ecommerceapi.model.Product;
import com.leadsquared.ecommerceapi.persistence.Cart;
import com.leadsquared.ecommerceapi.repository.CartRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private CartRepository cartRepository;

    public void addToCart(Product product)
    {
        logger.info("Add2Cart service called for Product ID : {}",product.getId());
        repositoryCalls(product);
    }



    public double computTotalBookPrice(Cart book)
    {
        logger.info("computing tax");
        double totalPrice = (book.getPrice() + (book.getPrice()* Constants.SALES_TAX));
        totalPrice = totalPrice + (totalPrice*Constants.VAT);

        if(book.isImported()==true)
        {
            totalPrice = totalPrice + (totalPrice*Constants.IMPORT_TAX);
        }

        return totalPrice;

    }


    public void repositoryCalls(Product product)
    {
        Cart c =new Cart();
        c.setId(product.getId());
        c.setName(product.getName());
        c.setDescription(product.getDescription());
        c.setPrice(product.getPrice());
        c.setType(product.getType());

        cartRepository.save(c);

    }


}
