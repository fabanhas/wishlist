# Wishlist - Projeto com Spring Boot e Firebase

O projeto Wishlist é uma aplicação desenvolvida em Java com o framework Spring Boot e utiliza o Firebase como banco de dados para gerenciar listas de desejos (wishlist) de clientes. Nesta aplicação, os clientes podem adicionar produtos às suas listas de desejos e verificar se um determinado produto está presente na lista.

## Funcionalidades

- Adicionar um produto à wishlist do cliente.
- Remover um produto da wishlist do cliente.
- Consultar todos os produtos da wishlist do cliente.
- Verificar se um determinado produto está presente na wishlist do cliente.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Firebase (Firestore)

## Configuração do Projeto

1. Clone o repositório para sua máquina local:

```bash
git clone https://github.com/fabanhas/wishlist.git
```

Importe o projeto na sua IDE de preferência (Eclipse, IntelliJ, etc.).

Certifique-se de ter o Java JDK e o Maven instalados em sua máquina.


Configure as credenciais do Firebase no projeto:

- Acesse o console do Firebase em https://console.firebase.google.com/
- Crie um novo projeto ou utilize um projeto existente.
- No projeto, acesse "Configurações" (ícone de engrenagem) > "Configurações do projeto" > "Contas de serviço".
- Clique em "Gerar nova chave privada" para obter um arquivo JSON com as credenciais do serviço.
- Salve o arquivo JSON na raiz do projeto com o nome "serviceAccountKey.json".

Observação: É necessário criar a collection "clientes" no banco de dados Firestore do Firebase com um id e dentro dela a "wishlist" para que o projeto funcione corretamente. O projeto utiliza essas collections para armazenar os clientes e seus respectivos produtos na wishlist.

Executando a Aplicação
Para executar a aplicação, você pode usar o comando Maven da seguinte forma:

```bash
mvn spring-boot:run
```

A aplicação será iniciada e estará disponível em http://localhost:8080.

## Endpoints

A aplicação possui os seguintes endpoints:

POST /wishlist/v1/{clientId}/add: Adiciona um produto à wishlist do cliente com o ID especificado no caminho (clientId). O produto a ser adicionado deve ser fornecido no corpo da requisição em formato JSON. Exemplo de payload: {"id": "produto_id_1", "name": "Nome do Produto 1"}.

DELETE /wishlist/v1/{clientId}/delete/{productId}: Remove um produto da wishlist do cliente com o ID especificado no caminho (clientId) e o ID do produto a ser removido também no caminho (productId).

GET /wishlist/v1/{clientId}: Consulta todos os produtos da wishlist do cliente com o ID especificado no caminho (clientId).

GET /wishlist/v1/{clientId}/verify/{productId}: Verifica se um produto com o ID especificado no caminho (productId) está presente na wishlist do cliente com o ID especificado no caminho (clientId).

## Testes

O projeto possui testes automatizados usando o framework Cucumber para testes BDD. Para executar os testes, utilize o comando Maven:

```bash
mvn test
```

## Considerações Finais

O projeto Wishlist é uma aplicação simples, mas demonstra como desenvolver uma feature de wishlist com o uso do Spring Boot e Firebase como um microserviço. Sinta-se à vontade para estender as funcionalidades ou personalizar o projeto de acordo com suas necessidades.

Espero que este README tenha sido útil para compreender o projeto e executá-lo em sua máquina. Se tiver alguma dúvida ou sugestão, não hesite em entrar em contato.

Divirta-se codificando! 🚀