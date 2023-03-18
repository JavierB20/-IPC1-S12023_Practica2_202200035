/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monkey;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Javier
 */
public class HilosMateriaPrima extends Thread{
    
    private JLabel lbTituloInicio, lbTituloInventario, lbTituloProduccion;
    
    LinkedList<String> hilosInicio = new LinkedList<String>();
    LinkedList<String> hilosInventario = new LinkedList<String>();
    LinkedList<String> hilosIntermedio1 = new LinkedList<String>();
    LinkedList<String> hilosProduccion = new LinkedList<String>();
    LinkedList<String> hilosIntermedio2 = new LinkedList<String>();
    private int TiempoInventario, TiempoProduccion;
    private String primeroInicio, primeroInventario, primeroIntermedio1;
    
    private boolean inicio1 = true, inicio2 = true, inicio3 = true, inicio4 = true;
    
    
    public HilosMateriaPrima(int TiempoInventario, int TiempoProduccion) {
        this.TiempoInventario = TiempoInventario;
        this.TiempoProduccion = TiempoProduccion;

    }
    
    public HilosMateriaPrima(JLabel lbTituloInicio, JLabel lbTituloInventario, JLabel lbTituloProduccion){
        this.lbTituloInicio = lbTituloInicio;
        this.lbTituloInventario = lbTituloInventario;
        this.lbTituloProduccion = lbTituloProduccion;
    }
      
    @Override
    public void run() {
        
 
        
        for (int i = 0; i < 10; i++) {
            hilosInicio.add("hilo" + (i +1));
        }
        
        while(inicio1) {
                    try {
            sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(HilosMateriaPrima.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(hilosInventario.size() <= 5 && !hilosInicio.isEmpty()){
                if(hilosInicio.get(0) != null) {
                    if(!hilosInicio.isEmpty()) {
                        primeroInicio = hilosInicio.get(0);
                        hilosInicio.removeFirst();
                        hilosInventario.add(primeroInicio);
                        lbTituloInicio.setText("Inicio: " + hilosInicio.size());
                        lbTituloInventario.setText("Inventario: " + hilosInventario.size());
                        
                        if(hilosInventario.size() == 5 && !hilosInicio.isEmpty()) {
                            primeroInventario = hilosInventario.get(0);  
                            hilosInventario.removeFirst();
                            hilosIntermedio1.add(primeroInventario);
                            lbTituloInventario.setText("Inventario: " + hilosInventario.size());
                            System.out.println("Hilo Inventario" + hilosInventario);
                            System.out.println("Hilo intermedio1" + hilosIntermedio1);
                        }
                    }
                }
            }
            else if (!hilosInventario.isEmpty() && hilosInicio.isEmpty()){
                primeroInventario = hilosInventario.get(0);  
                hilosInventario.removeFirst();
                hilosIntermedio1.add(primeroInventario);
                lbTituloInventario.setText("Inventario: " + hilosInventario.size());
                System.out.println("Hilo Inventario2" + hilosInventario);
                System.out.println("Hilo Intermedio2" + hilosIntermedio1);

            }
            else {
                inicio1 = false;
                break;
            }

        }
    }
    
    
    
}
    

        
       
    
