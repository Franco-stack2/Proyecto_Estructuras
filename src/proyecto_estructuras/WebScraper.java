/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuras;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebScraper {

    public static void main(String[] args) {

        String url = "https://www.bgeneral.fi.cr/historico-2/"; //direccion de la página web

        try {
            Document documento = Jsoup.connect(url).get(); //conecta con la página web
            Elements filas = documento.select("table tr"); //busca las filas en la tabla

            System.out.println("=================================================="); //se muestra el titulo
            System.out.println("            Tipo de cambio del dolar");
            System.out.println("==================================================");

            for (Element fila : filas) { //obtiene las filas de la tabla 
                Elements celdas = fila.select("td"); //obtiene las celdas de las filas

                if (celdas.size() >= 3) { //comprobamos las 3 celdas que necesitamos
                    String fecha = celdas.get(0).text();
                    String compra = celdas.get(1).text();
                    String venta = celdas.get(2).text();

                    if (fecha.contains("/")) { //obtenemos la fecha del cambio del dola
                        double Compra = Double.parseDouble(compra.replace("₡", "").trim());//obtenemos los valores de compra y venta del dolar
                        double Venta = Double.parseDouble(venta.replace("₡", "").trim());//obtenemos los valores de compra y venta del dolar

                        //se muestran las fechas y los valores de compra y venta
                        System.out.println("Fecha: " + fecha
                                + " | Compra: " + Compra
                                + " | Venta: " + Venta);
                    }
                }
            }
            System.out.println("==================================================");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
