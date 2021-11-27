package com.leadsquared.ecommerceapi;

public class Constants {

    public static final String REST_API_VERSION = "/sq/v1";
    public static final String REST_API_ECOMMERCE = REST_API_VERSION+"/ecommerce";
    public static final String REST_API_CART ="/cart";
    public static final String REST_API_CHECKOUT = "/checkout";


    public static final String REST_API_CART_FULL_PATH = REST_API_ECOMMERCE+REST_API_CART;
    public static final String REST_API_CHECKOUT_FULL_PATH = REST_API_ECOMMERCE+REST_API_CHECKOUT;

    //TODO : move these to enviroment service so these can be set from enviorment variables
    public static double SALES_TAX=0.08;
    public static double VAT=0.04;
    public static double IMPORT_TAX=0.05;

    public static int DISCOUNTABLE_AMOUNT1=1500;
    public static double AVAILABLE_DISCOUNT1=0.05;
    public static int DISCOUNTABLE_AMOUNT2=2000;
    public static double AVAILABLE_DISCOUNT2=0.1;



}
