## Prova Dev Back-end JAVA
 
### Descrição

FakeReddit é um app para gerenciar postagens com a funcionalidade de Upvotes.

### Como instalar

A prova foi desenvolvida usando Spring Boot 2.5.1 e Java 16 para uma API Rest.
O front-end foi desenvolvido com Angular 10 e o banco de dados é PostgreSQL.
Também há um docker-compose com um container com o banco de dados (porta 5432) e outro com o Adminer para acesso (porta 8080).

Foram utilizados do Spring Boot os módulos Starter JPA, DevTools, Starter Web, Starter Test, Starter Cache.
Além do banco em memória H2 para testes, JUnit 5, Hibernate Validator e as bibliotecas MapStruct, Lombok e SpringFox.

Para executar o sistema e banco de dados, siga um dos passos abaixo:
 - Execute o comando "docker-compose up -d" no diretório do "fakereddit" para subir um container do Postgre e o Adminer;
 - Execute o comando "mvn clean install spring-boot:run" no diretório "fakereddit-server" para baixar dependências, rodar os testes e startar o back-end;
 - Execute o comando "npm install" para instalar e "npm start" no diretório "fakereddit-client" configurar o proxy e startar o front-end.
 - Acesse http://localhost:4200/
 - Caso deseje rodar os testes e2e use o comando "npm run e2e"
  
 Observação: a porta da API foi alterada para 8000 (ver "server.port" no application.properties).
 
### Endpoints de dados da API

Acesso a API com Swagger: http://localhost:8000/swagger-ui/

### Arquitetura

O projeto a seguinte estrutura:

 - Packs:
   - configuration: configurações do Swagger e do Handler de validação de requisição.
   - controller: RestController de Post da API.
   - model: a classe de domínio da API, sendo que são utilizados as anotações do Lombok para gerar Getters, Setters, Contrucutors 
    e para a tabela do banco com Javax Persistence.
   - repository: o repositório de Post da API.
   - service: todas as classes Services da API. Contém os pacotes:
     - dto: para o PostDTO.
     - impl: implementação dos métodos definidos na interface Service.
     - mapper: para a classe de mapeamento de conversão de DTO para Entity e Entity para DTO. Aqui é utilizado o EntityMapper para obter uma estrutura padrão
       das interfaces mapper. É utilizado a biblioteca MapStruct para o mapeamento.
   - util: pacotes com as classes e interfaces de suporte a API.

### Possíveis Implementações Futuras

- Containers para rodar Java e Angular.
- Implementar a paginação no front-end e back-end.
- Implementar usuário, login e autenticação stateless com Json Web Token.
- Inserção de imagens e outras mídias nos Posts.
- Layout da aplicação (sempre tem o que melhorar... hehe)
