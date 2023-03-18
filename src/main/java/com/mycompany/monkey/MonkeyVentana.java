/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monkey;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;


/**
 *
 * @author Javier
 */
public class MonkeyVentana extends JPanel{
    //Label para manejar el tiempo
    private JLabel lbTiempo;
    private JLabel lbTitulo;
    private JLabel lbPelota;
    private JLabel lbInventario, lbProduccion, lbEmpaquetado, lbSalida;
    private JButton btnRegresar, btnReporte;
    
    
    //Declarando constructor para inicializar los componentes
    public MonkeyVentana(){
        this.setLayout(null);
        this.setBackground(Color.white);
        this.setPreferredSize(new Dimension(800,600));
        this.setFocusable(true);
        
        lbTitulo = new JLabel("Tiempo Transcurrido");
        lbTitulo.setLocation(375, 5);
        lbTitulo.setSize(200,50);
        this.add(lbTitulo);
        
        lbTiempo = new JLabel("0:0");
        lbTiempo.setLocation(400, 15);
        lbTiempo.setSize(50,50);
        this.add(lbTiempo);
        //Pasar label a hilo tiempo
        HiloTiempo hiloTiempo = new HiloTiempo(lbTiempo);
        
        //Correr el hilo
        hiloTiempo.start();
        
        
        //Declarando Jlabel de la materia prima
        lbPelota = new JLabel();
        lbPelota.setBounds(250,250,20,20);
        lbPelota.setBackground(Color.red);
        lbPelota.setOpaque(true);
        this.add(lbPelota);
        
        
        //Declarando Estaciones de simulacion Inventario
        lbInventario = new JLabel();
        lbInventario.setBounds(450,390,250,200);
        lbInventario.setBackground(Color.blue);
        lbInventario.setOpaque(true);
        this.add(lbInventario);
        
        
        //Declarando Estaciones de simulacion Produccion
        lbProduccion = new JLabel();
        lbProduccion.setBounds(450,100,250,200);
        lbProduccion.setBackground(Color.green);
        lbProduccion.setOpaque(true);
        this.add(lbProduccion);
        
        
        //Declarando Estaciones de simulacion Salida
        lbSalida = new JLabel();
        lbSalida.setBounds(100,390,250,200);
        lbSalida.setBackground(Color.orange);
        lbSalida.setOpaque(true);
        this.add(lbSalida);
        
        
        //Declarando Estaciones de simulacion Empaquetado
        lbEmpaquetado = new JLabel();
        lbEmpaquetado.setBounds(100,100,250,200);
        lbEmpaquetado.setBackground(Color.MAGENTA);
        lbEmpaquetado.setOpaque(true);
        this.add(lbEmpaquetado);
        
        
        //Declarando botones
        btnRegresar = new JButton("Regresar");
        btnRegresar.setBounds(50,40,100,50);
        add(btnRegresar);
        
        btnReporte = new JButton("Reporte");
        btnReporte.setBounds(650,40,100,50);
        add(btnReporte);
        
        //Agregando funcionalidad a los botones
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MonkeyMenu ventana = new MonkeyMenu();
                ventana.setVisible(true);
                //this.setVisible(false);
            }
        });
        
        btnReporte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                int costoInventario = VaraiblesGlobales.tiempoInventario * VaraiblesGlobales.costoInventario * 30;
                String strCostoInventario = String.valueOf(costoInventario);
                int costoProduccion = VaraiblesGlobales.tiempoProduccion * VaraiblesGlobales.costoProduccion * 30;
                String strCostoProduccion = String.valueOf(costoProduccion);
                int costoEmpaquetado = VaraiblesGlobales.tiempoEmpaquetado * VaraiblesGlobales.costoEmpaquetado * 30;
                String strCostoEmpaquetado = String.valueOf(costoEmpaquetado);
                int costoSalida = VaraiblesGlobales.tiempoSalida * VaraiblesGlobales.costoSalida * 30;
                String strCostoSalida = String.valueOf(costoSalida);
                int total = costoInventario + costoProduccion + costoEmpaquetado + costoSalida;
                String strTotal = String.valueOf(total);

                String[][] filas = {{"Inventario",VaraiblesGlobales.strTiempoInventario , VaraiblesGlobales.strCostoInventario, strCostoInventario},
                    {"Producción", VaraiblesGlobales.strTiempoProduccion, VaraiblesGlobales.strCostoProduccion, strCostoProduccion}, 
                    {"Empaquetado", VaraiblesGlobales.strTiempoEmpaquetado, VaraiblesGlobales.strCostoEmpaquetado, strCostoEmpaquetado}, 
                    {"Salida",VaraiblesGlobales.strTiempoSalida , VaraiblesGlobales.strCostoSalida, strCostoSalida},
                    {"","" , "Total", strTotal}};

                String[] encbezados = {"Sector.", "Tiempo(s)", "Costo(Q/s)","Costo Total"};
                String tablaHtml = Restricciones.generatetablaHtml(encbezados, filas);

                // Crea la carpeta de reportes si no esiste
                File carpeta = new File("./reportes");
                if (!carpeta.exists()) {
                    carpeta.mkdirs();
                }

                // Escribe el archivo .html dentro de la carpeta
                try {
                    FileWriter fileWriter = new FileWriter("./reportes/reporteCosto.html");
                    fileWriter.write(tablaHtml);
                    fileWriter.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                
                
            }
        });
        
    }
    
}
 