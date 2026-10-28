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

    // Constructor que inicializa la caja con su número y tipo, sin tiquete asignado
    public Caja(int numeroCaja, char tipoCaja) {
        this.numeroCaja = numeroCaja;
        this.tipoCaja = tipoCaja;
        this.tiqueteActual = null;
    }

    // Constructor que inicializa la caja con su número, su tipo y un tiquete actual asignado
    public Caja(int numeroCaja, char tipoCaja, Tiquete tiqueteActual) {
        this.numeroCaja = numeroCaja;
        this.tipoCaja = tipoCaja;
        this.tiqueteActual = tiqueteActual;
    }

    // Devuelve el número de la caja
    public int getNumeroCaja() {
        return numeroCaja;
    }

    // Modifica o establece el número de la caja
    public void setNumeroCaja(int numeroCaja) {
        this.numeroCaja = numeroCaja;
    }

    // Devuelve el tipo de caja
    public char getTipoCaja() {
        return tipoCaja;
    }

    // Modifica o establece el tipo de caja
    public void setTipoCaja(char tipoCaja) {
        this.tipoCaja = tipoCaja;
    }

    // Devuelve el tiquete que se está atendiendo actualmente en la caja
    public Tiquete getTiqueteActual() {
        return tiqueteActual;
    }

    // Modifica o asigna un tiquete a la caja
    public void setTiqueteActual(Tiquete tiqueteActual) {
        this.tiqueteActual = tiqueteActual;
    }

    // Verifica si la caja se encuentra ocupada por un tiquete
    public boolean estaOcupada() {
        return tiqueteActual != null;
    }
    
}