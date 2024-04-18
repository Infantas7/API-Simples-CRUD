# CRUD API

Este projeto tem como objetivo a criação de uma API RESTful seguindo os princípios de Roy Fielding, com o propósito de automatizar um CRUD para um banco de dados simples, mantendo as relações entre usuários e suas tarefas.

## Pré-requisitos / Ferramentas Utilizadas

- Banco de dados simples desenvolvido em SQL.
- IDE recomendada: IntelliJ IDEA.
- Java SDK 17 ou superior.
- Maven como gerenciador de dependências.
- Postman para testar os endpoints.
- HeidiSQL utilizado como nosso SGDB.
- GitBash como nossa ferramenta de versionamento.

## Métodos Implementados

Tratando-se de um CRUD, naturalmente teremos os métodos Create/Read/Update/Delete, portanto, irei listar apenas seus endpoints tanto para a classe User quanto para Task.
   
## Endpoints da Classe User

### Recuperar usuário por ID
**Método:** GET  
**Endpoint:** `/user/{id}`  
**Descrição:** Recupera um usuário pelo seu ID.

### Criar novo usuário
**Método:** POST  
**Endpoint:** `/user`  
**Descrição:** Cria um novo usuário no sistema.

### Atualizar usuário
**Método:** PUT  
**Endpoint:** `/user/{id}`  
**Descrição:** Atualiza as informações de um usuário existente.

## Endpoints da Classe Task

### Recuperar tarefa por ID
**Método:** GET  
**Endpoint:** `/task/{id}`  
**Descrição:** Recupera uma tarefa pelo seu ID.

### Recuperar todas as tarefas de um usuário
**Método:** GET  
**Endpoint:** `/task/user/{userid}`  
**Descrição:** Recupera todas as tarefas associadas a um determinado usuário.

### Criar nova tarefa
**Método:** POST  
**Endpoint:** `/task`  
**Descrição:** Cria uma nova tarefa no sistema.

### Atualizar tarefa
**Método:** PUT  
**Endpoint:** `/task/{id}`  
**Descrição:** Atualiza as informações de uma tarefa existente.

### Deletar tarefa
**Método:** DELETE  
**Endpoint:** `/task/{id}`  
**Descrição:** Remove uma tarefa do sistema.

## Relação do Banco de Dados 

Esta seção fornece uma visão geral da modelagem do banco de dados simples utilizada neste projeto, criada com a ferramenta de engenharia reversa do MySQL Workbench.

### Estrutura do Banco de Dados

O banco de dados foi projetado para armazenar informações sobre usuários e suas respectivas tarefas. Ele consiste em duas tabelas principais: `users` e `tasks`, que estão relacionadas entre si.

A tabela `users` armazena os detalhes dos usuários, como nome, e-mail e outras informações relevantes. Cada usuário tem um identificador único, que é usado para identificar o usuário de forma exclusiva na tabela.

A tabela `tasks` armazena as tarefas associadas a cada usuário. Cada tarefa está relacionada a um usuário específico por meio de uma chave estrangeira que referencia o identificador do usuário na tabela `users`.

### Modelo de Banco de Dados

Abaixo está uma representação visual do modelo de banco de dados:
 
![image](https://github.com/Infantas7/Crude.api/assets/155490248/d68db388-54b1-4d8b-9293-e0de4b1a1d52)


### Autores
• Gabriel Alvares Infantas  https://github.com/Infantas7

### Contato

LinkedIn : www.linkedin.com/in/gabriel-infantass





