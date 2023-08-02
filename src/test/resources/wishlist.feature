Feature: Wishlist
  Scenario: Adicionar produto à wishlist com limite de 20 produtos
    Given o cliente com ID "cliente_id_1" tem 19 produtos na wishlist
    When o cliente adiciona um novo produto à wishlist
    Then o produto é adicionado à wishlist do cliente

  Scenario: Verificar se um produto está na wishlist
    Given o cliente com ID "cliente_id_1" tem o produto com ID "produto_id_1" na wishlist
    When o cliente verifica se o produto com ID "produto_id_1" está na wishlist
    Then o sistema retorna que o produto está na wishlist do cliente