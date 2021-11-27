package com.leadsquared.ecommerceapi.repository;

import com.leadsquared.ecommerceapi.model.Book;
import com.leadsquared.ecommerceapi.persistence.Cart;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@EnableJpaRepositories
public interface CartRepository extends ConfigurationRepository<Cart,Integer> {
    //public Book findByName(String name);
    //public Book save(Book book);
}
