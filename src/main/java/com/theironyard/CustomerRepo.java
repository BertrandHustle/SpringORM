package com.theironyard;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Scott on 5/21/16.
 */
public interface CustomerRepo extends CrudRepository<Customer, Integer>{
}
