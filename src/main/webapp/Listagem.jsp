<%-- 
    Document   : Listagem
    Created on : 12 de mar. de 2023, 16:59:09
    Author     : joaop
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

        <title>Alunos Registrados</title>
    </head>
    <body>



      
            <!--Criando um cabeçalho------------------------------------------------------------------------>
            <header class="cabecalho">
                <div class="detalhes">
                    <img src="imagem/graduation.png" alt="graduation" class="enfeite"/>
                    <h1>Alunos cadastrados</h1>
                    <img src="imagem/report.png" alt="report" class="enfeite"/>

                </div>
            </header>
         
                <main class="assunto">
                <nav class="menu">
                    <ul>
                        <li><a href="FormularioRegistro.jsp?acao=inclusao">Formulário de Cadastro</a></li>  
                        <li><a href="index.html">Tela Principal</a></li>
                        <div class="search">
                            <form action="CorpoCelesteSrv?acao=filtrar" method="POST" >
                                <input  class="search_input" placeholder="Digite o nome do Aluno" type="text" name="filtro" value="" />
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
                        <th>Nome do Aluno</th>
                        <th>Data de Nascimento</th>
                        <th>Naturalidade</th>
                        <th>Endereço</th>
                        <th>Telefone</th>
                        <th>Nome da mãe</th>
                        <th>Nome do pai </th>

                    </tr>

                    <tbody> 
                        <!-- Retornarmos aqui o lista html que é amesma coisa que faziamos como fabiano. Top demais -->
                        <%=listaHTML%>
                    </tbody>
                </table>

            </section>

    </body>
</html>
