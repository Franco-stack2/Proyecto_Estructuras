/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuras;


import javax.swing.JOptionPane;

public class Cola {
    private Nodo prim, ult;
    
    public boolean esVacia(){
        return prim==null;
    }

//encolar
public void agregar(Tiquete t){
        Nodo nuevo=new Nodo(t);
        
        if(esVacia()){
            prim=ult=nuevo;
        }else{
            ult.setSig(nuevo);
            ult=nuevo;
        }
    }

//desencolar
public void desencolar(){

        if(!esVacia()){
            prim=prim.getSig();
            if(prim==null){
                ult=null;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Cola vacia");
        }
    }

//toString 
 @Override
    public String toString() {
        String r = "Cola de tiquetes:\n";
        Nodo aux = prim;
        while (aux != null) {
            r += aux.getDato() + "\n";
            aux = aux.getSig();
        }
        return r;
    }

    // Existe
    public boolean existe(int numero) {

        if (!esVacia()) {
            if (prim.getDato().getNumero() == numero ||
                    ult.getDato().getNumero() == numero) {
                return true;
            } else {
                Nodo aux = prim;
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
    
//posision 
   public int posicion(int numero) {
        int posicion = 1;
        Nodo aux = prim;

        while (aux != null) {
            if (aux.getDato().getNumero() == numero) {
                return posicion;
            }
            aux = aux.getSig();
            posicion++;
        }
        return -1;
    }
}