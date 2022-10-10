package com.usa.misiontic23.masterclass3.controller;


import com.usa.misiontic23.masterclass3.entities.Box;
import com.usa.misiontic23.masterclass3.entities.Product;
import com.usa.misiontic23.masterclass3.service.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Box")

public class BoxController {
    @Autowired
    private BoxService boxService;

    @GetMapping("/all")
    public List<Box> getAll(){
        return boxService.getALL();
    }
    @PostMapping("/save")
    public Box save(@RequestBody Box p){
        return boxService.save(p);
    }

}
