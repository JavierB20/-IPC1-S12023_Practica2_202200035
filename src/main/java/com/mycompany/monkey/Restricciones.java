/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monkey;

/**
 *
 * @author Javier
 */
public class Restricciones {
    
    public static boolean soloNumeros(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }
    
    public static String generatetablaHtml(String[] encbezados, String[][] filas) {
        StringBuilder sb = new StringBuilder();

        sb.append("<h2>Reporte de costo total de la simulación</h2>\n");
        // Se abre etiqueta de inciio de la tabla
        sb.append("<table style=\"width: 25%; border: 1px solid black;\">\n");

        // Se agregan los encabezados de la tabla
        sb.append("<tr>");
        for (String encabezado : encbezados) {
            sb.append("<th style=\"border-bottom: 1px solid black;\"><strong>").append(encabezado).append("</strong></th>");
        }
        sb.append("</tr>\n");

        // Se agregan las fialas a la tabla
        for (String[] fila : filas) {
            sb.append("<tr>");
            for (String casilla : fila) {
                sb.append("<td style=\"padding: 10px; text-align: left;\">").append(casilla).append("</td>");
            }
            sb.append("</tr>\n");
        }

        // Se cierra la etiqueta d ela tabla
        sb.append("</table>\n");

        return sb.toString();
    }
    
}
