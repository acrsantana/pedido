MIT - Engenharia de Software com Java
-
___
<h3>Projeto final da disciplina de Persistencia de Dados</h3>
<p>Este projeto tem como objetivo demonstrar proficiencia na utiliza��o de JDBC, atendendo as seguintes rubricas de forma obrigat�ria:</p>


1. O aluno utilizou corretamente a arquitetura JDBC?
2. O aluno configurou corretamente os drivers de banco na aplica��o?
3. O aluno criou corretamente os statements utilizados nas funcionalidades da aplica��o?
4. O aluno preparou a camada de banco com as principais opera��es?

<p>Os testes das funcionalidades implementadas ser�o testadas atrav�s de classes de testes unit�rios utilizando o JUnit, e o banco de dados utilizado ser� 
o Postgres. A classe de testes utilizada para valida��o � a <u><b>UsuarioDAOTest</b></u>.</p>
<p>Para realizar a cria��o das tabelas e carga inicial dos dados, executar o seguinte comando: mvn flyway:migrate</p>

<p>O tema escolhido para este trabalho � o mesmo adotado como entrega final da p�s gradua��o: uma api para realiza��o de estimativas baseadas no 
Planning Poker. O diagrama de classes (em elabora��o) � o abaixo:</p>
<img src="src/main/resources/static/Screenshot_1.png" alt="" height="650">
<p>Para o objetivo deste trabalho, ser� criada a classe Usuario. Para organizar uma partida, o usu�rio precisa ser registrado no servi�o por�m os 
jogadores convidados da partida n�o precisam necessariamente serem registrados.</p>
