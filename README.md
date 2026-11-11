# Projeto Integrador (Java)

Sistema de cadastro de clientes, categorias e produtos, feito na faculdade (Unisenai, Análise e Desenvolvimento de Sistemas).

## O que faz
- CRUD completo (criar, listar, buscar, atualizar e apagar) de **clientes**, **categorias** e **produtos**
- Regras de negócio na camada de serviço, como nome obrigatório e preço maior que zero
- Tabelas criadas automaticamente por migrações Flyway

## Tecnologias
Java 17, Maven, JDBC, SQLite e Flyway

## Estrutura
```
src/main/java/br/com/senaisp/bauru/
├── model/     classes de dados (Cliente, Categoria, Produto)
├── dao/       acesso ao banco (JDBC)
├── service/   regras de negócio
└── factory/   conexão com o banco e execução das migrações
src/main/resources/db/migration/   scripts Flyway que criam as tabelas
src/test/java/projetointegrador/   classes de teste manual
```

## Como rodar
1. Clone o repositório e abra a pasta em uma IDE com suporte a Maven (Eclipse, IntelliJ ou VS Code). É preciso ter o JDK 17.
2. Baixe as dependências: `mvn install`
3. Execute `TesteMigration` para criar o banco (`database/pi.db`) e as tabelas.
4. Execute `TesteCliente`, `TesteCategoria` ou `TesteProdutoService` para ver cada parte funcionando.

Os testes são classes com `main()`, ou seja, testes manuais. Uma evolução possível é migrar para JUnit.
