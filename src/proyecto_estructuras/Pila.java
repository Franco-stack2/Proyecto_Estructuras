/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuras;

/**
 *
 * @author Usuario
 */
import javax.swing.JOptionPane;



public class Pila {

    private Nodo top;

    
    // esto se va a utilizar para el modulo de reportes
   
    public boolean esVacia() {
        return top == null;
    }


    public void agregar(Tiquete t) {
        Nodo nuevo = new Nodo(t);
        if (esVacia()) {
            top = nuevo;
        } else {
            nuevo.setSig(top);
            top = nuevo;
        }
    }


    public void desapilar() {
        if (!esVacia()) {
            top = top.getSig();
        } else {
            JOptionPane.showMessageDialog(null, "Advertencia: "
                    + "la pila es vacia");
        }
    }


    public Tiquete cima() {
        if (!esVacia()) {
            return top.getDato();
        } else {
            return null;
        }
    }

 
    @Override
    public String toString() {
        String r = "Pila de Reportes (Historial):\n";
        Nodo aux = top;
        while (aux != null) {
            r += aux.getDato() + "\n"; 
            aux = aux.getSig();
        }
        return r;
    }

 
    public boolean existe(int numero) {
        if (!esVacia()) {
            if (top.getDato().getNumero() == numero) {
                return true;
            } else {
                Nodo aux = top;
                while (aux != null) {
                    if (aux.getDato().getNumero() == numero) {
                        return true;
                    }
                    aux = aux.getSig();
                }
            }
        }
        return false;
    }

 
    public void contarNom(String nom) {
        int cont = 0;
        if (!esVacia()) {
            Nodo aux = top;
            while (aux != null) {
                if (aux.getDato().getNombre().equals(nom)) {
                    cont++;
                }
                aux = aux.getSig();
            }
        }
        JOptionPane.showMessageDialog(null, "Existen " + cont
                + " de tiquetes que le pertenecen a " + nom);
    }

    
    public void eliminar(int numero) {
        if (!esVacia()) {
            if (top.getDato().getNumero() == numero) {
                this.desapilar();
            } else {
                Nodo aux = top;
                while (aux.getSig() != null) {
                    if (aux.getSig().getDato().getNumero() == numero) {
                
                        aux.setSig(aux.getSig().getSig());
                        break;
                    }
                    aux = aux.getSig();
                }
            }
        }
    }
}