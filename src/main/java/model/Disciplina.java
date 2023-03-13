/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Roni
 */

@Entity
@Table ( name = " tbl_disciplinas ")
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(length = 240, nullable = false)
    private String nome;
    
    @Column(length = 240, nullable = false)
    private String periodo;
    
    @Column(length = 240, nullable = false)
    private String cargaHoraria;
    
    @Column(length = 240, nullable = false)
    private String descricao;
    
    
    
}
