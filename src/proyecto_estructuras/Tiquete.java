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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getHoraCreacion() {
        return horaCreacion;
    }

    public String getHoraAtencion() {
        return horaAtencion;
    }

    public void setHoraAtencion(String horaAtencion) {
        this.horaAtencion = horaAtencion;
    }

    public String getTramite() {
        return tramite;
    }

    public void setTramite(String tramite) {
        this.tramite = tramite;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Tiquete{" + "numero=" + numero + ", nombre=" + nombre + ", id=" + id + ", edad=" + edad + ", horaCreacion=" + horaCreacion + ", horaAtencion=" + horaAtencion + ", tramite=" + tramite + ", tipo=" + tipo + '}';
    }
}