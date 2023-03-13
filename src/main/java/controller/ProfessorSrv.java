/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import model.Professores;
import model.dao.DaoFactory;
import model.dao.InterfaceDao;
import model.dao.ProfessorDaoJpa;

/**
 *
 * @author Matheus
 */
public class ProfessorSrv extends HttpServlet {
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            
            String acao = request.getParameter("acao");
            String id = request.getParameter("id");
            
            String nomeProfessor = request.getParameter("nomeProfessor");
            String dt_nascimento = request.getParameter("dt_nascimento");
            String naturalidade = request.getParameter("naturalidade");
            String endereco = request.getParameter("endereco");
            String telefone = request.getParameter("telefone");
            String estadoCivil = request.getParameter("estadoCivil");
            String buscarNome = request.getParameter("filtro");
           

            /*
            Criaremos uma variavel registro para a camada Dao fazer a conexao no banco de dados e imprirmir lá
             */
            InterfaceDao dao = DaoFactory.novoProfessorDAO(); // em todos os casos chamaremos o dão por isso ee ficou lá em cima
            Professores prof = null; // esse carinha também será utilizado
            RequestDispatcher rd = null; //usaremos ele em todas as opções tbm. Ele reencaminha o usuario para outra tela
            
            switch (acao) {
                case "inclusao":
                    /*
                    O servelet recebe os parametros da tela que são as informações dos corpos selestes depois chamamos o dão que incluirá este contato
                    pegamos o processo e mandamos para o index.html ->   rd = request.getRequestDispatcher("index.html");
                    rd.forward(request, response);
                    */
                      prof = new Professores(nomeProfessor, dt_nascimento, naturalidade, endereco, telefone, estadoCivil);
                    try {
                        dao.incluir(prof);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage() + "erro");
                    }
                    rd = request.getRequestDispatcher("index.html");
                    rd.forward(request, response);
                    break;
                    
                
                case "pre-edicao": //faremos isso para preparar a tela de edição com os dados dos corpos celestes que queremos editar.
                    //buscar no banco de dados daquele lugar e jogar na tela
                  
                  
                  prof = (Professores) dao.pesquisarPorId(Integer.parseInt(id));
                  rd = request.getRequestDispatcher("FormularioRegistroProfessor.jsp?acao=edicao"
                  
                       + "&id=" + prof.getId()
                            + "&nomeProfessor=" + prof.getNomeProfessor()
                            + "&dt_nascimento=" + prof.getDt_nascimento()
                            + "&naturalidade=" + prof.getNaturalidade()
                              + "&endereco=" + prof.getEndereco()
                            + "&telefone=" + prof.getTelefone()   
                            + "&estadoCivil=" + prof.getEstadoCivil() 
                  );
                    rd.forward(request, response);
                    break;
               
                    
                case "edicao":
                    
                    prof = new Professores(nomeProfessor,dt_nascimento,naturalidade,endereco,telefone,estadoCivil);
                    prof.setId(Integer.parseInt(id));
                    try {
                        dao.editar(prof);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    rd = request.getRequestDispatcher("ListagemProfessor.jsp?lista=" + listagem());
                    rd.forward(request, response);
                    break;
                  

                case "exclusao":
                    
                    /*
                    O que fazemos aqui? Criamos um novo contato damos um setId pegando o id da exclusão
                    que lá na listagempreenchemos o valor do id pegando o registro.getId. Então lá no formulário de exclusão já temos o id do cara que queremos excluir
                    adicionamos aquele id a um novo contato emandamos excluir aí jogamos de novo para a listagem para atualizar a tela
                    */
                  try{
                      prof = new Professores();
                      prof.setId(Integer.parseInt(id));
                      dao.excluir(prof);
                      
                  }catch(Exception ex){
                      System.out.println("Erro"+ ex.getMessage());
                  }
                    rd = request.getRequestDispatcher("ListagemProfessor.jsp?lista="+listagem());
                    rd.forward(request,response);
                    
                    
                    break;

                case "listagem":
                    
                    /*
                    O que fizemos? Simplismente estamos dizendopara onde queremos ir, e estamos passandocomo parametro a list
                    o método listagem retorna essa lista em formato de tabela html e ele vai ser passado via get
                    no parametro lista ali
                    */
                    rd = request.getRequestDispatcher("ListagemProfessor.jsp?lista="+listagem());
                    rd.forward(request,response);
                    break;
                    
               case "filtrar":
                    rd = request.getRequestDispatcher("ListagemProfessor.jsp?lista=" + filtrar(buscarNome));
                    rd.forward(request, response);
                    break;

            }
        } catch (Exception ex) {
            Logger.getLogger(ProfessorSrv.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
    private String listagem() {
        InterfaceDao dao = new ProfessorDaoJpa();
        List<Professores> lista = null;
        try {
            lista = dao.listar();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        String listaHTML = "";
        for (Professores professor : lista) {
            listaHTML = listaHTML
                    + "<tr>"
                    + "<td>" + professor.getNomeProfessor()     + "</td>"
                    + "<td>" + professor.getDt_nascimento()    + "</td>"
                    + "<td>" + professor.getNaturalidade() + "</td>"
                    + "<td>" + professor.getEndereco()     + "</td>"
                    + "<td>" + professor.getTelefone()    + "</td>"
                    + "<td>" + professor.getEstadoCivil()    + "</td>"
                    + "<td><form action=ProfessorSrv?acao=pre-edicao method='POST'>"
                    + "<input type='hidden' name='id'  value=" + 
                        professor.getId() + "><input type='submit' value=editar>"
                    + "</form></td>"
                    
                    + "<form action=ProfessorSrv?acao=exclusao method='POST'>"
                    + "<td><input type='hidden'  name='id' value=" + 
                        professor.getId() + "><input type='submit' value=excluir>"
                    + "</form></td>"
                    
                  
                    + "</tr>";
        }
        return listaHTML;
    }
    
    private String filtrar(String nome) {
        InterfaceDao dao = new ProfessorDaoJpa();
        List<Professores> lista = null;
        try {
            lista = dao.filtragem(nome);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        String listaHTML = "";
        for (Professores professor : lista) {
            listaHTML = listaHTML
                    + "<tr>"
                    + "<td>" + professor.getNomeProfessor()     + "</td>"
                    + "<td>" + professor.getDt_nascimento()    + "</td>"
                    + "<td>" + professor.getNaturalidade() + "</td>"
                    + "<td>" + professor.getEndereco()     + "</td>"
                    + "<td>" + professor.getTelefone()    + "</td>"
                    + "<td>" + professor.getEstadoCivil()    + "</td>"
                    + "<td><form action=ProfessorSrv?acao=pre-edicao method='POST'>"
                    + "<input type='hidden' name='id'  value=" + 
                        professor.getId() + "><input type='submit' value=editar>"
                    + "</form></td>"
                    
                    + "<form action=ProfessorSrv?acao=exclusao method='POST'>"
                    + "<td><input type='hidden'  name='id' value=" + 
                        professor.getId() + "><input type='submit' value=excluir>"
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
