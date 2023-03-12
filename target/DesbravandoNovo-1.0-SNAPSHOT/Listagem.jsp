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
        <main>
            <!--Criando um cabeçalho------------------------------------------------------------------------>
            <header class="cabecalho">
                <div class="detalhes">
                    <img src="imagem/go-to-school.png" alt="go-to-school" class="enfeite"/>
                    <h1>Registros</h1>
                    <img src="imagem/scary.png" alt="scary" class="enfeite"/>

                </div>
            </header>
               <main class="assunto">
            <nav class="menu">
                <ul>
                      <li><a href="FormularioRegistro.jsp">Formulário de Registro</a></li>  
                    <li><a href="index.html">Tela Principal</a></li>
                       
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

            <main>
                </body>
                </html>
