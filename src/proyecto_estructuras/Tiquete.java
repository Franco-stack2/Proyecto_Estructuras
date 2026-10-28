/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuras;

/**
 *
 * @author alfar
 */
public class Tiquete {

    private int numero;
    private String nombre;
    private String id;
    private int edad;
    private String horaCreacion;
    private String horaAtencion;
    private String tramite;
    private char tipo;

    // Constructor que inicializa todos los atributos del tiquete
    public Tiquete(int numero, String nombre, String id, int edad, String horaCreacion, String horaAtencion, String tramite, char tipo) {
        this.numero = numero;
        this.nombre = nombre;
        this.id = id;
        this.edad = edad;
        this.horaCreacion = horaCreacion;
        this.horaAtencion = horaAtencion;
        this.tramite = tramite;
        this.tipo = tipo;
    }

    // Retorna el número del tiquete
    public int getNumero() {
        return numero;
    }

    // Modifica o establece el número del tiquete
    public void setNumero(int numero) {
        this.numero = numero;
    }

    // Retorna el nombre del cliente
    public String getNombre() {
        return nombre;
    }

    // Modifica o establece el nombre del cliente
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Retorna la identificación del cliente
    public String getId() {
        return id;
    }

    // Modifica o establece la identificación del cliente
    public void setId(String id) {
        this.id = id;
    }

    // Retorna la edad del cliente
    public int getEdad() {
        return edad;
    }

    // Modifica o establece la edad del cliente
    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Retorna la hora en que se creó el tiquete
    public String getHoraCreacion() {
        return horaCreacion;
    }

    // Retorna la hora en que fue atendido el tiquete
    public String getHoraAtencion() {
        return horaAtencion;
    }

    // Modifica o establece la hora de atención del tiquete
    public void setHoraAtencion(String horaAtencion) {
        this.horaAtencion = horaAtencion;
    }

    // Retorna el trámite solicitado
    public String getTramite() {
        return tramite;
    }

    // Modifica o establece el trámite solicitado
    public void setTramite(String tramite) {
        this.tramite = tramite;
    }

    // Retorna el tipo de tiquete (P, A, B)
    public char getTipo() {
        return tipo;
    }

    // Modifica o establece el tipo de tiquete
    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    // Devuelve una representación en formato de texto de todos los datos del tiquete
    @Override
    public String toString() {
        return "Tiquete{" + "numero=" + numero + ", nombre=" + nombre + ", id=" + id + ", edad=" + edad + ", horaCreacion=" + horaCreacion + ", horaAtencion=" + horaAtencion + ", tramite=" + tramite + ", tipo=" + tipo + '}';
    }
}