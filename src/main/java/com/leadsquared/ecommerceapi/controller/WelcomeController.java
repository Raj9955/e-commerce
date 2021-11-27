package com.leadsquared.ecommerceapi.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class WelcomeController {
    @GetMapping("/")
    public String welcome() {
        return "{\"message\" : \"Welcome to LeadSquared E-commerce API\"}";
    }
}
