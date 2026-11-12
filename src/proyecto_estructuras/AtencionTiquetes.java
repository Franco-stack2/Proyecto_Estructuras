package proyecto_estructuras;

import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class AtencionTiquetes {

    public static void tiqueteAtendido(Caja[] cajas, Cola colaPreferencial, Cola colaRapida, Cola colaNormal, Pila pilaReportes) {
        String cajaInput = JOptionPane.showInputDialog("Ingrese el número de caja que finaliza atención:");
        if (cajaInput == null) return;
        
        try {
            int numeroCaja = Integer.parseInt(cajaInput);
            if (numeroCaja < 1 || numeroCaja > cajas.length) {
                JOptionPane.showMessageDialog(null, "ERROR: El número de caja ingresado es incorrecto o no existe.");
                return;
            }

            Caja cajaActual = cajas[numeroCaja - 1];

            if (cajaActual.estaOcupada()) {
                Tiquete tiqueteTerminado = cajaActual.getTiqueteActual();
                
                String horaActual = LocalDateTime.now().toString();
                tiqueteTerminado.setHoraAtencion(horaActual);
                
                pilaReportes.agregar(tiqueteTerminado);
                
                JOptionPane.showMessageDialog(null, 
                                  "Atención finalizada con éxito para: " 
                                + tiqueteTerminado.getNombre() 
                                + "\nRegistrado en la pila de reportes.");
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
                
                String horaAtencionSiguiente = LocalDateTime.now().toString();
                siguienteCliente.setHoraAtencion(horaAtencionSiguiente);
                cajaActual.setTiqueteActual(siguienteCliente);
                
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