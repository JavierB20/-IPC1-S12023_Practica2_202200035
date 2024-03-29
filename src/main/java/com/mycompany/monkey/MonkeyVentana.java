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
import javax.swing.OverlayLayout;


/**
 *
 * @author Javier
 */
public class MonkeyVentana extends JPanel{
    //Label para manejar el tiempo
    private JLabel lbTiempo;
    private JLabel lbTitulo;
    private JLabel lbInventario, lbProduccion, lbEmpaquetado, lbSalida;
    private JButton btnRegresar, btnReporte;
    private JLabel lbTituloInicio,lbTituloInventario, lbTituloProduccion, lbTituloEmpaquetado, lbTituloSalida, lbTituloFinal;
    private JLabel lbCirculo1,lbCirculo2,lbCirculo3,lbCirculo4,lbCirculo5,
            lbCirculo6,lbCirculo7,lbCirculo8,lbCirculo9,lbCirculo10, lbCirculo11,lbCirculo12,lbCirculo13,lbCirculo14,lbCirculo15,
            lbCirculo16,lbCirculo17,lbCirculo18,lbCirculo19;
    
    
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
        
        

        
        //Declarando Contador de inicio
        lbTituloInicio = new JLabel("Inicio: 30");
        lbTituloInicio.setBounds(725,290,100,50);
        this.add(lbTituloInicio);
        
        //Declarando chibolas para inicio
        lbCirculo1 = new JLabel();
        lbCirculo1.setBounds(725,325,35,35);
        lbCirculo1.setBackground(Color.yellow);
        lbCirculo1.setOpaque(true);
        this.add(lbCirculo1);
        
        
        

        //Declarando Titulo contador inventario
        lbTituloInventario = new JLabel("Inventario: 0");
        lbTituloInventario.setBounds(470,390,100,100);
        this.add(lbTituloInventario);
        //Declarando chibolas para inventario
        lbCirculo2 = new JLabel();
        lbCirculo2.setBounds(470,500,35,35);
        lbCirculo2.setBackground(Color.CYAN);
        lbCirculo2.setOpaque(true);
        this.add(lbCirculo2);
        
        lbCirculo3 = new JLabel();
        lbCirculo3.setBounds(515,500,35,35);
        lbCirculo3.setBackground(Color.CYAN);
        lbCirculo3.setOpaque(true);
        this.add(lbCirculo3);
        
        lbCirculo4 = new JLabel();
        lbCirculo4.setBounds(560,500,35,35);
        lbCirculo4.setBackground(Color.CYAN);
        lbCirculo4.setOpaque(true);
        this.add(lbCirculo4);
        
        lbCirculo5 = new JLabel();
        lbCirculo5.setBounds(605,500,35,35);
        lbCirculo5.setBackground(Color.CYAN);
        lbCirculo5.setOpaque(true);
        this.add(lbCirculo5);
        
        lbCirculo6 = new JLabel();
        lbCirculo6.setBounds(650,420,35,35);
        lbCirculo6.setBackground(Color.CYAN);
        lbCirculo6.setOpaque(true);
        this.add(lbCirculo6);
                //Declarando Estaciones de simulacion Inventario
        lbInventario = new JLabel();
        lbInventario.setBounds(450,390,250,200);
        lbInventario.setForeground(Color.blue);
        lbInventario.setOpaque(true);
        this.add(lbInventario);
        
        
        
        //Declarando Chibola intermedia
        lbCirculo7 = new JLabel();
        lbCirculo7.setBounds(560,335,35,35);
        lbCirculo7.setBackground(Color.CYAN);
        lbCirculo7.setOpaque(true);
        this.add(lbCirculo7);
        
        

        //Declarando Titulo contador inventario
        lbTituloProduccion = new JLabel("Producción: 0");
        lbTituloProduccion.setBounds(490,110,100,50);
        this.add(lbTituloProduccion);
        //Declarando chibolas para inventario
        lbCirculo8 = new JLabel();
        lbCirculo8.setBounds(470,200,35,35);
        lbCirculo8.setBackground(Color.gray);
        lbCirculo8.setOpaque(true);
        this.add(lbCirculo8);
        
        lbCirculo9 = new JLabel();
        lbCirculo9.setBounds(515,200,35,35);
        lbCirculo9.setBackground(Color.gray);
        lbCirculo9.setOpaque(true);
        this.add(lbCirculo9);
        //Declarando Estaciones de simulacion Produccion
        lbProduccion = new JLabel();
        lbProduccion.setBounds(450,100,250,200);
        lbProduccion.setBackground(new Color(0, 0, 0, 127)); 
        lbProduccion.setBackground(Color.green);
        lbProduccion.setOpaque(true);
        this.add(lbProduccion);        
        

