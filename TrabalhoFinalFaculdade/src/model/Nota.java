/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Bruno
 */
public class Nota {
    private int id;
    private Avaliacao avaliacao;
    private Usuario usuario;
    private char conceito;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public char getConceito() {
        return conceito;
    }

    public void setConceito(char conceito) {
        this.conceito = conceito;
    }
    
}
