package com.usa.misiontic23.masterclass3.controller;


import com.usa.misiontic23.masterclass3.entities.Product;
import com.usa.misiontic23.masterclass3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")

public class BoxController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.getALL();
    }
    @PostMapping("/save")
    public Product save(@RequestBody Product p){
        return productService.save(p);
    }

}
