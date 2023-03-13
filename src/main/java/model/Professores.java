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

/**
 *
 * @author annak
 */
@Entity
public class Professores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 240, nullable = false)
    private String nomeProfessor;
    @Column(length = 130, nullable = false)
    private String dt_nascimento;
    @Column(length = 130, nullable = false)
    private String naturalidade;
    @Column(length = 130, nullable = false)
    private String endereco;
    @Column(length = 130, nullable = false)
    private String telefone;
    @Column(length = 130, nullable = false)
    private String estadoCivil;


   

    public Professores() {
    }

    public Professores(String nomeProfessor, String dt_nascimento, String naturalidade, String endereco, String telefone, String estadoCivil) {
        this.nomeProfessor = nomeProfessor;
        this.dt_nascimento = dt_nascimento;
        this.naturalidade = naturalidade;
        this.endereco = endereco;
        this.telefone = telefone;
        this.estadoCivil = estadoCivil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(String dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }    
    
    public String getEstadoCivil() {
        return estadoCivil;
    }
    
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String toString() {
        return "Professores{" + "id=" + id + ", nomeProfessor=" + nomeProfessor + ", dt_nascimento=" + dt_nascimento + ", naturalidade=" + naturalidade + ", endereco=" + endereco + ", telefone=" + telefone + "estadoCivil=" + estadoCivil + '}';
    }  
   
}
