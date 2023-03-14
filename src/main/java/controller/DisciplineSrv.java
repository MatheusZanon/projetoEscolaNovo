
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Disciplina;
import model.dao.DisciplinaDaoJpa;
import model.dao.DaoFactory;
import model.dao.InterfaceDao;


/**
 *
 * @author Roni
 */
public class DisciplineSrv extends HttpServlet {
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
            String nomeDisciplina = request.getParameter("nomeDisciplina");
            String periodo = request.getParameter("periodo");
            String cargaHoraria = request.getParameter("cargaHoraria");
            String descricao = request.getParameter("descricao");
            String buscarNome = request.getParameter("filtro");

            /*
            Criaremos uma variavel registro para a camada Dao fazer a conexao no banco de dados e imprirmir lá
             */
            InterfaceDao dao = DaoFactory.novaDisciplinaDAO(); // em todos os casos chamaremos o dão por isso ee ficou lá em cima
            Disciplina disc = null; // esse carinha também será utilizado
            RequestDispatcher rd = null; //usaremos ele em todas as opções tbm. Ele reencaminha o usuario para outra tela

            switch (acao) {
                case "inclusao":
                 
                      disc = new Disciplina(nomeDisciplina, periodo, cargaHoraria, descricao);
                    try {
                        dao.incluir(disc);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    rd = request.getRequestDispatcher("index.html");
                    rd.forward(request, response);
                    break;
                    
                
                case "pre-edicao": 
                    //buscar no banco de dados daquele lugar e jogar na tela
                  disc = (Disciplina) dao.pesquisarPorId(Integer.parseInt(id));
                  rd = request.getRequestDispatcher("FormularioRegistroDisciplina.jsp?acao=edicao"
                  
                       + "&id=" + disc.getId()
                            + "&nomeDisciplina=" + disc.getNomeDisciplina()
                            + "&periodo=" + disc.getPeriodo()
                            + "&cargaHoraria=" + disc.getCargaHoraria()
                            + "&descricao=" + disc.getDescricao()
                          
                  );
                    rd.forward(request, response);
                    break;
                 
                case "edicao":
                    
                    disc= new Disciplina(nomeDisciplina, periodo, cargaHoraria, descricao);
                    disc.setId(Integer.parseInt(id));
                    try {
                        dao.editar(disc);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    rd = request.getRequestDispatcher("ListagemDisciplina.jsp?lista=" + listagem());
                    rd.forward(request, response);
                    break;
                  

                case "exclusao":
                    
                  try{
                      disc = new Disciplina();
                      disc.setId(Integer.parseInt(id));
                      dao.excluir(disc);
                      
                  }catch(Exception ex){
                      System.out.println("Erro"+ ex.getMessage());
                  }
                    rd = request.getRequestDispatcher("ListagemDisciplina.jsp?lista="+listagem());
                    rd.forward(request,response);
                    
                    
                    break;

                case "listagem":
                    rd = request.getRequestDispatcher("ListagemDisciplina.jsp?lista="+listagem());
                    rd.forward(request,response);
                    break;
                
                case "filtrar":
                    rd = request.getRequestDispatcher("ListagemDisciplina.jsp?lista=" + filtrar(buscarNome));
                    rd.forward(request, response);
                break;

            }
        } catch (Exception ex) {
            Logger.getLogger(DisciplineSrv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String filtrar(String nome) {
        InterfaceDao dao = new DisciplinaDaoJpa();
        List<Disciplina> lista = null;
        try {
            lista = dao.filtragem(nome);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        String listaHTML = "";
        for (Disciplina disciplina : lista) {
             listaHTML = listaHTML
                    + "<tr>"
                    + "<td>" + disciplina.getNomeDisciplina()     + "</td>"
                    + "<td>" + disciplina.getPeriodo()    + "</td>"
                    + "<td>" + disciplina.getCargaHoraria() + "</td>"
                    + "<td>" + disciplina.getDescricao()     + "</td>"
                        + "<td><form action=DisciplineSrv?acao=pre-edicao method='POST'>"
                    + "<input type='hidden' name='id'  value=" + 
                        disciplina.getId() + "><input type='submit' value=editar>"
                    + "</form></td>"
                    
                    + "<form action=DisciplineSrv?acao=exclusao method='POST'>"
                    + "<td><input type='hidden'  name='id' value=" + 
                        disciplina.getId() + "><input type='submit' value=excluir>"
                    + "</form></td>"
                    
                  
                    + "</tr>";
        }
        return listaHTML;
    }
    
     private String listagem() {
        InterfaceDao dao = new DisciplinaDaoJpa();
        List<Disciplina> lista = null;
        try {
            lista = dao.listar();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        String listaHTML = "";
        for (Disciplina disciplina : lista) {
            listaHTML = listaHTML
                    + "<tr>"
                    + "<td>" + disciplina.getNomeDisciplina()     + "</td>"
                    + "<td>" + disciplina.getPeriodo()    + "</td>"
                    + "<td>" + disciplina.getCargaHoraria() + "</td>"
                    + "<td>" + disciplina.getDescricao()     + "</td>"
                        + "<td><form action=DisciplineSrv?acao=pre-edicao method='POST'>"
                    + "<input type='hidden' name='id'  value=" + 
                        disciplina.getId() + "><input type='submit' value=editar>"
                    + "</form></td>"
                    
                    + "<form action=DisciplineSrv?acao=exclusao method='POST'>"
                    + "<td><input type='hidden'  name='id' value=" + 
                        disciplina.getId() + "><input type='submit' value=excluir>"
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