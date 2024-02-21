# KWCommerce

KWCommerce é um projeto de comércio eletrônico desenvolvido com Spring Boot. Ele oferece uma API RESTful para gerenciar categorias, produtos, pedidos e usuários.

## Funcionalidades

- Categoria: Gerenciamento de categorias de produtos.
- Produto: Gerenciamento de produtos, incluindo criação, atualização, exclusão e busca por nome.
- Pedido: Criação e recuperação de pedidos de produtos.
- Usuário: Recuperação dos detalhes do usuário logado.

## Tecnologias Utilizadas
- Spring Boot: Framework para criação de aplicativos Java.
- Spring Data JPA: Facilita o acesso aos dados de bancos de dados relacionais.
- Spring Security: Oferece recursos de autenticação e autorização.
- H2 Database: Banco de dados em memória para ambiente de desenvolvimento.
- Hibernate Validator: Implementação da especificação Bean Validation para validação de dados.
- JWT (JSON Web Token): Mecanismo de autenticação baseado em tokens.

## Estrutura do Projeto
O projeto está organizado nas seguintes camadas:

- Controllers: Responsáveis por receber requisições HTTP, processá-las e retornar as respostas adequadas.
- Services: Contêm a lógica de negócio da aplicação.
- Repositories: Responsáveis pela comunicação com o banco de dados.
- Projeções: Interfaces para projeções personalizadas de entidades.
- Entidades: Representam as entidades do domínio da aplicação.
- DTOs (Data Transfer Objects): Objetos utilizados para transferir dados entre as camadas da aplicação.
- Exceptions: Classes de exceção personalizadas para tratamento de erros específicos.


