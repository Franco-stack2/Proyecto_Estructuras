/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuras;

/**
 *
 * @author alfar
 */
public class Usuario {
    
    private String user;
    private String password;

    // Constructor que inicializa el nombre de usuario y la contraseña
    public Usuario(String user, String password) {
        this.user = user;
        this.password = password;
    }

    // Retorna el nombre de usuario
    public String getUser() {
        return user;
    }

    // Modifica o establece el nombre de usuario
    public void setUser(String user) {
        this.user = user;
    }

    // Retorna la contraseña del usuario
    public String getPassword() {
        return password;
    }

    // Modifica o establece la contraseña del usuario
    public void setPassword(String password) {
        this.password = password;
    }

    // Retorna una representación en texto del objeto usuario
    @Override
    public String toString() {
        return "Usuario{user=" + user + "}";
    }
}

