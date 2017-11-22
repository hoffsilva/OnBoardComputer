/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.*;
/**
 *
 * @author ra21652435
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Materia {
    
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Curso curso;

    public Materia() {
    }

    public Materia(String nome, Curso curso) {
        this.nome = nome;
        this.curso = curso;
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    } 
}
