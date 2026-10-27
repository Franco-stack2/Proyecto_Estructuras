/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuras;

/**
 *
 * @author alfar
 */
public class Caja {
    
    private int numeroCaja;
    private char tipoCaja; 
    private Tiquete tiqueteActual;

    public Caja(int numeroCaja, char tipoCaja) {
        this.numeroCaja = numeroCaja;
        this.tipoCaja = tipoCaja;
        this.tiqueteActual = null;
    }

    public Caja(int numeroCaja, char tipoCaja, Tiquete tiqueteActual) {
        this.numeroCaja = numeroCaja;
        this.tipoCaja = tipoCaja;
        this.tiqueteActual = tiqueteActual;
    }

    public int getNumeroCaja() {
        return numeroCaja;
    }

    public void setNumeroCaja(int numeroCaja) {
        this.numeroCaja = numeroCaja;
    }

    public char getTipoCaja() {
        return tipoCaja;
    }

    public void setTipoCaja(char tipoCaja) {
        this.tipoCaja = tipoCaja;
    }

    public Tiquete getTiqueteActual() {
        return tiqueteActual;
    }

    public void setTiqueteActual(Tiquete tiqueteActual) {
        this.tiqueteActual = tiqueteActual;
    }

    public boolean estaOcupada() {
        return tiqueteActual != null;
    }
    
}