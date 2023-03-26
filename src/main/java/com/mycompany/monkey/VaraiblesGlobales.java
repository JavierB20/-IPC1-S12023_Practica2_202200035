/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monkey;

import java.util.LinkedList;

/**
 *
 * @author Javier
 */
public class VaraiblesGlobales {
    
    public static int tiempoInventario;
    public static int costoInventario;
    public static int tiempoProduccion;
    public static int costoProduccion;
    public static int tiempoEmpaquetado;
    public static int costoEmpaquetado;
    public static int tiempoSalida;
    public static int costoSalida;
    
    public static String strTiempoInventario;
    public static String strCostoInventario;
    public static String strTiempoProduccion;
    public static String strCostoProduccion;
    public static String strTiempoEmpaquetado;
    public static String strCostoEmpaquetado;
    public static String strTiempoSalida;
    public static String strCostoSalida;
    
    public static boolean iniciar;
    
    public static int inicio;
    public static int inventario;
    public static int produccion;
    public static int empaquetado;
    public static int salida;
    public static int fin;
    
    public static int materiaPrima = 30;
    
    public static LinkedList<String> hilosInventario = new LinkedList<String>();
    public static LinkedList<String> hilosProduccion = new LinkedList<String>();
    public static LinkedList<String> hilosEmpaquetado = new LinkedList<String>();
    public static LinkedList<String> hilosSalida = new LinkedList<String>();

    
    public static LinkedList<String> hilosIntermedio1 = new LinkedList<String>();
    public static LinkedList<String> hilosIntermedio2 = new LinkedList<String>();
    public static LinkedList<String> hilosIntermedio3 = new LinkedList<String>();


    
}
