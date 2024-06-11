# Projeto de Gestão de Estudantes

Este é um projeto simples de gestão de estudantes desenvolvido em Java. Ele foi criado para demonstrar a implementação de conceitos de Domain-Driven-Design (DDD) e padrões de Design Pattern em uma aplicação web.

## Tecnologias Utilizadas

- Spring Boot
- Spring Data JPA
- H2 Database (para ambiente de desenvolvimento)
- Spring Web
- Swagger (para documentação da API)

## Arquitetura e Design Patterns

### Domain-Driven Design (DDD)

No desenvolvimento desta aplicação, foram aplicados vários princípios de DDD para garantir que a lógica de negócio seja centralizada e de fácil manutenção. As principais implementações incluem:

- **Entidades**: Classes que representam objetos do mundo real com identidade própria, como `Student` e `Course`.
- **Repositórios**: Interfaces que encapsulam as operações de acesso a dados relacionadas a entidades específicas. O repositório é responsável por abstrair a lógica de persistência e recuperação dos dados. Exemplos incluem `StudentRepository` e `CourseRepository`.
- **Serviços de Domínio**: Serviços que contêm lógica de negócios que não se encaixa naturalmente em entidades ou objetos de valor. Eles são responsáveis por orquestrar operações que envolvem múltiplas entidades. Exemplos incluem `StudentService` e `CourseService`.

### Design Patterns

A aplicação também utiliza vários padrões de design para melhorar a modularidade e a reutilização do código:

- **Repository Pattern**: Utilizado para separar a lógica de negócios da lógica de acesso a dados, permitindo que ambos evoluam de forma independente. Exemplos incluem `StudentRepository` e `CourseRepository`.
- **DTO (Data Transfer Object) Pattern**: Utilizado para transferir dados entre a camada de apresentação e a camada de serviço. DTOs ajudam a isolar a camada de apresentação da lógica de negócios e dos detalhes de persistência.
- **Service Layer Pattern**: Define uma camada de serviços que fornece uma interface para a lógica de negócios. A camada de serviço facilita a separação de preocupações e a manutenção da aplicação. Exemplos incluem `StudentService` e `CourseService`.
- **Exception Handling**: A aplicação captura e lida com exceções de forma centralizada, garantindo que os erros sejam gerenciados de maneira consistente. Isso é feito utilizando blocos `try-catch` nas camadas de serviço e controladores.

## Funcionalidades

- **Cadastro de Estudantes**: Permite criar, listar, atualizar e excluir informações de estudantes.
- **Consulta de Estudantes**: Permite consultar detalhes de um estudante específico com base no seu ID.
- **Cadastro de Cursos**: Permite criar, listar e excluir cursos.
- **Consulta de Cursos**: Permite consultar detalhes de um curso específico com base no seu nome.
- **Documentação da API**: Utilização do Swagger para fornecer uma interface interativa de documentação da API.

## Relacionamento entre Tabelas

O projeto utiliza o Spring Data JPA para mapear entidades de domínio para tabelas de banco de dados. O relacionamento entre as tabelas de entidades é definido através de anotações JPA, como `@OneToOne`, `@OneToMany`, `@ManyToOne` e `@ManyToMany`.

Por exemplo, a entidade `Student` pode estar relacionada com a entidade `Course` através de um relacionamento de muitos para muitos (`@ManyToMany`). Isso permite que um estudante esteja matriculado em vários cursos e que um curso tenha vários estudantes matriculados.

## Documentação da API com Swagger

O projeto utiliza o Swagger para gerar automaticamente a documentação da API. Após iniciar a aplicação, você pode acessar a interface interativa do Swagger através da seguinte URL:

http://localhost:8080/swagger-ui.html


## Como Executar

Para executar o projeto localmente, siga estas etapas:

1. Clone o repositório para o seu ambiente local.
2. Certifique-se de ter o Java JDK instalado em sua máquina.
3. Dê RUN na raiz do projeto para iniciar a aplicação.
4. Acesse a aplicação em `http://localhost:8080` em seu navegador web.
