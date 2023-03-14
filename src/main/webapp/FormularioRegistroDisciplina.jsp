<%-- 
    Document   : FormularioRegistro
    Created on : 6 de mar. de 2023, 12:08:17
    Author     : annak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String acao = request.getParameter("acao");
        String id = request.getParameter("id");
        String nomeDisciplina = request.getParameter("nomeDisciplina");
        String periodo = request.getParameter("periodo");
        String cargaHoraria = request.getParameter("cargaHoraria");
        String descricao = request.getParameter("descricao");

        if (id == null) {
            nomeDisciplina = "";
            periodo = "";
            cargaHoraria = "";
            descricao = "";
        }

    %>

   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Registro de Alunos</title>
    </head>
    <body>
        <main>
            <!--Criando um cabeçalho------------------------------------------------------------------------>
            <header class="cabecalho">
                <div class="detalhes">
                    <img src="imagem/go-to-school.png" alt="language" class="enfeite"/>

                    <h1>Cadastro de Disciplinas</h1>
                    <img src="imagem/scary (1).png" alt="scary (1)" class="enfeite"/>

                </div>
            </header>
            <div class="mainWindowDisciplina">
                <div class="container">
                    <div class="card">
                        <div class="card-body">    
                            <form action="DisciplineSrv" method="POST">
                                <input type="hidden" name="acao" value="<%=acao%>" />
                                <input type="hidden" name="id" value="<%=id %>" />
                                <p><b>Registre uma Disciplina</b></p>
                                <label class="lbl1">Nome da disciplina:  </label><br>
                                <input type="text" name="nomeDisciplina" placeholder="Matemática" required="required" value="<%=nomeDisciplina%>" class="form-control col-md-6"><br>
                                <label class="lbl2">Período:  </label><br>
                                <input type="text" name="periodo" placeholder="1°" required="required" value="<%=periodo%>" class="form-control col-md-6"><br>
                                <label class="lbl1">Carga Horária:  </label><br>
                                <input type="text" name="cargaHoraria" placeholder="90h" required="required" value="<%=cargaHoraria%>" class="form-control col-md-6"><br>
                                <label class="lbl2">Descrição: </label><br>
                                <input type="text" name="descricao" placeholder="MMC, MDC..." required="required" value="<%=descricao%>" class="form-control col-md-6"><br>

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
