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

    
    public static void menuTiquetes(GestorBanco gb) {
        String res;
        do {
            res = JOptionPane.showInputDialog(" ******* Modulo de tiquetes*******\n"
                    + "1)Crear un tiquete\n2)Atender tiquete en caja\n0)Atras\n\n"
                    + "ingrese una opcion (0-2)");
            if (res == null) break;
            
            switch (res) {
                case "1":
 
                    gb.crearTiquete();
                    break;
                case "2":

                    JOptionPane.showMessageDialog(null, "En proceso");
                    break;
                case "0":
                    JOptionPane.showMessageDialog(null, "...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error opcion no valida");
            }
        } while (!res.equals("0"));
    }

  
    public static void menuReportes(Pila p) {
        String res;
        do {
            res = JOptionPane.showInputDialog(" ******* Modulo de Reportes *******\n"
                    + "1)Mostrar Historial\n2)En proceso\n3)En proceso\n0)Atras\n\n"
                    + "ingrese una opcion (0-3)");
            if (res == null) break;
            
            switch (res) {
                case "1":
      
                    JOptionPane.showMessageDialog(null, "En proceso");
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "En proceso");
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "En proceso");
                    break;
                case "0":
                    JOptionPane.showMessageDialog(null, "...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error opcion no valida");
            }
        } while (!res.equals("0"));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean sesion = iniciosesion.iniciarSesion();

        if (!sesion) {
            JOptionPane.showMessageDialog(
                    null,
                    "Complete los datos para iniciar sesion"
            );
            return;
        }
        
  
        GestorBanco gb = new GestorBanco();
        Pila p = new Pila();
        
   
        gb.inicializarBanco();

        String res;
        do {
            res = JOptionPane.showInputDialog(" ******* MENU *******\n"
                    + "1)Menu Tiquetes\n2)Reportes\n0)SALIR\n\n"
                    + "ingrese una opcion (0-2)");
            if (res == null) break;
            
            switch (res) {
                case "1":
              
                    menuTiquetes(gb);
                    break;
                case "2":
      
                    menuReportes(p);
                    break;
                case "0":
                    JOptionPane.showMessageDialog(null, "Cerrando el programa");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error opcion no valida");
            }
        } while (!res.equals("0"));
    }
}