package com.fpassada.wishlist.repository;

import com.fpassada.wishlist.model.Product;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
public class WishlistRepository {
    private final String CLIENTES_COLLECTION = "clientes";
    private final Firestore db = FirestoreClient.getFirestore();

    public void addProductOnWishlist(String clientId, Product product) {
        DocumentReference clientRef = db.collection(CLIENTES_COLLECTION).document(clientId);
        clientRef.collection("wishlist").document(product.getId()).set(product);
    }

    public void deleteProduct(String clientId, String productId) {
        DocumentReference clientRef = db.collection(CLIENTES_COLLECTION).document(clientId);
        clientRef.collection("wishlist").document(productId).delete();
    }

    public List<Product> getClientWishlist(String clientId) {
        List<Product> products = new ArrayList<>();
        DocumentReference clientRef = db.collection(CLIENTES_COLLECTION).document(clientId);
        CollectionReference wishlistRef = clientRef.collection("wishlist");

        try {
            ApiFuture<QuerySnapshot> querySnapshot = wishlistRef.get();
            for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
                Product product = document.toObject(Product.class);
                products.add(product);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return products;
    }

    public boolean verifyProductOnWishlist(String clientId, String productId) {
        DocumentReference clientRef = db.collection(CLIENTES_COLLECTION).document(clientId);
        DocumentReference productRef = clientRef.collection("wishlist").document(productId);

        try {
            ApiFuture<DocumentSnapshot> documentSnapshot = productRef.get();
            return documentSnapshot.get().exists();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return false;
        }
    }

}
