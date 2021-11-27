/*
package com.leadsquared.ecommerceapi.repository;

import com.leadsquared.ecommerceapi.model.Book;
import com.leadsquared.ecommerceapi.persistence.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class BookRepositoryImpl{

    @Autowired
    private BookRepository bookRepository;



    public void saveorUpdate(Book book) {
         try {
             Cart c =new Cart();
             c.setId(book.getId());
             c.setName(book.getName());
             c.setDescription(book.getDescription());
             c.setPrice(book.getPrice());
             c.setType(book.getType());

             bookRepository.save(c);
         }catch (Exception e)
         {

         }
    }

}
*/
