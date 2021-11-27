package com.leadsquared.ecommerceapi.service;

import com.leadsquared.ecommerceapi.Constants;
import com.leadsquared.ecommerceapi.controller.CartController;
import com.leadsquared.ecommerceapi.model.CheckoutResponse;
import com.leadsquared.ecommerceapi.model.Product;
import com.leadsquared.ecommerceapi.persistence.Cart;
import com.leadsquared.ecommerceapi.repository.CartRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class CheckoutService {

    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    @Autowired
    BookService bookService;

    @Autowired
    private CartRepository cartRepository;

    public CheckoutResponse checkout()
    {
        logger.info("Checkout service started");

        DecimalFormat df=new DecimalFormat("#.##");
        double totalPrice=0;

        List<Cart> products = cartRepository.findAll();

        logger.info("number of items present in Cart : {}",products.size());
        CheckoutResponse checkoutResponse = new CheckoutResponse();

        ArrayList<Product> productList = new ArrayList<Product>();
        for(Cart product:products)
        {
            logger.info("product name {} -  price {}",product.getName(),product.getPrice());
            Product p = new Product();
            if("book".equalsIgnoreCase(product.getType()))
            {
                double finalPrice = bookService.computFinalPriceAfterTax(product);
                totalPrice += finalPrice;

                p.setId(product.getId());
                p.setName(product.getName());
                p.setDescription(product.getDescription());
                p.setPrice(finalPrice);
                p.setType(product.getType());

                productList.add(p);
                logger.info("product name {} Final price {}",product.getName(),finalPrice);
            }
        }

        logger.info("Checkout items {} ",productList.size());
        checkoutResponse.setProducts(productList);
        checkoutResponse.setTotalPrice(Double.parseDouble(df.format(totalPrice)));


        double discountAmount = discount(totalPrice);
        checkoutResponse.setDiscount(Double.parseDouble(df.format(discountAmount)));

        double payableAmount=Math.ceil(totalPrice-discountAmount);

        checkoutResponse.setPayableAmount(Double.parseDouble(df.format(payableAmount)));

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        checkoutResponse.setBillDate(formatter.format(date));

        return checkoutResponse;

    }

    private double discount(double totalPrice)
    {
        double discountAmount=0;

        if(totalPrice >= Constants.DISCOUNTABLE_AMOUNT1)
        {
            discountAmount = (totalPrice*Constants.AVAILABLE_DISCOUNT1);
        }
        else if(totalPrice >= Constants.DISCOUNTABLE_AMOUNT2)
        {
            discountAmount = (totalPrice*Constants.AVAILABLE_DISCOUNT2);

        }
        return discountAmount;
    }
}
