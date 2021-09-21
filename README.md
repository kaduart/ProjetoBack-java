# ProjetoBack-java

###ESTRTUTURA

O projeto consiste em uma aplicação Java baseada no framework SpringBoot, que tem como autenticação a utilização do Auth0 e JWT token. Onde somente usuário  com credenciais tem permissão para logar na aplicação, editar os dados.


A estrutura do projeto foi pensada na divisão dos pacotes das seguinte forma:

...src/main/java/
|-- br.com.teste
      |-- controller - Onde são feitas os controles dos dados, através dos protocolos HTTP GET< PUT< POST e DELETE(os mais utilizados), intermediando o acesso das Apis Rest, consumidas pelo Front-end, e indo até os services.
      |-- entity - Entidades, model dos objetos que faz a persistência na aplicação.
      |-- mapper - Obtem classes que faz a conversão de entidades(Models) em entitidades DTOs, e vice e versa.
      |-- repository - Classes que buscam no banco de dados informações de acordo com a tag usada como login, id, name etc...
      |-- security - Onde são feitas todas as configurações e validações de segurança do usuário como login, tokens e roles
      |-- service - Onde é implementado as classes que fazem o intermédio entre as classes de controlles e a repository.
      |-- service.dto - Tem o papel de fazer a persistência dos dados no banco de dados.
    
    Logo, cada pasta com suas devidas anotações e configurações específicas trazendo mais transparência da estrutura para outros mantenedores dos serviços.
