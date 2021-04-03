<img src="https://www.everis.com/sites/all/themes/everis/logo.png" width="132" height="65">

## Caixa Eletrônico ##

#### Problema:

Desenvolver uma aplicação que simule a entrega de notas quando um cliente efetuar um saque em um caixa eletrônico. Os requisitos básicos são os seguintes:

- Entregar o menor número de notas;
- É possível sacar o valor solicitado com as notas disponíveis;
- Saldo do cliente será cadastrado;
- Quantidade de notas infinita. Notas disponíveis de R$ 100,00; R$ 50,00; R$ 20,00 e R$ 10,00.
- O Cliente não poderá entrar no negativo.
- Criar no mínimo 3 endpoints: para efetuar saque, cadastrar cliente e outro pra retornar saldo.
- Arquitetura fica a seu critério.

Exemplos:

Valor do Saque: R$ 30,00 – Resultado Esperado: Entregar 1 nota de R$20,00 e 1 nota de R$ 10,00.

Valor do Saque: R$ 80,00 – Resultado Esperado: Entregar 1 nota de R$50,00 1 nota de R$ 20,00 e 1 nota de R$ 10,00

Observações:

Cadastro , Edição e Exclusão de Clientes ( saldo de cada cliente será cadastrado junto ).

## Tecnologias:

- Java 8 ou superior  - :heavy_check_mark:
- Maven para criação do projeto  - :heavy_check_mark:
- Spring-boot  - :heavy_check_mark:
- Spring-data-jpa  - :heavy_check_mark:
- Lombok  - :heavy_check_mark:
- Banco de dados MySQL  - :heavy_check_mark:
- JUnit 5 com Mockito para testes unitários  - :heavy_check_mark:

### Rodando Aplicação Back-end
```bash
# Vá para a pasta da aplicação Back-End
$ cd caixaeletronico

# Instale as dependências
$ mvn install
# Ou use -u -x se preferir, para alinhar as libs
$ mvn install -u -X 

# Rode as migrations do banco de dados
$ mvn start
# Ou use o run da propria IDE

# Execute a aplicação em modo de desenvolvimento
$ mvn start
# Ou use NPM se preferir
$ mvn run start

# Chamada no Postman, localhost:8080
```

### Rodando Aplicação Front-end

> Em Desenvolvimento

````
Observação ao Executar a aplicação:

Para executar o projeto é necessário ter o banco de dados MySql instalado no host. Caso você tenha o docker
instalado em sua máquina, informar configuração.
````
Após clonar o projeto:

* _ce-crud_: Dentro da pasta do projeto executar o comando: `mvn spring-boot:run -Dspring.profiles.active='elephant'` para usar o banco do ElephantSQL ou `mvn spring-boot:run -Dspring.profiles.active='local'` para rodar com a base local;

* _ce-core_: Dentro da pasta do projeto executar o comando: `mvn spring-boot:run`;

* _ce-ui: Dentro da pasta do projeto executar os comando: `npm install`, `bower install` na primeira vez que for executar o projeto. E, por fim, executar `gulp` para iniciar o server. *O projeto rodará na porta 9000*;

##### Aplicação em execução:
<img src="https://github.com/MateusMaceedo/caixa-eletronico/blob/main/caixaeletronico/img/spring.PNG"/>


## 👨🏻‍🚀 Sobre mim
<a href="https://www.linkedin.com/in/mateus-macedo-937a32163/">
 <img style="border-radius:50%" width="100px; "src="https://avatars.githubusercontent.com/u/63172367?s=460&u=11fd26ea8a7f5663d7707d7ef254e4f8bfca1b05&v=4"/>
 <p>Mateus Macedo</p>
</a>
