/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * Este arquivo é o nosso DBUtils da ultima aula, pois ele faz a conexão e retorna a conexão
 * 
 */
public class ConnFactory {
     public static EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("DesbravandoUniversoPU");
        EntityManager entityManager = factory.createEntityManager();
        return entityManager;
    }
}
