/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monkey;

import static java.lang.Thread.sleep;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Javier
 */
public class HilosMateriaPrima2 extends Thread{
    
    private JLabel lbTituloProduccion;
    
    LinkedList<String> hilosProduccion = new LinkedList<String>();
    private String primeroIntermedio, primeroProduccion;
    
    private boolean inicio = false;
    
    public HilosMateriaPrima2(JLabel lbTituloProduccion){
        this.lbTituloProduccion = lbTituloProduccion;
    }
      
    @Override
    public void run() {
        while(VaraiblesGlobales.hilosIntermedio1.isEmpty()) {
            if(!VaraiblesGlobales.hilosIntermedio1.isEmpty()) {
                inicio = true;
            }
        }
        
        
                while(inicio) {
                    try {
            sleep(VaraiblesGlobales.tiempoProduccion * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(HilosMateriaPrima.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(hilosProduccion.size() <= 2 && !VaraiblesGlobales.hilosIntermedio1.isEmpty()){
                if(VaraiblesGlobales.hilosIntermedio1.get(0) != null) {
                    if(!VaraiblesGlobales.hilosIntermedio1.isEmpty()) {
                        primeroIntermedio = VaraiblesGlobales.hilosIntermedio1.get(0);
                        VaraiblesGlobales.hilosIntermedio1.removeFirst();
                        hilosProduccion.add(primeroIntermedio);
                        lbTituloProduccion.setText("Producción: " + hilosProduccion.size());
                        
                        if(hilosProduccion.size() == 2 && !VaraiblesGlobales.hilosIntermedio1.isEmpty()) {
                            primeroProduccion = hilosProduccion.get(0);  
                            hilosProduccion.removeFirst();
                            VaraiblesGlobales.hilosIntermedio2.add(primeroProduccion);
                            lbTituloProduccion.setText("Producción: " + hilosProduccion.size());
//                            System.out.println("Hilo Inventario" + hilosInventario);
//                            System.out.println("Hilo intermedio1" + hilosIntermedio1);
                        }
                    }
                }
            }
            else if (!hilosProduccion.isEmpty() && VaraiblesGlobales.hilosIntermedio1.isEmpty()){
                primeroProduccion = hilosProduccion.get(0);  
                hilosProduccion.removeFirst();
                VaraiblesGlobales.hilosIntermedio1.add(primeroProduccion);
                lbTituloProduccion.setText("Producción:  " + hilosProduccion.size());
//                System.out.println("Hilo Inventario2" + hilosInventario);
//                System.out.println("Hilo Intermedio2" + hilosIntermedio1);

            }
            else {
                inicio = false;
                break;
            }

        }
    } 
}
    

        
       
    
