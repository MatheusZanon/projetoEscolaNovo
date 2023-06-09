/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

/**
 *
 * @author annak
 */
@Entity
//@NamedQuery(name="Registros.findAll", query="Select nomeAluno from Registros")
//@NamedQuery(name="Registros.cadastrados", query="from registros r1")
public class Registros implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 240, nullable = false)
    private String nomeAluno;
    @Column(length = 130, nullable = false)
    private String dt_nascimento;
    @Column(length = 130, nullable = false)
    private String naturalidade;
    @Column(length = 130, nullable = false)
    private String endereco;
    @Column(length = 130, nullable = false)
    private String telefone;
    @Column(length = 130, nullable = false)
    private String nomeMae;
    @Column(length = 130, nullable = false)
    private String nomePai;
    
    //@ManyToMany
   // private Collection<Disciplina> disciplinas = new ArrayList<Disciplina>();

    public Registros() {
    }

    public Registros(String nomeAluno, String dt_nascimento, String naturalidade, String endereco, String telefone, String nomeMae, String nomePai) {
        this.nomeAluno = nomeAluno;
        this.dt_nascimento = dt_nascimento;
        this.naturalidade = naturalidade;
        this.endereco = endereco;
        this.telefone = telefone;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
    }

  
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
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

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

   // public Collection<Disciplina> getDisciplinas() {
    //    return disciplinas;
  //  }

   // public void setDisciplinas(Collection<Disciplina> disciplinas) {
      //  this.disciplinas = disciplinas;
   // }
   

    
}
