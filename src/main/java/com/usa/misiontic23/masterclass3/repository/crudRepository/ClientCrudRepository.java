package com.usa.misiontic23.masterclass3.repository.crudRepository;

import com.usa.misiontic23.masterclass3.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository<Category, Integer> {
}
