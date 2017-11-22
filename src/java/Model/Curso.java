/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.persistence.*;
/**
 *
 * @author ra21652435
 */
@Entity
public class Curso {
    
    //identificador da entidade, atributo obrigatório e auto gerado
    @Id
    @GeneratedValue
    private int id;
    //nome
    private String nome;
    //atributo do relacionamento OneToMany. Este relacionamento obriga que este atributo seja uma Lista. Este atributo significa que UM curso possui VÁRIAS matérias.
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Materia> materia;

    public Curso() {
    }

    public Curso(String nome) {
        this.nome = nome;
    }

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

    public List<Materia> getMateria() {
        return materia;
    }

    public void setMateria(List<Materia> materia) {
        this.materia = materia;
    }
}
