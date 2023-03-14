/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Disciplina;

/**
 *
 * @author Matheus
 */
public class DisciplinaDaoJpa implements InterfaceDao<Disciplina>{

    @Override
    public void incluir(Disciplina entidade) throws Exception { 
         /**
        *Aqui estamos fazendo basicamente o que fizemos na última aula, porém dentro de um método
        * Aqui é o mesmo método só mudou o nome do arquivo de BDUtils para ConnFactory que ambos tinham a mesma
        * funcionalidade, porém com nomes diferentes. Abrimos a transação persistindo e no final ele grava com
        * o commit e no final ele fecha com o close
        */
        EntityManager em = ConnFactory.getEntityManager();
        try{
            em.getTransaction().begin();
    
            em.persist(entidade);
            
            em.getTransaction().commit(); // o comit grava a ação
        }finally{
            em.close();
        }       
    }
    
    @Override
    public void editar(Disciplina entidade) throws Exception {
        
        /*
        O merge usado ali ele serve para atualizar uma instância de entidade de persistencia com novos valores de um campo detached entity instancia.
        
        */
      EntityManager em = ConnFactory.getEntityManager();
      try{
          em.getTransaction().begin();
           em.merge(entidade);
          em.getTransaction().commit();
      }finally{
          em.close();
    }
    }
    
    @Override
    public void excluir(Disciplina entidade) throws Exception {
        /*
        Para nós excluirmos alguém nós precisamos encontra-lo no nosso banco de dados para assim então excluir-lo.
        chegando o id ali no find, este novo registro vai receber aquele registro que foi passado ai quando eu removo
        é como se tivesse um ponteiro lá atrelado a essa entidade aí eu removo
        */
        
        
        
      EntityManager em = ConnFactory.getEntityManager();
      try{
          em.getTransaction().begin();
          Disciplina disc = em.find(Disciplina.class,entidade.getId());
          em.remove(disc);
          em.getTransaction().commit();
      } finally{
          em.close();
      }
    }

    @Override
    public Disciplina pesquisarPorId(int id) throws Exception {
          Disciplina disc = null;
      EntityManager em = ConnFactory.getEntityManager();
      try{
          em.getTransaction().begin();
          disc = em.find(Disciplina.class,id);
         
          em.getTransaction().commit();
      } finally{
          em.close();
      }
      return disc;
    }

    @Override
    public List<Disciplina> listar() throws Exception {
        /*
        Temos um método listar que
        retorna uma lista de Contato e ali ele recebeu essa lista recebendo null, para que de inicio 
        ela não tenha nenhum contato. 2º Chamamos o confactory para criar a conexão, chamamos o HQL que diretamente jogaremos para uma lista de registro
        o resultado do sql e no final ele mostra para o usuário
        */
        EntityManager em = ConnFactory.getEntityManager();
        List<Disciplina> lista = null;
        try{
            em.getTransaction().begin();
             lista = em.createQuery("FROM Professores prof").getResultList();
            em.getTransaction().commit();
        } finally{
            em.close();
        }
        return lista;
    }
    
    @Override
    public List<Disciplina> filtragem(String filtro) throws Exception {
        List<Disciplina> lista = null;
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            lista = em.createQuery("FROM Professores WHERE nomeProfessor LIKE '%" + filtro + "%'").getResultList();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return lista;
    }
    
}