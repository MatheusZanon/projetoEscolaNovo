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
        String nomeAluno = request.getParameter("nomeAluno");
        String dt_nascimento = request.getParameter("dt_nascimento");
        String naturalidade = request.getParameter("naturalidade");
        String endereco = request.getParameter("endereco");
        String telefone = request.getParameter("telefone");
        String nomeMae = request.getParameter("nomeMae");
        String nomePai = request.getParameter("nomePai");

        if (id == null) {
            nomeAluno = "";
            dt_nascimento = "";
            naturalidade = "";
            endereco = "";
            telefone = "";
            nomeMae = "";
            nomePai = "";
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

                    <h1>Cadastro de alunos</h1>
                    <img src="imagem/scary (1).png" alt="scary (1)" class="enfeite"/>

                </div>
            </header>
            <div class="mainWindowProfessor">
                <div class="container">
                    <div class="card">
                        <div class="card-body">    
                            <form action="CorpoCelesteSrv" method="POST">

                                <input type="hidden" name="acao" value="<%=acao%>" />
                                <input type="hidden" name="id" value="<%=id%>" />
                                <p><b>Registre um aluno</b></p>
                                <label class="lbl1">Nome do aluno:  </label><br>
                                <input type="text" name="nomeAluno" placeholder="Exemplo: Clarissa Alexandra" required="required" value="<%=nomeAluno%>" class="form-control col-md-6"><br>
                                <label class="lbl2">Data de nascimento:  </label><br>
                                <input type="text" name="dt_nascimento" placeholder="Exemplo: 22/01/2002" required="required" value="<%=dt_nascimento%>" class="form-control col-md-6"><br>
                                <label class="lbl1">Naturalidade:  </label><br>
                                <input type="text" name="naturalidade" placeholder="Exemplo: Brasileira" required="required" value="<%=naturalidade%>" class="form-control col-md-6"><br>
                                <label class="lbl2">Endereço: </label><br>
                                <input type="text" name="endereco" placeholder="Exemplo: Rua dos Andradas, nº 150" required="required" value="<%=endereco%>" class="form-control col-md-6"><br>
                                <label class="lbl1">Telefone:  </label><br>
                                <input type="text" name="telefone" placeholder="Exemplo:(22) 99685743" required="required" value="<%=telefone%>" class="form-control col-md-6"><br>
                                <label class="lbl2">Nome da responsável (mãe): </label><br>
                                <input type="text" name="nomeMae" placeholder="Exemplo: Minerva Alexandra Alves" required="required" value="<%=nomeMae%>" class="form-control col-md-6"><br>
                                <label class="lbl2">Nome da responsável (pai): </label><br>
                                <input type="text" name="nomePai" placeholder="Exemplo: Frederico Antonie German" required="required" value="<%=nomePai%>" class="form-control col-md-6"><br>

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
