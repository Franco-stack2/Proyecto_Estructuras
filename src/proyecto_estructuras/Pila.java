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
   
    // Verifica si la pila se encuentra vacía
    public boolean esVacia() {
        return top == null;
    }


    // Agrega un nuevo tiquete en la parte superior (cima) de la pila
    public void agregar(Tiquete t) {
        Nodo nuevo = new Nodo(t);
        if (esVacia()) {
            top = nuevo;
        } else {
            nuevo.setSig(top);
            top = nuevo;
        }
    }


    // Elimina el elemento que se encuentra en la cima de la pila (desapilar)
    public void desapilar() {
        if (!esVacia()) {
            top = top.getSig();
        } else {
            JOptionPane.showMessageDialog(null, "Advertencia: "
                    + "la pila es vacia");
        }
    }


    // Retorna el tiquete que está en la cima sin eliminarlo
    public Tiquete cima() {
        if (!esVacia()) {
            return top.getDato();
        } else {
            return null;
        }
    }

 
    // Retorna una representación en texto de todos los elementos contenidos en la pila
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

 
    // Verifica si existe un tiquete en la pila buscando por su número
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

 
    // Cuenta cuántos tiquetes pertenecen a un nombre de cliente específico y muestra el resultado
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

    
    // Busca y elimina un tiquete específico de la pila según su número
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