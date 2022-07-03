## Processo para rodar a aplicação local

- Faça um clone do projeto para a sua máquina.
- Na pasta raiz do projeto, rode o comando "mvn clean install" para gerar as classes do Swagger e do WebService SOAP.
- Caso a IDE não reconheça os imports das classes do Swagger e do WebService SOAP após rodar o comando "mvn clean install", deve-se rodar o reload das dependencias do maven no caso do IntelliJ ou "update project" do maven no Eclipse.
- Faça o start da aplicação.
- Acesse a URL http://localhost:8080/swagger-ui.html para testar.
