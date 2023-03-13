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
import model.Professores;

/**
 *
 * @author Matheus
 */
public class ProfessorDaoJpa implements InterfaceDao<Professores>{

    @Override
    public void incluir(Professores entidade) throws Exception { 
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
    public void editar(Professores entidade) throws Exception {
        
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
    public void excluir(Professores entidade) throws Exception {
        /*
        Para nós excluirmos alguém nós precisamos encontra-lo no nosso banco de dados para assim então excluir-lo.
        chegando o id ali no find, este novo registro vai receber aquele registro que foi passado ai quando eu removo
        é como se tivesse um ponteiro lá atrelado a essa entidade aí eu removo
        */
        
        
        
      EntityManager em = ConnFactory.getEntityManager();
      try{
          em.getTransaction().begin();
          Professores prof = em.find(Professores.class,entidade.getId());
          em.remove(prof);
          em.getTransaction().commit();
      } finally{
          em.close();
      }
    }

    @Override
    public Professores pesquisarPorId(int id) throws Exception {
          Professores prof = null;
      EntityManager em = ConnFactory.getEntityManager();
      try{
          em.getTransaction().begin();
          prof = em.find(Professores.class,id);
         
          em.getTransaction().commit();
      } finally{
          em.close();
      }
      return prof;
    }

    @Override
    public List<Professores> listar() throws Exception {
        /*
        Temos um método listar que
        retorna uma lista de Contato e ali ele recebeu essa lista recebendo null, para que de inicio 
        ela não tenha nenhum contato. 2º Chamamos o confactory para criar a conexão, chamamos o HQL que diretamente jogaremos para uma lista de registro
        o resultado do sql e no final ele mostra para o usuário
        */
        EntityManager em = ConnFactory.getEntityManager();
        List<Professores> lista = null;
        try{
            em.getTransaction().begin();
             lista = em.createQuery("FROM Professores prof").getResultList();
            em.getTransaction().commit();
        } finally{
            em.close();
        }
        return lista;
    }
    
}