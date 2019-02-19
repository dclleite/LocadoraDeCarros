/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author eduardo
 */
public class Locadora {
    
    private String nome;
    private String tipoCarro;
    private int qtdMax;
    private double precoDiaSemanaN;
    private double precoFimSemanaN;
    private double precoDiaSemanaP;
    private double precoFimSemanaP;

    public Locadora(String nome, String tipoCarro, int qtdMax, double precoDiaSemanaN, double precoFimSemanaN, double precoDiaSemanaP, double precoFimSemanaP) {
        this.nome = nome;
        this.tipoCarro = tipoCarro;
        this.precoDiaSemanaN = precoDiaSemanaN;
        this.precoFimSemanaN = precoFimSemanaN;
        this.precoDiaSemanaP = precoDiaSemanaP;
        this.precoFimSemanaP = precoFimSemanaP;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoCarro() {
        return tipoCarro;
    }

    public void setTipoCarro(String tipoCarro) {
        this.tipoCarro = tipoCarro;
    }

    public int getQtdMax() {
        return qtdMax;
    }

    public void setQtdMax(int qtdMax) {
        this.qtdMax = qtdMax;
    }

    
    public double getPrecoDiaSemanaN() {
        return precoDiaSemanaN;
    }

    public void setPrecoDiaSemanaN(double precoDiaSemanaN) {
        this.precoDiaSemanaN = precoDiaSemanaN;
    }

    public double getPrecoFimSemanaN() {
        return precoFimSemanaN;
    }

    public void setPrecoFimSemanaN(double precoFimSemanaN) {
        this.precoFimSemanaN = precoFimSemanaN;
    }

    public double getPrecoDiaSemanaP() {
        return precoDiaSemanaP;
    }

    public void setPrecoDiaSemanaP(double precoDiaSemanaP) {
        this.precoDiaSemanaP = precoDiaSemanaP;
    }

    public double getPrecoFimSemanaP() {
        return precoFimSemanaP;
    }

    public void setPrecoFimSemanaP(double precoFimSemanaP) {
        this.precoFimSemanaP = precoFimSemanaP;
    }
    
    public void Imprimir(){
        System.out.println(this.getNome()+"\n"+this.getTipoCarro()+"\n"+this.getPrecoDiaSemanaN()+
                "\n"+this.getPrecoFimSemanaN()+"\n"+this.getPrecoDiaSemanaP()+"\n"+this.getPrecoFimSemanaP()+"\n");
    }
    
    
    


}
