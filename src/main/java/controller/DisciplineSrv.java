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

            String acaoDisciplina = request.getParameter("acaoDisciplina");
            String id = request.getParameter("id");
            String nomeDisciplina = request.getParameter("nomeDisciplina");
            String periodo = request.getParameter("periodo");
            String cargaHoraria = request.getParameter("cargaHoraria");
            String descricao = request.getParameter("descricao");
            private List<Disciplina> alunos = new ArrayList<>;
            alunos = request.getParameter("alunos");

            /*
            Criaremos uma variavel registro para a camada Dao fazer a conexao no banco de dados e imprirmir lá
             */
            InterfaceDao dao = DaoFactory.novaDisciplinaDAO(); // em todos os casos chamaremos o dão por isso ee ficou lá em cima
            Registros r1 = null; // esse carinha também será utilizado
            RequestDispatcher rd = null; //usaremos ele em todas as opções tbm. Ele reencaminha o usuario para outra tela

            switch (acaoDisciplina) {
                case "inclusao":
                 
                      r1= new Disciplina(nome, periodo, cargaHoraria, descricao, alunos);
                    try {
                        dao.incluir(r1);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    rd = request.getRequestDispatcher("index.html");
                    rd.forward(request, response);
                    break;
                    
                
                case "pre-edicao": 
                    //buscar no banco de dados daquele lugar e jogar na tela
                  r1 =  dao.pesquisarPorId(Integer.parseInt(id));
                  rd = request.getRequestDispatcher("FormularioDisciplina.jsp?acao=edicao"
                  
                       + "&id=" + r1.getId()
                            + "&nome=" + r1.getNome()
                            + "&periodo=" + r1.getPeriodo()
                            + "&cargaHoraria=" + r1.getCargaHoraria()
                              + "&descricao=" + r1.getDescricao()
                          
                  );
                    rd.forward(request, response);
                    break;
                 
                case "edicao":
                    
                       r1= new Disciplina(nome, periodo, cargaHoraria, descricao, alunos);
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
                    
                  try{
                      r1 = new Disciplina();
                      r1.setId(Integer.parseInt(id));
                      dao.excluir(r1);
                      
                  }catch(Exception ex){
                      System.out.println("Erro"+ ex.getMessage());
                  }
                    rd = request.getRequestDispatcher("Listagem.jsp?lista="+listagem());
                    rd.forward(request,response);
                    
                    
                    break;

                case "listagem":
                    rd = request.getRequestDispatcher("Listagem.jsp?lista="+listagem());
                    rd.forward(request,response);
                    break;

            }
        } catch (Exception ex) {
            Logger.getLogger(DisciplineSrv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     private String listagem() {
        InterfaceDao dao = new RegistroDaoJpa();
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
                    + "<td>" + disciplina.getNome()     + "</td>"
                    + "<td>" + disciplina.getPeriodo()    + "</td>"
                    + "<td>" + disciplina.getCargaHoraria() + "</td>"
                    + "<td>" + disciplina.getDescricao()     + "</td>"
                        + "<td><form action=DisciplineSrv?acao=pre-edicao method='POST'>"
                    + "<input type='hidden' name='id'  value=" + 
                        aluno.getId() + "><input type='submit' value=editar>"
                    + "</form></td>"
                    
                    + "<form action=DisciplineSrv?acao=exclusao method='POST'>"
                    + "<td><input type='hidden'  name='id' value=" + 
                        aluno.getId() + "><input type='submit' value=excluir>"
                    + "</form></td>"
                    
                  
                    + "</tr>";
        }
        return listaHTML;
    }
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