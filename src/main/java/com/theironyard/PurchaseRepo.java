package com.theironyard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PurchaseRepo extends CrudRepository<Purchase, Integer>{
    List<Purchase> findByCategory(String category);

    @Query("SELECT p FROM Purchase p WHERE p.category LIKE CONCAT(?1, '%')")
    List<Purchase> findByCategoryStartsWith (String category);
}
