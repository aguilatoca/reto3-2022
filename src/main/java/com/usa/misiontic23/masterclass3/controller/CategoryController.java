package com.usa.misiontic23.masterclass3.controller;


import com.usa.misiontic23.masterclass3.entities.Category;
import com.usa.misiontic23.masterclass3.entities.Product;
import com.usa.misiontic23.masterclass3.service.CategoryService;
import com.usa.misiontic23.masterclass3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")

public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAll(){
        return categoryService.getALL();
    }
    @PostMapping("/save")
    public Category save(@RequestBody Category p){
        return categoryService.save(p);
    }

}
