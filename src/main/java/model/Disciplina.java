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
public class Disciplina {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(length = 240, nullable = false)
    private String nomeDisciplina;
    
    @Column(length = 240, nullable = false)
    private String periodo;
    
    @Column(length = 240, nullable = false)
    private String cargaHoraria;
    
    @Column(length = 240, nullable = false)
    private String descricao;

    /*
    @ManyToOne(optional = true)
    @JoinColumn(name = "professor_id")
    */

    public Disciplina() {
        
    }
    
    public Disciplina(String nomeDisciplina, String periodo, String cargaHoraria, String descricao) {
        this.nomeDisciplina = nomeDisciplina;
        this.periodo = periodo;
        this.cargaHoraria = cargaHoraria;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
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


    @Override
    public String toString() {
        return "Disciplina{" + "id=" + id + ", nomeDisciplina=" + nomeDisciplina + ", periodo=" + periodo + ", cargaHoraria=" + cargaHoraria + ", descricao=" + descricao + '}';
    }
     
}