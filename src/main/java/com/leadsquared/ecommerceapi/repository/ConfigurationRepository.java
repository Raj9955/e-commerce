package com.leadsquared.ecommerceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@NoRepositoryBean
public interface  ConfigurationRepository<T, ID extends Serializable>
        extends JpaRepository<T, ID> {


}
