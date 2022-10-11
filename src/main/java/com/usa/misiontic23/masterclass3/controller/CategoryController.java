package com.usa.misiontic23.masterclass3.controller;


import com.usa.misiontic23.masterclass3.entities.Category;
import com.usa.misiontic23.masterclass3.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")

public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAll(){
        return categoryService.getALL();
    }
    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int id){
        return categoryService.getCategory(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Category save(@RequestBody Category p){
        return categoryService.save(p);
    }

}
