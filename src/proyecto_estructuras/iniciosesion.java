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

    // Método estático para gestionar el inicio de sesión del usuario
    public static boolean iniciarSesion() {
        // Solicita al usuario ingresar su nombre de usuario
        String usuario = JOptionPane.showInputDialog(null, "Ingrese su usuario:");
        // Solicita al usuario ingresar su contraseña
        String contraseña = JOptionPane.showInputDialog(null, "Ingrese su contraseña:");
        
        // Valida si el campo de usuario está vacío o se canceló
        if (usuario == null || usuario.trim().isEmpty()) {
            return false;
        }
        // Valida si el campo de contraseña está vacío o se canceló
        if (contraseña == null || contraseña.isEmpty()) {
            return false;
        }
        
        // Muestra un mensaje de bienvenida si el inicio de sesión es exitoso
        JOptionPane.showMessageDialog( null, "====INICIO DE SESIÓN EXITOSO====\n"
                +"\n"
                + "Bienvenid@, " + usuario 
        );
        return true;
    }
}