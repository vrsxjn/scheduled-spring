# README

Este é um projeto com uma aplicação web que consiste em um backend Spring Boot e um frontend Angular. Antes de iniciar, siga as etapas abaixo para configurar e executar a aplicação.

## Pré-requisitos

Certifique-se de ter o seguinte software instalado:

- Java Development Kit (JDK)
- Node.js e Angular CLI
- Banco de Dados sqlserve 
- Git

## Configuração do Banco de Dados

Antes de iniciar o aplicativo, é necessário criar as tabelas no banco de dados. Certifique-se de que o banco de dados esteja configurado corretamente e as tabelas sejam criadas. Você pode fazer isso manualmente ou executar os scripts SQL apropriados.

Não esqueca de configura o application.properties com seu sqlserve
```
CREATE DATABASE TEROS;

CREATE TABLE open_banking_participant (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    logo_url VARCHAR(255),
    authorization_server_url VARCHAR(255)
);

```

## Backend

1. Navegue até a pasta `back` no seu terminal.

2. Execute o seguinte comando para instalar as dependências do Maven e compilar o projeto:

   ```
   mvn clean install
   ```

   Certifique-se de que todas as dependências estejam instaladas corretamente.

3. Inicie o servidor Spring Boot com o seguinte comando:

   ```
   java -jar target/nome-do-arquivo-jar.jar
   ```

   Substitua `nome-do-arquivo-jar` pelo nome do arquivo gerado após a compilação.

4. O backend estará rodando em `http://localhost:8080/api/participants`.

## Frontend

1. Navegue até a pasta `front-angular` no seu terminal.

2. Execute o seguinte comando para instalar as dependências do Angular:

   ```
   npm install
   ```

3. Inicie o servidor de desenvolvimento do Angular com o seguinte comando:

   ```
   ng serve
   ```

   O frontend estará acessível em `http://localhost:4200`.
