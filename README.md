# GamerVault

Sistema desktop desenvolvido em Java Swing para gerenciamento de jogos.

## Tecnologias utilizadas

- Java
- NetBeans
- MySQL
- JDBC
- Java Swing

## Arquitetura

O projeto foi refatorado aplicando princípios SOLID, principalmente o princípio da responsabilidade única (SRP).

Estrutura:

- model: entidades do sistema
- dao: acesso ao banco de dados
- database: conexão com banco
- view: telas da aplicação

## Padrão utilizado

DAO (Data Access Object)

O padrão foi utilizado para separar a lógica de persistência dos dados da interface gráfica.
