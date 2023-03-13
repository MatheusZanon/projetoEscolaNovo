<%-- 
    Document   : FormularioRegistro
    Created on : 6 de mar. de 2023, 12:08:17
    Author     : annak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String acaoDisciplina = request.getParameter("acaoDisciplina");
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String periodo = request.getParameter("periodo");
        String cargaHoraria = request.getParameter("cargaHoraria");
        String descricao = request.getParameter("descricao");

        if (id == null) {
            nome = "";
            periodo = "";
            cargaHoraria = "";
            descricao = "";
        }

    %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <section class="secao-principal-cad">
            <div class="cadastroC">
                <h3>Cadastre Disciplina </h3>

                
                <form action="CorpoCelesteSrv" method="POST">
                    <input type="hidden" name="acao" value="<%=acaoDisciplina%>" />
                    <input type="hidden" name="id" value="<%=id %>" />
                    <label class="lbl1">Nome da disciplina:  </label><br>
                    <input type="text" name="nome" placeholder="Matemática" required="required" value="<%=nome%>" class="inp11"><br>
                    <label class="lbl2">Período:  </label><br>
                    <input type="text" name="periodo" placeholder="1°" required="required" value="<%=periodo%>" class="inp11"><br>
                    <label class="lbl1">Carga Horária:  </label><br>
                    <input type="text" name="cargaHoraria" placeholder="90h" required="required" value="<%=cargaHoraria%>" class="inp11"><br>
                    <label class="lbl2">Descrição: </label><br>
                    <input type="text" name="descricao" placeholder="MMC, MDC..." required="required" value="<%=descricao%>" class="inp11"><br>

                    <input type="submit" value="Salvar"/>
                    <input type="reset" value="Cancelar" />
                </form>
            </div>
    </body>
</html>
