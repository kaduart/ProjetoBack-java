# ProjetoBack-java

###ESTRTUTURA

O projeto consiste em uma aplicação Java baseada no framework SpringBoot, que tem como autenticação a utilização do Auth0 e JWT token. Onde somente usuário  com credenciais tem permissão para logar na aplicação, editar os dados.


A estrutura do projeto foi pensada na divisão dos pacotes das seguinte forma:



...src/main/java/
|-- br.com.teste
      |-- CONTROLLER -Controle dos dados, através dos protocolos HTTP GET< PUT< POST e DELETE(os mais utilizados), intermediando o acesso das Apis Rest, consumidas pelo Front-end, e os services.
      
      |-- ENTITY - Entidades, model dos objetos que faz a persistência na aplicação.
      
      |-- MAPPER - Obtem classes que faz a conversão de entidades(Models) em entitidades DTOs, e vice e versa.
      
      |-- REPOSITORY - Classes que buscam no banco de dados informações de acordo com a tag usada como login, id, name etc...
      
      |-- SECURITY - Onde são feitas todas as configurações e validações de segurança do usuário como login, tokens e roles
      
      |-- SERVICE - Onde é implementado as classes que fazem o intermédio entre as classes de controlles e a repository.
      
      |-- SERVICE.DTO - Tem o papel de fazer a persistência dos dados no banco de dados.
      
    
    Logo, cada pasta com suas devidas anotações e configurações específicas trazendo mais transparência da estrutura para outros mantenedores dos serviços.
