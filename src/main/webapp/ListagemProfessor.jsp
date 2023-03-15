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
        <link rel="stylesheet" a href="css/tabela2.css">

        <title>Professores Cadastrados</title>
    </head>
    <body>
        <main>
            <!--Criando um cabeçalho------------------------------------------------------------------------>
            <header class="cabecalho">
                <div class="detalhes">
                    <img src="imagem/language.png" alt="language" class="enfeite"/>

                    <h1>Cadastros</h1>
                    <img src="imagem/online-learning.png" alt="online-learning"  class="enfeite"/>

                </div>
            </header>
            <main class="assunto">
                <nav class="menu">
                    <ul>
                        <li><a href="FormularioRegistroProfessor.jsp?acao=inclusao">Formulário de Cadastro</a></li>  
                        <li><a href="index.html">Tela Principal</a></li>
                        <div class="search">
                            <form action="ProfessorSrv?acao=filtrar" method="POST" >
                                <input  class="search_input" placeholder="Digite o nome do Professor(a)" type="text" name="filtro" value="" />
                                <button id="btnBuscar" type="submit" value="filtrar" class="search1">Buscar</button>
                            </form>
                        </div>

                    </ul>
                </nav>
            </main>

            <section class="principal">
                <table class="tabela-alunos-cadastrados">
                    <caption> Professores Cadastrados </caption>
                    <tr>
                        <th>Nome do Professor</th>
                        <th>Data de Nascimento</th>
                        <th>Naturalidade</th>
                        <th>Endereço</th>
                        <th>Telefone</th>
                        <th>Estado Civil</th>
                        <th>Disciplina</th>

                    </tr>

                    <tbody> 
                        <!-- Retornarmos aqui o lista html que é amesma coisa que faziamos como fabiano. Top demais -->
                        <%=listaHTML%>
                    </tbody>
                </table>

            </section>



            <main>
                </body>
                </html>
