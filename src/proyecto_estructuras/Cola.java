/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuras;

import javax.swing.JOptionPane;

public class Cola {
  
    private Nodo prim, ult;
    
    
    public boolean esVacia() {
        return prim == null;
    }
    
  
    public void agregar(Tiquete t) {
        Nodo nuevo = new Nodo(t);
        
        if (esVacia()) {
            prim = ult = nuevo;   
        } else {
            ult.setSig(nuevo);
            ult = nuevo;
        }
    }
    
  
    public Tiquete desencolar() {
        if (!esVacia()) {
            Tiquete tiqueteExtraido = prim.getDato(); 
            prim = prim.getSig();
            if (prim == null) {
                ult = null;
            }
            return tiqueteExtraido; 
        } else {
            JOptionPane.showMessageDialog(null, "Cola vacia");
            return null;
        }
    }

 
    public void atiende(int numero) {
        if (!esVacia()) {
            if (prim.getDato().getNumero() == numero) {
                this.desencolar();
                return;
            }

            Nodo aux = prim;
            while (aux.getSig() != null) {
                if (aux.getSig().getDato().getNumero() == numero) {
                    aux.setSig(aux.getSig().getSig());
                    if (aux.getSig() == null) {
                        ult = aux; 
                    }
                    break;
                }
                aux = aux.getSig(); 
            }
        }
    }


    public int posicion(int numero) {
        int pos = 1;
        Nodo aux = prim;
        while (aux != null) {
            if (aux.getDato().getNumero() == numero) {
                return pos;
            }
            aux = aux.getSig();
            pos++;
        }
        return -1; 
    }

    
    public int getTamanio() {
        int contador = 0;
        Nodo aux = prim;
        while (aux != null) {
            contador++;
            aux = aux.getSig();
        }
        return contador;
    }
    
   
    @Override
    public String toString() {
        String r = "Cola de Tiquetes Bancarios: \n";
        Nodo aux = prim;
        while (aux != null) {
            if (aux == prim && aux == ult) {
                r += "Primero y ultimo: " + aux.getDato() + "\n";
            } else if (aux == prim) {
                r += "Primero: " + aux.getDato() + "\n";
            } else if (aux == ult) {
                r += "Ultimo: " + aux.getDato() + "\n";
            } else {
                r += aux.getDato() + "\n";
            }
            aux = aux.getSig();
        }
        return r;
    }
}