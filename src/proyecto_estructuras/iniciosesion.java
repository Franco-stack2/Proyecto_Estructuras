/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuras;

import javax.swing.JOptionPane;

/**
 *
 * @author alfar
 */
public class iniciosesion {

    public static boolean iniciarSesion() {
        String usuario = JOptionPane.showInputDialog(null, "Ingrese su usuario:");

        if (usuario == null || usuario.trim().isEmpty()) {
            return false;
        }

        String clave = JOptionPane.showInputDialog(null, "Ingrese su contraseña:");

        if (clave == null || clave.isEmpty()) {
            return false;
        }

        JOptionPane.showMessageDialog( null, "-----INICIO DE SESIÓN EXITOSO-----\n"
                +"\n"
                + "Bienvenid@, " + usuario 
        );
        return true;
    }
}
