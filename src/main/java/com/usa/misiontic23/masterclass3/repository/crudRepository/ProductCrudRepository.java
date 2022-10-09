package com.usa.misiontic23.masterclass3.repository.crudRepository;

import com.usa.misiontic23.masterclass3.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<Product,Integer> {
}
