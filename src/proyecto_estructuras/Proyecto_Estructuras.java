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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

 int opcion = 0;
        String menu = "=== MENÚ PRINCIPAL ===\n"
                    + "1. Módulo 1.1: Crear un tiquete"
                    + "2. Módulo 1.3: Asignar / Procesar siguiente en col"
                    + "3. Módulo 1.4: Ver reportes y estadísticas"
                    + "4. Ver estado actual de las colas (Cajas)"
                    + "5. Salir"
                    + "Seleccione una opción:";

        do {
            String input = JOptionPane.showInputDialog(null, menu, "Proyecto Estructuras de Datos - SC-304", JOptionPane.QUESTION_MESSAGE);
            
            if (input == null) {
                JOptionPane.showMessageDialog(null, "Operación cancelada");
                break;
            }

            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    // crecion de los tiquetes
                  
                    break;
                case 2:
                    // atencion y avance de las cajas
              
                    break;
                case 3:
                    // modulo de reportes
                  
                    break;
                case 4:
                    // ver estado
                  
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción fuera de rango (1-5).");
                    break;
            }

        } while (opcion != 5);
    }
}
