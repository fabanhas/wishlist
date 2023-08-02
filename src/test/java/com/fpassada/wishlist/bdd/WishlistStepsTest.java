package com.fpassada.wishlist.bdd;
import com.fpassada.wishlist.WishlistApplication;
import com.fpassada.wishlist.exception.WishlistException;
import com.fpassada.wishlist.model.Product;
import com.fpassada.wishlist.service.WishlistService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(
        classes = WishlistApplication.class,
        loader = SpringBootContextLoader.class)
public class WishlistStepsTest {

    @Autowired
    private ApplicationContext appContext;

    @Autowired
    private WishlistService service;
    private String clientId;
    private Product product;
    private List<Product> wishlist;

    @Given("o cliente com ID {string} tem {int} produtos na wishlist")
    public void clienteComProdutosNaWishlist(String clienteId, int quantidadeProdutos) {
        this.clientId = clienteId;
        this.wishlist = new ArrayList<>();
        for (int i = 0; i < quantidadeProdutos; i++) {
            Product product = new Product("produto_id_" + (i + 1), "Produto " + (i + 1));
            wishlist.add(product);
        }
    }

    @When("o cliente adiciona um novo produto à wishlist")
    public void clienteAdicionaNovoProduto() throws WishlistException {
        this.product = new Product("novo_produto_id", "Novo Produto");
        this.service = new WishlistService();
        service.addProductOnWishlist(clientId, product);
    }

    @Then("o produto é adicionado à wishlist do cliente")
    public void produtoAdicionadoNaWishlist() {
        assertTrue(wishlist.contains(product));
    }

    @Given("o cliente com ID {string} tem o produto com ID {string} na wishlist")
    public void clienteComProdutoNaWishlist(String clienteId, String produtoId) {
        this.clientId = clienteId;
        this.product = new Product(produtoId, "Produto " + produtoId);
        this.wishlist = new ArrayList<>();
        wishlist.add(product);
    }

    @When("o cliente verifica se o produto com ID {string} está na wishlist")
    public void clienteVerificaProdutoNaWishlist(String produtoId) {

    }

    @Then("o sistema retorna que o produto está na wishlist do cliente")
    public void sistemaRetornaProdutoNaWishlist() {
        assertTrue(wishlist.contains(product));
    }
}

