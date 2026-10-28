/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuras;

/**
 *
 * @author alfar
 */
public class Nodo {

    private Tiquete dato;
    private Nodo sig;

    // Constructor que inicializa el nodo con un tiquete
    public Nodo(Tiquete dato) {
        this.dato = dato;
    }

    // Retorna el tiquete almacenado en el nodo
    public Tiquete getDato() {
        return dato;
    }

    // Modifica o establece el tiquete almacenado en el nodo
    public void setDato(Tiquete dato) {
        this.dato = dato;
    }

    // Retorna el siguiente nodo enlazado
    public Nodo getSig() {
        return sig;
    }

    // Modifica o establece el siguiente nodo enlazado
    public void setSig(Nodo sig) {
        this.sig = sig;
    }

    // Retorna una representación en texto del nodo y su enlace
    @Override
    public String toString() {
        return "Nodo{" + "dato=" + dato + ", sig=" + sig + '}';
    }
}