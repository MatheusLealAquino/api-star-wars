# api-star-wars

Objetivo da API: <br>
	API que contenha os dados dos planetas referentes a saga de Star Wars em que cada planeta possui nome, clima, terreno e quantidade de aparições em filmes da saga. Sendo a quantidade de aparições em filmes obtidas da API pública do Star Wars: https://swapi.co/ . <br>
	Como funcionalidades desejadas temos a adição de planetas (com nome, clima e terreno), listar planetas, buscar por nome, buscar por ID, remover planeta. <br>

Ambiente de desenvolvimento: <br>
	SO: Ubuntu 16.04 LTS <br>
	IDE: NetBeans IDE 8.2 (Build 201705191307) <br>
	Extensão: NB SpringBoot ( Version 2.0 ) <br>
	Linguagem: Java 1.8.0_171; Java HotSpot(TM) 64-Bit Server VM 25.171-b11 <br>
	Dependências: Spring Boot v2.0.2.RELEASE, MongoDB 3.2.20, Spring Data MongoDB, Spring Web, Spring Data Rest,
	Json Simple, HttpClient<br>

# Adicionar novo planeta - Method: POST
localhost:8080/api/planetas?nome=xxx&clima=xxx&terreno=xxx  

# Retorno de todos os planetas - Method: GET
localhost:8080/api/planetas  

# Buscar planeta por nome - Method: GET
localhost:8080/api/planetas?nome=xxx 

# Buscar planeta por ID - Method: GET 
localhost:8080/api/planetas/{id} 

# Remoção de planeta por ID - Method: DELETE 
localhost:8080/api/planetas/{id} 