        //Declarando chibola intermedia
        lbCirculo10 = new JLabel();
        lbCirculo10.setBounds(390,200,35,35);
        lbCirculo10.setBackground(Color.GREEN);
        lbCirculo10.setOpaque(true);
        this.add(lbCirculo10);

        
        
        //Declarando Titulo de empaquetado
        lbEmpaquetado = new JLabel("Empaquetado: 0");
        lbEmpaquetado.setBounds(150,120,100,100);
        this.add(lbEmpaquetado);
        //Declarando chibolas de empaquetado
        lbCirculo11 = new JLabel();
        lbCirculo11.setBounds(300,200,35,35);
        lbCirculo11.setBackground(Color.PINK);
        lbCirculo11.setOpaque(true);
        this.add(lbCirculo11);
        
        lbCirculo12 = new JLabel();
        lbCirculo12.setBounds(255,200,35,35);
        lbCirculo12.setBackground(Color.PINK);
        lbCirculo12.setOpaque(true);
        this.add(lbCirculo12);
                
        lbCirculo13 = new JLabel();
        lbCirculo13.setBounds(210,200,35,35);
        lbCirculo13.setBackground(Color.PINK);
        lbCirculo13.setOpaque(true);
        this.add(lbCirculo13);
        //Declarando Estaciones de simulacion Empaquetado
        lbEmpaquetado = new JLabel();
        lbEmpaquetado.setBounds(110,110,250,200);
        lbEmpaquetado.setBackground(Color.MAGENTA);
        lbEmpaquetado.setOpaque(true);
        this.add(lbEmpaquetado);
        
        //Declarando chibola intermedia
        lbCirculo14 = new JLabel();
        lbCirculo14.setBounds(210,320,35,35);
        lbCirculo14.setBackground(Color.PINK);
        lbCirculo14.setOpaque(true);
        this.add(lbCirculo14);
        
        //Declarando Titulo de Salida
        lbTituloSalida = new JLabel("Salida: 0");
        lbTituloSalida.setBounds(150,420,100,100);
        this.add(lbTituloSalida);
        //Declarando chibolas de Salida
        lbCirculo15 = new JLabel();
        lbCirculo15.setBounds(300,500,35,35);
        lbCirculo15.setBackground(Color.red);
        lbCirculo15.setOpaque(true);
        this.add(lbCirculo15);
                
        lbCirculo16 = new JLabel();
        lbCirculo16.setBounds(255,500,35,35);
        lbCirculo16.setBackground(Color.red);
        lbCirculo16.setOpaque(true);
        this.add(lbCirculo16);
                        
        lbCirculo17 = new JLabel();
        lbCirculo17.setBounds(210,500,35,35);
        lbCirculo17.setBackground(Color.red);
        lbCirculo17.setOpaque(true);
        this.add(lbCirculo17);
                        
        lbCirculo18 = new JLabel();
        lbCirculo18.setBounds(165,500,35,35);
        lbCirculo18.setBackground(Color.red);
        lbCirculo18.setOpaque(true);
        this.add(lbCirculo18);
        //Declarando Estaciones de simulacion Salida
        lbSalida = new JLabel();
        lbSalida.setBounds(100,390,250,200);
        lbSalida.setBackground(Color.orange);
        lbSalida.setOpaque(true);
        this.add(lbSalida);
        
        //Declarando Titulo de Salida
        lbTituloSalida = new JLabel("Fin: 0");
        lbTituloSalida.setBounds(50,290,100,100);
        this.add(lbTituloSalida);
        //Declarando chibola de salida
        lbCirculo18 = new JLabel();
        lbCirculo18.setBounds(50,325,35,35);
        lbCirculo18.setBackground(Color.red);
        lbCirculo18.setOpaque(true);
        this.add(lbCirculo18);
        
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
//                Monkey monkey = new Monkey();
//                (monkey.ventana).setVisible(false);
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
        
//        btnReporte.setEnabled(false);
//        btnRegresar.setEnabled(false);
//        
        
                //Agregando hilos de simulacion
        HilosMateriaPrima hilosMateriaPrima = new HilosMateriaPrima(lbTituloInicio, lbTituloInventario);
        
        HilosMateriaPrima2 hilosMateriaPrima2 = new HilosMateriaPrima2(lbTituloProduccion);
        
        HilosMateriaPrima3 hilosMateriaPrima3 = new HilosMateriaPrima3(lbTituloEmpaquetado);
        
        HilosMateriaPrima4 hilosMateriaPrima4 = new HilosMateriaPrima4(lbTituloSalida, lbTituloFinal, btnReporte, btnRegresar, lbTiempo);

        hilosMateriaPrima.start();
        hilosMateriaPrima2.start();
        hilosMateriaPrima3.start();
        hilosMateriaPrima4.start();

    }
    
}
 