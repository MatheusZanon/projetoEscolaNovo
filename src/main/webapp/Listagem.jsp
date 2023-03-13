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
                    <img src="imagem/go-to-school.png" width="200" height="200" alt="go-to-school" class="enfeites"/>

                    <h1>Registros</h1>
                    <img src="imagem/5836-removebg-preview.png" width="300" height="250"  alt="5836-removebg-preview"/>

                </div>
            </header>
            <main class="assunto">
                <nav class="menu">
                    <ul>
                        <li><a href="FormularioRegistro.jsp?acao=inclusao">Formulário de Registro</a></li>  
                        <li><a href="index.html">Tela Principal</a></li>

                    </ul>
                </nav>
            </main>

            <section class="principal">
                <div class="search">
                    <form action="CorpoCelesteSrv?acao=filtrar" method="POST">
                        <input placeholder="Buscar" type="text" name="filtro" value="" />
                        <button id="btnBuscar" type="submit" value="filtrar">Buscar</button>
                    </form>
                </div>
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
