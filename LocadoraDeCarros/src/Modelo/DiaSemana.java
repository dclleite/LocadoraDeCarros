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
public class DiaSemana {
    private String dias;
    private Integer id;

    public DiaSemana(String dias, Integer id) {
        this.dias = dias;
        this.id = id;
    }

   
    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
 
    @Override
    public String toString() {
        return getDias();
    }    
}


