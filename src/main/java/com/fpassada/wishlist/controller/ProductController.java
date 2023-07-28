package com.fpassada.wishlist.controller;

import com.fpassada.wishlist.model.Product;
import com.fpassada.wishlist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class ProductController {

    @Autowired
    ProductService service;


    @GetMapping("/getProduct")
    public Product getPatient(@RequestParam String name ) throws InterruptedException, ExecutionException {
        return service.getProduct(name);
    }

    @PostMapping("/addProduct")
    public String createPatient(@RequestBody Product product ) throws InterruptedException, ExecutionException {
        return service.addProduct(product);
    }

    @PutMapping("/updateProduct")
    public String updatePatient(@RequestBody Product product  ) throws InterruptedException, ExecutionException {
        return service.updateProduct(product);
    }

    @DeleteMapping("/deleteProduct")
    public String deletePatient(@RequestParam String name){
        return service.deleteProduct(name);
    }
}
