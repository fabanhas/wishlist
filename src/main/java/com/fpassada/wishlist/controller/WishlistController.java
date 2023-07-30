package com.fpassada.wishlist.controller;

import com.fpassada.wishlist.exception.WishlistException;
import com.fpassada.wishlist.model.Product;
import com.fpassada.wishlist.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class WishlistController {

    @Autowired
    WishlistService service;


    @PostMapping("/{clientId}/add")
    public ResponseEntity<?> addProductOnWishlist(@PathVariable String clientId,
                                       @RequestBody Product product) throws InterruptedException, ExecutionException, WishlistException {
        try {
            service.addProductOnWishlist(clientId, product);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (WishlistException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/{clientId}/delete/{productId}")
    public ResponseEntity<?> deletePatient(@PathVariable String clientId,@PathVariable String productId){
        service.deleteProduct(clientId, productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{clientId}/list")
    public ResponseEntity<List<Product>> getClientWishlist(@PathVariable String clientId) throws InterruptedException, ExecutionException, WishlistException {
        List<Product> wishlist = service.getClientWishlist(clientId);
        return new ResponseEntity<>(wishlist, HttpStatus.OK);
    }

    @GetMapping("/{clientId}/verify/{productId}")
    public ResponseEntity<?> verifyProductOnWishlist(
            @PathVariable String clientId,
            @PathVariable String productId) {

        boolean productOnWishlist = service.verifyProductOnWishlist(clientId, productId);

        if (productOnWishlist) {
            return new ResponseEntity<>("Produto está na wishlist do cliente.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Produto não está na wishlist do cliente.", HttpStatus.OK);
        }
    }



}
