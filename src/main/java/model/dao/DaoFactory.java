/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

/**
 *
 * O Nosso DaoFactory criará um novo registro Dao JPA
 */
public class DaoFactory {
 
    public static RegistroDaoJpa novoRegistroDAO() throws Exception {
         return new RegistroDaoJpa();
    }
    
    public static DisciplinaDaoJpa novaDisciplinaDAO() throws Exception {
         return new DisciplinaDaoJpa();
    }


}
