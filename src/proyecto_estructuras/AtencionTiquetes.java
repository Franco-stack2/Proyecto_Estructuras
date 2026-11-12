package proyecto_estructuras;

import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class AtencionTiquetes {

   

    
  
    
    public static void tiqueteAtendido(GestorBanco gestorActual) {
        
        Caja[] cajas = gestorActual.getCajas();
        Cola colaPreferencial = gestorActual.getColaPreferencial();
        Cola colaRapida = gestorActual.getColaRapida();
        Cola colaNormal = gestorActual.getColaNormal();
   
        
        String cajaInput = JOptionPane.showInputDialog("Ingrese el número de caja que finaliza atención:");
        if (cajaInput == "") return;
        
        try {
            int numeroCaja = Integer.parseInt(cajaInput);
            if (numeroCaja < 1 || numeroCaja > cajas.length) {
                JOptionPane.showMessageDialog(null, "ERROR: El número de caja ingresado es incorrecto o no existe.");
                return;
            }

            Caja cajaActual = cajas[numeroCaja - 1];

            if (cajaActual.estaOcupada()) {
                Tiquete tiqueteTerminado = cajaActual.getTiqueteActual();
                
              
                
                JOptionPane.showMessageDialog(null, 
                                  "Atención finalizada con éxito para: " 
                                + tiqueteTerminado.getNombre() );
                cajaActual.setTiqueteActual(null);
            }
            

            Cola colaAsociada = null;
            char tipoCaja = cajaActual.getTipoCaja();
            
            if (tipoCaja == 'P') {
                colaAsociada = colaPreferencial;
            } else if (tipoCaja == 'A') {
                colaAsociada = colaRapida;
            } else {
                colaAsociada = colaNormal;
            }
            
            
            if (!colaAsociada.esVacia()) {
                Tiquete siguienteCliente = colaAsociada.desencolar();
                
                 gestorActual.asignarClienteACaja(cajaActual, siguienteCliente);
                
                JOptionPane.showMessageDialog(null, 
                    "Siguiente cliente llamado...\n" +
                    "Caja #" + numeroCaja + " ahora atiende a: " + siguienteCliente.getNombre());
            } else {
                JOptionPane.showMessageDialog(null, "La Caja #" + numeroCaja + " se encuentra ahora libre y en espera.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ERROR: Debe ingresar un valor numérico válido para la caja.");
        }
    }
}