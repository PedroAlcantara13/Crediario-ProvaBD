/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Pedro Alcantara
 */
public class Compra {
    private int cod;
    private String Nomecli;
    private double Divida;
    private String Produto;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNomecli() {
        return Nomecli;
    }

    public void setNomecli(String Nomecli) {
        this.Nomecli = Nomecli;
    }

    public double getDivida() {
        return Divida;
    }

    public void setDivida(double Divida) {
        this.Divida = Divida;
    }

    public String getProduto() {
        return Produto;
    }

    public void setProduto(String Produto) {
        this.Produto = Produto;
    }
    
    
}
