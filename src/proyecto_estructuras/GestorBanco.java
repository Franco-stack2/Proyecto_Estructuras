/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuras;

/**
 *
 * @author Usuario
 */
import java.io.*;
import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GestorBanco {
    private Cola colaPreferencial = new Cola();
    private Cola colaRapida = new Cola();
    private Cola colaNormal = new Cola();
    private Caja[] cajas;
    private String nombreBanco;
    private int contadorTiquetes = 1; // Consecutivo para los tiquetes

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public GestorBanco() {
        
    }
    
    

    // Verifica si el archivo de configuración del banco ya existe
    public boolean verificarConfiguracionExistente() {
        File archivo = new File("prod.txt");
        return archivo.exists();
    }

    // Guarda la configuración del banco en el archivo prod.txt
    public void guardarConfiguracionArchivo() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("prod.txt"))) {
            writer.println(nombreBanco);  
            writer.println(cajas.length);  
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error en el archivo " + e.getMessage());
        }
    }

    // Carga la configuración del banco desde el archivo prod.txt
    public void cargarConfiguracionArchivo() {
        try (BufferedReader br = new BufferedReader(new FileReader("prod.txt"))) {
            this.nombreBanco = br.readLine();            
            int cantidadCajas = Integer.parseInt(br.readLine());  
            
            this.cajas = new Caja[cantidadCajas];
            cajas[0] = new Caja(1, 'P');
            if (cantidadCajas > 1) {
                cajas[1] = new Caja(2, 'A');
            }
            for (int i = 2; i < cantidadCajas; i++) {
                cajas[i] = new Caja(i + 1, 'B'); // cajas noramles
            }
        } catch (IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar la base de datos " + e.getMessage());
        }
    }

   // seccion de carga de archivo 
    
    // Inicializa el banco pidiendo datos si no existe configuración o cargándolos si ya existe
    public void inicializarBanco() {
        if (!verificarConfiguracionExistente()) {
            JOptionPane.showMessageDialog(null, 
                "--- configuracion del banco ---\n" +
                "Esto solo se ejecuta la primera vez en el programa nada mas.");
            
            String nombreInput = JOptionPane.showInputDialog("Ingrese el nombre del banco:");
            String cajasInput = JOptionPane.showInputDialog("Ingrese la cantidad de cajas (mínimo 3):");
            
            try {
                int cantCajas = Integer.parseInt(cajasInput);
                if (cantCajas < 3) {
                    cantCajas = 3;
                    JOptionPane.showMessageDialog(null, "La cantidad de cajas minimas son 3, configurando al minimo");
                }
                
                this.nombreBanco = nombreInput;
                this.cajas = new Caja[cantCajas];

                cajas[0] = new Caja(1, 'P');
                if (cantCajas > 1) {
                    cajas[1] = new Caja(2, 'A');
                }
                for (int i = 2; i < cantCajas; i++) {
                    cajas[i] = new Caja(i + 1, 'B'); // caja normal estas si pueden ser varias
                }

                guardarConfiguracionArchivo();
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Formato numérico incorrecto. Configurando 3 cajas por defecto.");
                this.nombreBanco = nombreInput;
                this.cajas = new Caja[3];
                cajas[0] = new Caja(1, 'P');
                cajas[1] = new Caja(2, 'A');
                cajas[2] = new Caja(3, 'B');
                guardarConfiguracionArchivo();
            }
        } else {
            cargarConfiguracionArchivo();
            
            int cantCajas = cajas.length; // lo llamo otra vez para que imprima las cajas
            
            
            JOptionPane.showMessageDialog(null, "Configuración cargada desde prod.txt\nBanco: " + getNombreBanco()+ "\n"
                    + "cantidad de cajas"+  cantCajas);
        }
    }

  
    // Crea un nuevo tiquete solicitando los datos al cliente y lo asigna a la cola correspondiente
    public void crearTiquete() {
        try {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
            if (nombre == null) return;
        
            String id = JOptionPane.showInputDialog("Ingrese la identificación:");
            if (id == null) return;
        
            String edadStr = JOptionPane.showInputDialog("Ingrese la edad:");
            if (edadStr == null) return;
           
            String tramite = JOptionPane.showInputDialog("Ingrese el trámite (Depósitos, Retiros, Cambio de Divisas):");
            if (tramite == null) return;
           
            String tipoStr = JOptionPane.showInputDialog("Ingrese el tipo (solo digite la letra) \n(P: Preferencial, A: Rápido/Un trámite, B: Normal/Dos o más trámites):");
            if (tipoStr == null) return;
            
            
            int edad = Integer.parseInt(edadStr);
            char tipo = tipoStr.trim().toUpperCase().charAt(0);
            if (tipo != 'P' && tipo != 'A' && tipo != 'B') {
                JOptionPane.showMessageDialog(null, "Tipo inválido solo digite las letras no el nombre completo. ");
                return;
            }
            
            int numeroTiquete = contadorTiquetes++; 
            String horaCreacion = LocalDateTime.now().format(formatter);
            
            Tiquete nuevoTiquete = new Tiquete(numeroTiquete, nombre, id, edad, horaCreacion, "-1", tramite, tipo);
            
            Cola colaDestino = obtenerColaPorTipo(tipo);
            colaDestino.agregar(nuevoTiquete);

            Caja cajaLibre = buscarCajaLibrePorTipo(tipo);

          
            if (cajaLibre != null && colaDestino.getTamanio() == 1) {
                colaDestino.desencolar();
                asignarClienteACaja(cajaLibre, nuevoTiquete);
                
                JOptionPane.showMessageDialog(null, 
                    "¡Esta libre pase adelante!\n" +
                    "Cliente: " + nuevoTiquete.getNombre() + "\n" +
                    "Por favor proceda directamente a la Caja #" + cajaLibre.getNumeroCaja());
            } else {
                int posicionActual = colaDestino.posicion(nuevoTiquete.getNumero());
                int personasAdelante = posicionActual;
                   // antes este metodo restaba pero porque el index empieza en 0 no es necesario hacer un -1
                
                
                int numCajaSeleccionada = obtenerNumeroCajaSeleccionada(tipo);

                JOptionPane.showMessageDialog(null,
                    "--- Espere ---\n" +
                    "Número de Tiquete: #" + nuevoTiquete.getNumero() + "\n" +
                    "Hora de Emisión: " + horaCreacion + "\n" +
                    "Caja de Atención: #" + numCajaSeleccionada + "\n" +
                    "Clientes por delante en fila: " + personasAdelante);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: El formato de los datos ingresados es incorrecto.");
        }
    }

   
   
    // Asigna un tiquete y registra la hora de atención en la caja indicada
    private void asignarClienteACaja(Caja caja, Tiquete tiquete) {
        String horaAtencion = LocalDateTime.now().format(formatter);
        tiquete.setHoraAtencion(horaAtencion);
        caja.setTiqueteActual(tiquete);
    }

  // Obtiene la cola correspondiente según el tipo de tiquete (P, A, B)
  private Cola obtenerColaPorTipo(char tipo) {
    if (tipo == 'P') {
        return colaPreferencial;
    } else if (tipo == 'A') {
        return colaRapida;
    } else {
        return colaNormal;
    }
}

    // Busca una caja libre que coincida con el tipo de tiquete esta logica es principalmente para las cajas B
    private Caja buscarCajaLibrePorTipo(char tipo) {
        for (Caja c : cajas) {
            if (c.getTipoCaja() == tipo && !c.estaOcupada()) {
                return c;
            }
        }
        return null;
    }

    // Obtiene el número de caja correspondiente a un tipo determinado
    private int obtenerNumeroCajaSeleccionada(char tipo) {
        for (Caja c : cajas) {
            if (c.getTipoCaja() == tipo) {
                return c.getNumeroCaja();
            }
        }
        return -1;
    }

    // Retorna el nombre asignado al banco
    public String getNombreBanco() {
        return nombreBanco;
    }
}