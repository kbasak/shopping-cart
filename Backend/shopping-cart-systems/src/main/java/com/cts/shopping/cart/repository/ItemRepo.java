package com.cts.shopping.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.shopping.cart.model.ItemDetails;

@Repository
public interface ItemRepo extends JpaRepository<ItemDetails, Long> {

}
