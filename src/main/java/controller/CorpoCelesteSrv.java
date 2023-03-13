/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Registros;
import model.dao.DaoFactory;
import model.dao.InterfaceDao;
import model.dao.RegistroDaoJpa;

/**
 *
 * @author annak
 */
public class CorpoCelesteSrv extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {

             String acao = request.getParameter("acao");
             String id = request.getParameter("id");

            String nomeAluno = request.getParameter("nomeAluno");
            String dt_nascimento = request.getParameter("dt_nascimento");
            String naturalidade = request.getParameter("naturalidade");
            String endereco = request.getParameter("endereco");
            String telefone = request.getParameter("telefone");
            String nomeMae = request.getParameter("nomeMae");
            String nomePai = request.getParameter("nomePai");
            String buscarNome = request.getParameter("filtro");
           

            /*
            Criaremos uma variavel registro para a camada Dao fazer a conexao no banco de dados e imprirmir lá
             */
            InterfaceDao dao = DaoFactory.novoRegistroDAO(); // em todos os casos chamaremos o dão por isso ee ficou lá em cima
            Registros r1 = null; // esse carinha também será utilizado
            RequestDispatcher rd = null; //usaremos ele em todas as opções tbm. Ele reencaminha o usuario para outra tela

            switch (acao) {
                case "inclusao":
                    /*
                    O servelet recebe os parametros da tela que são as informações dos corpos selestes depois chamamos o dão que incluirá este contato
                    pegamos o processo e mandamos para o index.html ->   rd = request.getRequestDispatcher("index.html");
                    rd.forward(request, response);
                    */
                      r1= new Registros(nomeAluno, dt_nascimento,naturalidade,endereco,telefone,nomeMae,nomePai);
                    try {
                        dao.incluir(r1);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    rd = request.getRequestDispatcher("index.html");
                    rd.forward(request, response);
                    break;
                    
                
                case "pre-edicao": //faremos isso para preparar a tela de edição com os dados dos corpos celestes que queremos editar.
                    //buscar no banco de dados daquele lugar e jogar na tela
                  r1 = (Registros) dao.pesquisarPorId(Integer.parseInt(id));
                  rd = request.getRequestDispatcher("FormularioRegistro.jsp?acao=edicao"
                  
                       + "&id=" + r1.getId()
                            + "&nomeAluno=" + r1.getNomeAluno()
                            + "&dt_nascimento=" + r1.getDt_nascimento()
                            + "&naturalidade=" + r1.getNaturalidade()
                              + "&endereco=" + r1.getEndereco()
                            + "&telefone=" + r1.getTelefone()
                            + "&nomeMae=" + r1.getNomeMae()
                           + "&nomePai=" + r1.getNomePai()
                          
                  );
                    rd.forward(request, response);
                    break;
                 
                case "edicao":
                    
                       r1 = new Registros(nomeAluno,dt_nascimento,naturalidade,endereco,telefone,nomeMae,nomePai);
                    r1.setId(Integer.parseInt(id));
                    try {
                        dao.editar(r1);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    rd = request.getRequestDispatcher("Listagem.jsp?lista=" + listagem());
                    rd.forward(request, response);
                    break;
                  

                case "exclusao":
                    
                    /*
                    O que fazemos aqui? Criamos um novo contato damos um setId pegando o id da exclusão
                    que lá na listagempreenchemos o valor do id pegando o registro.getId. Então lá no formulário de exclusão já temos o id do cara que queremos excluir
                    adicionamos aquele id a um novo contato emandamos excluir aí jogamos de novo para a listagem para atualizar a tela
                    */
                  try{
                      r1 = new Registros();
                      r1.setId(Integer.parseInt(id));
                      dao.excluir(r1);
                      
                  }catch(Exception ex){
                      System.out.println("Erro"+ ex.getMessage());
                  }
                    rd = request.getRequestDispatcher("Listagem.jsp?lista="+listagem());
                    rd.forward(request,response);
                    
                    
                    break;

                case "listagem":
                    
                    /*
                    O que fizemos? Simplismente estamos dizendopara onde queremos ir, e estamos passandocomo parametro a list
                    o método listagem retorna essa lista em formato de tabela html e ele vai ser passado via get
                    no parametro lista ali
                    */
                    rd = request.getRequestDispatcher("Listagem.jsp?lista="+listagem());
                    rd.forward(request,response);
                    break;
                    
               case "filtrar":
                    rd = request.getRequestDispatcher("Listagem.jsp?lista=" + filtrar(buscarNome));
                    rd.forward(request, response);
                    break;

            }
        } catch (Exception ex) {
            Logger.getLogger(CorpoCelesteSrv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*Aqui criaremos um método;
    O que estamos fazendo no código abaixo? Estamos instanciando um RegistroDaoJpa para chamarmos o listar
    fizemos um for e acrescentamos alguns comandos de tabela ali html com os dados que precisamos
    passar lá para o html, é tipo com o json que fazemos. É um método auxiliar para fazer a listagem e retornar
    
    
    
    */
    
    private String filtrar(String nome) {
        InterfaceDao dao = new RegistroDaoJpa();
        List<Registros> lista = null;
        try {
            lista = dao.filtragem(nome);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        String listaHTML = "";
        for (Registros aluno : lista) {
             listaHTML = listaHTML
                    + "<tr>"
                    + "<td>" + aluno.getNomeAluno()     + "</td>"
                    + "<td>" + aluno.getDt_nascimento()    + "</td>"
                    + "<td>" + aluno.getNaturalidade() + "</td>"
                    + "<td>" + aluno.getEndereco()     + "</td>"
                    + "<td>" + aluno.getTelefone()    + "</td>"
                    + "<td>" + aluno.getNomeMae() + "</td>"
                    + "<td>" + aluno.getNomePai()    + "</td>"
                        + "<td><form action=CorpoCelesteSrv?acao=pre-edicao method='POST'>"
                    + "<input type='hidden' name='id'  value=" + 
                        aluno.getId() + "><input type='submit' value=editar>"
                    + "</form></td>"
                    
                    + "<form action=CorpoCelesteSrv?acao=exclusao method='POST'>"
                    + "<td><input type='hidden'  name='id' value=" + 
                        aluno.getId() + "><input type='submit' value=excluir>"
                    + "</form></td>"
                    
                  
                    + "</tr>";
        }
        return listaHTML;
    }
    
    
     private String listagem() {
        InterfaceDao dao = new RegistroDaoJpa();
        List<Registros> lista = null;
        try {
            lista = dao.listar();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        String listaHTML = "";
        for (Registros aluno : lista) {
            listaHTML = listaHTML
                    + "<tr>"
                    + "<td>" + aluno.getNomeAluno()     + "</td>"
                    + "<td>" + aluno.getDt_nascimento()    + "</td>"
                    + "<td>" + aluno.getNaturalidade() + "</td>"
                    + "<td>" + aluno.getEndereco()     + "</td>"
                    + "<td>" + aluno.getTelefone()    + "</td>"
                    + "<td>" + aluno.getNomeMae() + "</td>"
                    + "<td>" + aluno.getNomePai()    + "</td>"
                        + "<td><form action=CorpoCelesteSrv?acao=pre-edicao method='POST'>"
                    + "<input type='hidden' name='id'  value=" + 
                        aluno.getId() + "><input type='submit' value=editar>"
                    + "</form></td>"
                    
                    + "<form action=CorpoCelesteSrv?acao=exclusao method='POST'>"
                    + "<td><input type='hidden'  name='id' value=" + 
                        aluno.getId() + "><input type='submit' value=excluir>"
                    + "</form></td>"
                    
                  
                    + "</tr>";
        }
        return listaHTML;
    }
    
     
      
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
