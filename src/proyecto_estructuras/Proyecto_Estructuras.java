/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_estructuras;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Proyecto_Estructuras {

  
 
     public static void menuRec(){
       String res;
        do{
            res=JOptionPane.showInputDialog(" ******* Modulo Recursion *******\n"
                    + "1)Promedio\n2)Pares e Impares\n0)Atras\n\n"
                    + "ingrese una opcion (0-3)");
            switch(res){
                case "1":
                  
                    break;
                case "2":
           
                    
                    break;
                case "0":
                    JOptionPane.showMessageDialog(null, 
                            "...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, 
                            "Error opcion no valida");
            }
        }while(!res.equals("0"));
    }
    
    
    public static void menuCola(Cola c){
        String res;
        do{
            res=JOptionPane.showInputDialog(" ******* Modulo Colas *******\n"
                    + "1)Encolar\n2)Mostrar\n3)De mayor a menor\n0)Atras\n\n"
                    + "ingrese una opcion (0-3)");
            switch(res){
                case "1":
                 
              
                    break;
                case "2":
            
                    break;
                case "3":
                   
                
                    break;
                case "0":
                    JOptionPane.showMessageDialog(null, 
                            "...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, 
                            "Error opcion no valida");
            }
        }while(!res.equals("0"));
    }
    
    public static void menuPila(Pila p){
        String res;
        do{
            res=JOptionPane.showInputDialog(" ******* Modulo Pilas *******\n"
                    + "1)Apilar\n2)Mostrar\n3)EliminarPares\n0)Atras\n\n"
                    + "ingrese una opcion (0-3)");
            switch(res){
                case "1":

                
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, 
                            p);
                    break;
                case "3":
            
                    break;
                case "0":
                    JOptionPane.showMessageDialog(null, 
                            "...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, 
                            "Error opcion no valida");
            }
        }while(!res.equals("0"));
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cola c=new Cola();
        Pila p=new Pila();
        String res;
        
        do{
            res=JOptionPane.showInputDialog(" ******* MENU *******\n"
                    + "1)Recursion\n2)Pilas\n3)Colas\n0)SALIR\n\n"
                    + "ingrese una opcion (0-3)");
            switch(res){
                case "1":
                    menuRec();
                    break;
                case "2":
                    menuPila(p);
                    break;
                case "3":
                    menuCola(c);
                    break;
                case "0":
                    JOptionPane.showMessageDialog(null, 
                            "Cerrando el programa");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, 
                            "Error opcion no valida");
            }
        }while(!res.equals("0"));
        
        
        
        
    }
    
}

