/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.Entity;

/**
 *
 * @author ra21652435
 */
@Entity
public class Presencial extends Materia{

    private int codigo;

    public Presencial(int codigo) {
        this.codigo = codigo;
    }

    public Presencial(int codigo, String nome, Curso curso) {
        super(nome, curso);
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

   
}
