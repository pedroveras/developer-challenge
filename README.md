# developer-challenge
## Stack:

 - Java 8
 - Spring Boot
 - Spring Data
 - JAXB
 - Lombok
 - H2
 - Maven
 - JUnit
 - Mockito

## Endpoints da aplicação:

 - /api/arquivos (POST)
 Recebe um arquivo XML no corpo da requisição e realiza o salvamento no banco de dados

 - /api/arquivos/{nuOp} (GET)
Recebe o parâmetro nuOp (número da operação) e retorna um arquivo salvo no banco de dados. Os dados são carregados do BD e a partir do objeto Doc retornado, é feito um Marshal para XML com o JAXB.

## Estrutura de tabelas do banco de dados:
| Tabela |Campos  |
|--|--|
| DOC |<p>ID<br>ATUALIZADO_EM<br>CRIADO_EM<br>BCMSG_ID<br>SISMSG_ID<br><p>|
|BCMSG|<p>ID<br>ATUALIZADO_EM<br>CRIADO_EM<br>DOM_SIST<br>IDENTD_EMISSOR<br>NU_OP<br>GRUPO_SEQ_ID</p>|
|GRUPO_SEQ|<p>ID<br>ATUALIZADO_EM<br>CRIADO_EM<br>INDR_CONT<br>NUM_SEQ</p>|
|GRUPO_SLC0001_LIQUID|<p>ID<br>ATUALIZADO_EM<br>CRIADO_EM<br>DT_LIQUID<br>NUM_SEQ_CICLO_LIQUID</p>|
|GRUPO_SLC0001_LIQUID_GRUPOSLC0001PRODT |<p>GRUPO_SLC0001_LIQUID_ID<br>GRUPOSLC0001PRODT_ID<br></p>|
|GRUPO_SLC0001_LIQUID_PRODT|<p>ID<br>ATUALIZADO_EM<br>CRIADO_EM<br>CNPJN_LIQDANT_CREDTD<br>CNPJN_LIQDANT_DEBTD<br>IDENTD_LINHA_BILAT<br>ISPBIF_CREDTD<br>ISPBIF_DEBTD<br>NOM_CLI_CREDTD<br>NOM_CLI_DEBTD<br>TP_DEB_CRED<br>TP_TRANSCSLC<br>VLR_LANC</p>|
|GRUPO_SLC0001_PRODUT |<p>ID<br>ATUALIZADO_EM<br>CRIADO_EM<br>COD_PRODT</p>|
|GRUPO_SLC0001_PRODUT_GRUPOSLC0001LIQUID_PRODT |<p>GRUPO_SLC0001_PRODUT_ID<br>GRUPOSLC0001LIQUID_PRODT_ID<br></p>|
|SISMSG|<p>ID<br>ATUALIZADO_EM<br>CRIADO_EM<br>SLC0001_ID</p>|
|SLC0001|<p>ID<br>ATUALIZADO_EM<br>CRIADO_EM<br>COD_MSG<br>DT_HRSLC<br>DT_MOVTO<br>ISPBIF<br>NUM_CTRLSLC<br>TP_INF<br>GRUPOSLC001LIQUID_ID</p>|

## Executando a aplicação:
1. Certifique-se de ter instalado na máquina o Java 8 e o Maven
2. Usando uma ferramenta de linha de comando acesse o diretório raiz  da aplicação
3. Execute o comando `mvn spring-boot:run` isso irá executar o servidor Tomcat interno e subirá o banco de dados H2

Para verificar se tudo subiu direitinho, acesse o console do banco de dados H2 acessando:
[http://localhost:8080/h2-console](http://localhost:8080/h2-console)
Utilize o user name "sa" e não necessita de senha

Para testar a API é recomendável o uso do software Postman ou outro de sua preferência.

### Testando a requisição POST:

 1. No Postman selecione o tipo de requisição como POST
 2. Coloque a url localhost:8080/api/arquivos
 3. Na aba Body selecione raw e "XML (application/xml)"
 4. No campo de texto cole o conteúdo do arquivo XML
 5. Pressione Send
 6. Verifique a inserção dos dados por meio da H2 Console ou siga os passos da próxima seção

### Testando a requisição GET:

 1. No Postman selecione o tipo de requisição como GET
 2. Coloque a url localhost:8080/api/arquivos/{nuOp} onde nuOp é o número da operação. Do arquivo de exemplo, este número é 12345678912345678912345
 3. Pressione o botão Send
 4. Na área de Response irá retornar o conteúdo inserido no banco de dados
