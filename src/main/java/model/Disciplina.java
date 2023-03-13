package model;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

    public Disciplina() {
        
    }
    
    public Disciplina(String nome, String periodo, String cargaHoraria, String descricao, Collection<Registros> alunos) {
        this.nome = nome;
        this.periodo = periodo;
        this.cargaHoraria = cargaHoraria;
        this.descricao = descricao;
        this.alunos = alunos;
    }
    
    @ManyToMany
    @JoinTable ( name =" Disciplina_Aluno ", joinColumns = @JoinColumn ( name =" Disciplinas_Id "), inverseJoinColumns = @JoinColumn ( name =" Registros_Id ") )
    private Collection<Registros> alunos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Collection<Registros> getAlunos() {
        return alunos;
    }

    public void setAlunos(Collection<Registros> alunos) {
        this.alunos = alunos;
    }

    @Override
    public String toString() {
        return "Disciplina{" + "id=" + id + ", nome=" + nome + ", periodo=" + periodo + ", cargaHoraria=" + cargaHoraria + ", descricao=" + descricao + ", alunos=" + alunos + '}';
    }
     
}
