# To-Do List Application

Aplicação simples desenvolvida com Spring Boot para gerenciar uma lista de tarefas. Essa aplicação utiliza arquitetura MVC com Thymeleaf para renderizar páginas HTML, Spring Data JPA para persistência de dados com o banco H2, além de outras tecnologias que facilitam o desenvolvimento, como Lombok.

## Tecnologias Utilizadas

- **Spring Boot:** Framework para desenvolvimento rápido de aplicações Java.
- **Spring MVC:** Gerencia as requisições HTTP e o fluxo da aplicação.
- **Thymeleaf:** Motor de templates para renderização de páginas HTML dinâmicas.
- **Spring Data JPA:** Simplifica o acesso e a manipulação do banco de dados.
- **H2 Database:** Banco de dados leve, ideal para desenvolvimento e testes.
- **Lombok:** Reduz o código boilerplate.
- **Maven:** Gerenciador de dependências e build da aplicação.

## Funcionalidades

- **Listagem de Tarefas:** Visualiza todas as tarefas cadastradas.
- **Criação de Tarefa:** Adiciona novas tarefas à lista.
- **Conclusão de Tarefa:** Altera o status da tarefa de pendente (to-do) para concluida.
- **Tornar Tarefa Pendente:** Altera o status da tarefa de concluida para pendente (to-do).
- **Atualização de Tarefa:** Permite editar o conteúdo das tarefas.
- **Exclusão de Tarefa:** Remove tarefas existentes.

## Estrutura do Projeto

- **Controller:** Gerencia as requisições HTTP e mapeia os endpoints da aplicação.
- **Service:** Contém a lógica de negócio e interage com o repositório.
- **Repository:** Interface para acesso ao banco de dados utilizando Spring Data JPA.
- **Model/DTO:** Representa as entidades e os objetos de transferência de dados.
- **Templates:** Arquivos HTML com Thymeleaf para a renderização das páginas.

## Pré-requisitos

- **Java 17+** – Certifique-se de ter o JDK 17 ou superior instalado.
- **Maven** – Gerenciador de dependências.
- **Git** – Para clonar o repositório.

## Configuração do Banco de Dados H2

O projeto já está configurado para utilizar o H2. No arquivo `src/main/resources/application.properties`, você pode encontrar configurações semelhantes a:

```properties
spring.datasource.url=jdbc:h2:mem:meu_banco
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.platform=h2
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

