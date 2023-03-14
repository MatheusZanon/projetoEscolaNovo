<%-- 
    Document   : registroProfessor
    Created on : 11 de mar. de 2023, 21:48:40
    Author     : Matheus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<% 
    String acao = request.getParameter("acao");
   
    String id = request.getParameter("id");
    String nomeProfessor = request.getParameter("nomeProfessor");
    String dt_nascimento = request.getParameter("dt_nascimento");
    String naturalidade = request.getParameter("naturalidade");
    String endereco = request.getParameter("endereco");
    String telefone = request.getParameter("telefone");
    String estadoCivil = request.getParameter("estadoCivil");

    if (id == null) {
            nomeProfessor = "";
            dt_nascimento = "";
            naturalidade = "";
            endereco = "";
            telefone = "";
            estadoCivil = "";
        }
%>

<html lang="pt-br">

    <head>
        <title>Adicionar Professor</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        
    </head>

    <body>
         <main>
            <!--Criando um cabeçalho------------------------------------------------------------------------>
            <header class="cabecalho">
                <div class="detalhes">
                    <img src="imagem/teacher.png" alt="teacher" class="enfeite"/>
                    <h1>Cadastro de professor</h1>
                    <img src="imagem/language.png" alt="language" class="enfeite"/> 

                </div>
            </header>
            <!-- Fim do cabeçalho -->

        <div class="mainWindowProfessor">
            <div class="container">
                <div class="card">
                    <div class="card-body">    
                        <form action="ProfessorSrv" method="POST">
                            <input type="hidden" name="acao" value="<%=acao %>"/>
                            <input type="hidden" name="id" value="<%=id %>" />
                            <p><b>Registre um professor:</b></p>
                           
                            <label>Nome do Professor:</label>
                            <input type="text" name="nomeProfessor" class="form-control col-md-3" value="<%=nomeProfessor%>" >

                            <label>Data de Nascimento:</label>
                            <input type="text" name="dt_nascimento" class="form-control col-md-3" value="<%=dt_nascimento%>">

                            <label>Naturalidade:</label>
                            <input type="text" name="naturalidade" class="form-control col-md-3" value="<%=naturalidade%>">

                            <label>Endereço:</label>
                            <input type="text" name="endereco" class="form-control col-md-3" value="<%=endereco%>">

                            <label>Telefone de Contato: </label>
                            <input type="text" name="telefone" class="form-control col-md-3" value="<%=telefone%>">

                            <label>Estado Civil:</label>
                            <input type="text" name="estadoCivil" class="form-control col-md-3" value="<%=estadoCivil%>">
                 

                            <br>
                            <div class="row">
                                <div class="col-md-2">
                                    <input type="submit" class="btn btn-warning" value="Adicionar">
                                </div>
                                <div class="col-md-2">
                                    <input type="reset" value="Cancelar"  class="btn btn-danger" />  
                                </div>
                                <a href="index.html" type="button" class="btn btn-success">Voltar</a>
                                
                            </div> 
                        </form>
                    </div>
                </div>
            </div>
        </div>
                           



    </body>

</html>


