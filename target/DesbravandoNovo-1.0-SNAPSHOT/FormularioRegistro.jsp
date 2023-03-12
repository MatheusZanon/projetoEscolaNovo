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
            nomePai= "";
        }

    %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <section class="secao-principal-cad">
            <div class="cadastroC">
                <h3>Registre sua primeira descoberta cosmica </h3>


                <p>A maioria das descobertas astronômicas se deram ao longo de um processo contínuo de observação e contribuição de vários astrônomos e cientistas, e quem sabe você
                    não seja como eles e, assim, revolucione o mundo com suas descobertas?!</p>
                <form action="CorpoCelesteSrv" method="POST">
                    <input type="hidden" name="acao" value="<%=acao%>" />
                    <input type="hidden" name="id" value="<%=id %>" />
                    <label class="lbl1">Nome do aluno:  </label><br>
                    <input type="text" name="nomeAluno" placeholder="Mercúrio" required="required" value="<%=nomeAluno%>" class="inp11"><br>
                    <label class="lbl2">Data de nascimento:  </label><br>
                    <input type="text" name="dt_nascimento" placeholder="Não possuí nenhum" required="required" value="<%=dt_nascimento%>" class="inp11"><br>
                    <label class="lbl1">Naturalidade:  </label><br>
                    <input type="text" name="naturalidade" placeholder="208.810.021 km" required="required" value="<%=naturalidade%>" class="inp11"><br>
                    <label class="lbl2">Endereço: </label><br>
                    <input type="text" name="endereco" placeholder="Em algum lugar do espaço" required="required" value="<%=endereco%>" class="inp11"><br>
                    <label class="lbl1">Telefone:  </label><br>
                    <input type="text" name="telefone" placeholder="427ºC" required="required" value="<%=telefone%>" class="inp11"><br>
                    <label class="lbl2">Nome da responsável(mãe): </label><br>
                    <input type="text" name="nomeMae" placeholder="3,7 m/s" required="required" value="<%=nomeMae%>" class="inp11"><br>
                    <label class="lbl2">Nome da responsável(pai): </label><br>
                    <input type="text" name="nomePai" placeholder="Gato" required="required" value="<%=nomePai%>" class="inp11"><br>

                    <input type="submit" value="Salvar"/>
                    <input type="reset" value="Cancelar" />
                </form>
            </div>
    </body>
</html>
