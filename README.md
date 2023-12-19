Este arquivo tem como objetivo explicar como implementar e testar o CRUD da API RESTFULL de Tarefas.

Tecnologias utilizadas.

Código - Java (versão 21)
Projeto - Maven (versão 3.10.1 do compiler)
API - Spring Boot (versão 3.2.0)
Banco de Dados   - MySql versão 5.2.1(JPA e Hibernate) e H2 (para testes em memória)
____________________________________________________________________________________________________________________________________________________________________________________________

Como instalar e testar a API

NOTA: Caso esqueça de configurar seu banco de dados antes de executar o projeto, está configurado como default o banco H2 em memória para que não sejam exibidos erros nos testes.

1 - Faça o download do projeto via github em sua IDE de preferencia ou acessando o link do repositório via navegador - link para o repositório - https://github.com/rsouzarj/Empresometro
____________________________________________________________________________________________________________________________________________________________________________________________
2 - Importe o projeto e faça o download das dependências
____________________________________________________________________________________________________________________________________________________________________________________________
3 - Configure um servidor de app web como Tomcat, Payara ou Glassfish
____________________________________________________________________________________________________________________________________________________________________________________________
4 - Crie um banco de dados no mysql para o projeto(não precisa criar a tabela Tarefas ela será criada automaticamente com o JPA e Hibernate)
____________________________________________________________________________________________________________________________________________________________________________________________
5 - Edite o application.properties e remova o caracter # para descomentar as linhas 7,8,9,10,11,12,13 e inclua o caractere # para comentar as linhas 1,2,3,4,5 depois 
configure as informações do acesso ao banco que criuou nas linhas 7,8 e 9 com as informações corretas (abaixo estão a linhas que devem ser alteradas)
spring.datasource.url=jdbc:mysql://localhost:3306/NOMEDOMEUBANCODEDADOS
spring.datasource.username=USUÁRIODOBANCODEDADOS
spring.datasource.password=SENHA
____________________________________________________________________________________________________________________________________________________________________________________________
6 - Execute o build do projeto, ao executar o projeto os seguintes testes serão executados:
1 Teste Unitário dos Getters e Setters da Entity Tasks
1 Teste de Integração com o BD 
2 Testes Assíncronos de inclusão e aguardando a exclusão e verificando se teve sucesso 
____________________________________________________________________________________________________________________________________________________________________________________________
7 - Para acessar a API você pode utilizar o próprio navegador com a URL http://localhost:8080/swagger-ui/index.html(ou substitua o localhost pelo seu ip ou endpoint caso use alguma cloud)
ou caso tenha conhecimento pode usar o Postman que é uma ótima ferramenta para trabalhar com APIs e só precisa se autenticar com uma conta google.
____________________________________________________________________________________________________________________________________________________________________________________________
8 - Os seguintes endpoints da API serão listados:
PUT /ID
DELETE / ID
GET
POST
____________________________________________________________________________________________________________________________________________________________________________________________
9 - Como executar os testes usando o formato JSON das informações 
Considerando que está usando o navegador para acessar a API via swagger

POST (inclusão de registro) O id é gerado de forma automática então deve ser retirado do insert

clique em TRY IT OUT e após inserir as informações clique em EXECUTE

{
  "nome": "Organizar a gaveta",
  "tipo": "Tarefa de casa",
  "descricao": "Organizar a gaveta de meias por cor",
  "dataini": "22/12/2023",
  "datafim": "22/12/2023"
}


GET (consulta dos registros)
clique em TRY IT OUT e em EXECUTE a listagem não tem filtros então vai mostrar todos os registros


PUT (Alteração de Registro) Como id já existe e não deve ser alterado, então deve ser retirado do update

clique em TRY IT OUT e após inserir o código do ID da tarefa clique em EXECUTE

{
  "nome": "Organizar a gaveta de Meias",
  "tipo": "Tarefa do Lar",
  "descricao": "Organizar a gaveta de meias por cor",
  "dataini": "22/12/2023",
  "datafim": "23/12/2023"
}


DELETE
clique em TRY IT OUT e após inserir o código do ID da tarefa clique em EXECUTE
e somente aquela tarefa será excluída 

FIM
