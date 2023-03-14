<%-- 
    Document   : ListagemDisciplina
    Created on : 14 de mar. de 2023, 12:30:51
    Author     : Matheus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <%
        String listaHTML = request.getParameter("lista");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/tabela.css">

        <title>Disciplinas Cadastradas</title>
    </head>
    <body>



      
            <!--Criando um cabeçalho------------------------------------------------------------------------>
            <header class="cabecalho">
                <div class="detalhes">
                    <img src="imagem/graduation.png" alt="graduation" class="enfeite"/>
                    <h1>Disciplinas cadastradas</h1>
                    <img src="imagem/report.png" alt="report" class="enfeite"/>

                </div>
            </header>
         
                <main class="assunto">
                <nav class="menu">
                    <ul>
                        <li><a href="FormularioRegistroDisciplina.jsp?acao=inclusao">Formulário de Cadastro</a></li>  
                        <li><a href="index.html">Tela Principal</a></li>
                        <div class="search">
                            <form action="DisciplineSrv?acao=filtrar" method="POST" >
                                <input  class="search_input" placeholder="Digite o nome da Disciplina" type="text" name="filtro" value="" />
                                <button id="btnBuscar" type="submit" value="filtrar" class="search1">Buscar</button>
                            </form>
                        </div>

                    </ul>
                </nav>
            </main>
            
 

            <section class="principal">
                <table class="tabela-alunos-cadastrados">
                    <caption> Alunos Cadastrados </caption>
                    <tr>
                        <th>Nome da Disciplina</th>
                        <th>Periodo</th>
                        <th>Carga Horária</th>
                        <th>Descrição</th>
                    </tr>

                    <tbody> 
                        <!-- Retornarmos aqui o lista html que é amesma coisa que faziamos como fabiano. Top demais -->
                        <%=listaHTML%>
                    </tbody>
                </table>

            </section>

    </body>
</html>
