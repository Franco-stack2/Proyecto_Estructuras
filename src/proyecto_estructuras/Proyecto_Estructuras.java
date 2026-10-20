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

    public static void menuTiquetes(Cola c) {
        String res;
        do {
            res = JOptionPane.showInputDialog(" ******* Modulo de tiquetes*******\n"
                    + "1)Crear un tiquete\n2)Posición en la fila\n0)Atras\n\n"
                    + "ingrese una opcion (0-3)");
            switch (res) {
                case "1":
                    JOptionPane.showMessageDialog(null,
                            "En proceso");
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null,
                            "En proceso");

                    break;
                case "0":
                    JOptionPane.showMessageDialog(null,
                            "...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,
                            "Error opcion no valida");
            }
        } while (!res.equals("0"));
    }

    public static void menuReportes(Pila p) {
        String res;
        do {
            res = JOptionPane.showInputDialog(" ******* Modulo de Reportes *******\n"
                    + "1)Apilar\n2)Mostrar\n3)EliminarPares\n0)Atras\n\n"
                    + "ingrese una opcion (0-3)");
            switch (res) {
                case "1":
                    JOptionPane.showMessageDialog(null,
                            "En proceso");
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null,
                            "En proceso");

                    break;
                case "3":
                    JOptionPane.showMessageDialog(null,
                            "En proceso");

                    break;
                case "0":
                    JOptionPane.showMessageDialog(null,
                            "...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,
                            "Error opcion no valida");
            }
        } while (!res.equals("0"));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean sesion = iniciosesion.iniciarSesion();

        if (!sesion) {
            JOptionPane.showMessageDialog(
                    null,
                    "Complete los datos para iniciar sesion"
            );
            return;
        }
        Cola c = new Cola();
        Pila p = new Pila();
        String res;

        do {
            res = JOptionPane.showInputDialog(" ******* MENU *******\n"
                    + "1)Menu Tiquetes\n2)Reportes\n0)SALIR\n\n"
                    + "ingrese una opcion (0-3)");
            switch (res) {
                case "1":
                    menuTiquetes(c);
                    break;
                case "2":
                    menuReportes(p);
                    break;
                case "0":
                    JOptionPane.showMessageDialog(null,
                            "Cerrando el programa");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,
                            "Error opcion no valida");
            }
        } while (!res.equals("0"));

    }

}
