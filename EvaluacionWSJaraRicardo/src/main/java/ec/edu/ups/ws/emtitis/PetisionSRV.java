/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.ws.emtitis;

/**
 *
 * @author Vinicio
 */
public class PetisionSRV {
    private String nuemroCuenta;
    private double cantidad;
    private int numeromeses;

    public PetisionSRV() {
    }

    public PetisionSRV(String nuemroCuenta, double cantidad, int numeromeses) {
        this.nuemroCuenta = nuemroCuenta;
        this.cantidad = cantidad;
        this.numeromeses = numeromeses;
    }

    public String getNuemroCuenta() {
        return nuemroCuenta;
    }

    public void setNuemroCuenta(String nuemroCuenta) {
        this.nuemroCuenta = nuemroCuenta;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public int getNumeromeses() {
        return numeromeses;
    }

    public void setNumeromeses(int numeromeses) {
        this.numeromeses = numeromeses;
    }
     
    
}
