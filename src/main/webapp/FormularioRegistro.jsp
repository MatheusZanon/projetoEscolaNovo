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
        <link rel="stylesheet" href="css/CadastroAluno.css">
    <link rel="stylesheet" a href="css/tabela2.css">
        <title>Registro de Alunos</title>
    </head>
    <body>
         <main>
            <!--Criando um cabeçalho------------------------------------------------------------------------>
            <header class="cabecalho">
                <div class="detalhes">
                    <img src="imagem/go-to-school.png" alt="language" class="enfeite"/>

                    <h1>Cadastro de alunos</h1>
                    <img src="imagem/online-learning.png" alt="online-learning"  class="enfeite"/>

                </div>
            </header>
        <section class="secao-principal-cad">
            <div class="cadastroC">
            
                <form action="CorpoCelesteSrv" method="POST">
                    <br>
                    <br>
                    <input type="hidden" name="acao" value="<%=acao%>" />
                    <input type="hidden" name="id" value="<%=id%>" />
                    <label class="lbl1">Nome do aluno:  </label><br>
                    <input type="text" name="nomeAluno" placeholder="Exemplo: Clarissa Alexandra" required="required" value="<%=nomeAluno%>" class="form-control col-md-3"><br>
                    <label class="lbl2">Data de nascimento:  </label><br>
                    <input type="text" name="dt_nascimento" placeholder="Exemplo: 22/01/2002" required="required" value="<%=dt_nascimento%>" class="form-control col-md-3"><br>
                    <label class="lbl1">Naturalidade:  </label><br>
                    <input type="text" name="naturalidade" placeholder="Exemplo: Brasileira" required="required" value="<%=naturalidade%>" class="form-control col-md-3"><br>
                    <label class="lbl2">Endereço: </label><br>
                    <input type="text" name="endereco" placeholder="Exemplo: Rua dos Andradas, nº 150" required="required" value="<%=endereco%>" class="form-control col-md-3"><br>
                    <label class="lbl1">Telefone:  </label><br>
                    <input type="text" name="telefone" placeholder="Exemplo:(22) 99685743" required="required" value="<%=telefone%>" class="form-control col-md-3"><br>
                    <label class="lbl2">Nome da responsável(mãe): </label><br>
                    <input type="text" name="nomeMae" placeholder="Exemplo: Minerva Alexandra Alves" required="required" value="<%=nomeMae%>" class="form-control col-md-3"><br>
                    <label class="lbl2">Nome da responsável(pai): </label><br>
                    <input type="text" name="nomePai" placeholder="Exemplo: Frederico Antonie German" required="required" value="<%=nomePai%>" class="form-control col-md-3"><br>

                    <input type="submit" value="Salvar" class="btn btn-warning"/>
                    <input type="reset" value="Cancelar"  class="btn btn-danger" />
                    <a href="index.html" type="button" class="btn btn-danger">Voltar</a>
                    <br><br><br><br><br><br><br><br><br><br>
                </form>
            </div>
    </body>
</html>
