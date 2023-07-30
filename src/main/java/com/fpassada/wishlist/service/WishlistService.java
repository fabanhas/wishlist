package com.fpassada.wishlist.service;

import com.fpassada.wishlist.exception.WishlistException;
import com.fpassada.wishlist.model.Product;
import com.fpassada.wishlist.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WishlistService {

    @Autowired
    WishlistRepository repository;

    public void addProductOnWishlist(String clientId, Product product) throws WishlistException {
        if (checkWishlistLimit(clientId)) {
            throw new WishlistException("Limite de 20 produtos atingido na wishlist.", 1001);
        }
        repository.addProductOnWishlist(clientId, product);
    }

    public void deleteProduct(String clientId, String productId) {
        repository.deleteProduct(clientId, productId);
    }

    public List<Product> getClientWishlist(String clientId) {
        return repository.getClientWishlist(clientId);
    }

    public boolean verifyProductOnWishlist(String clientId, String productId) {
        return repository.verifyProductOnWishlist(clientId, productId);
    }

    private boolean checkWishlistLimit(String clientId) {
        List<Product> wishlist = repository.getClientWishlist(clientId);
        return wishlist.size() >= 20;
    }
}
