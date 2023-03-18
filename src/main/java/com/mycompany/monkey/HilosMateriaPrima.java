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
    
    private JLabel lbTituloInicio, lbTituloInventario;
    
    LinkedList<String> hilosInicio = new LinkedList<String>();
    LinkedList<String> hilosInventario = new LinkedList<String>();
    private String primeroInicio, primeroInventario;
    
    private boolean inicio = true;
    
    public HilosMateriaPrima(JLabel lbTituloInicio, JLabel lbTituloInventario){
        this.lbTituloInicio = lbTituloInicio;
        this.lbTituloInventario = lbTituloInventario;
    }
      
    @Override
    public void run() {
        
 
        
        for (int i = 0; i < 10; i++) {
            hilosInicio.add("hilo" + (i +1));
        }
        
        while(inicio) {
                    try {
            sleep(VaraiblesGlobales.tiempoInventario * 1000);
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
                            VaraiblesGlobales.hilosIntermedio1.add(primeroInventario);
                            lbTituloInventario.setText("Inventario: " + hilosInventario.size());
//                            System.out.println("Hilo Inventario" + hilosInventario);
//                            System.out.println("Hilo intermedio1" + hilosIntermedio1);
                        }
                    }
                }
            }
            else if (!hilosInventario.isEmpty() && hilosInicio.isEmpty()){
                primeroInventario = hilosInventario.get(0);  
                hilosInventario.removeFirst();
                VaraiblesGlobales.hilosIntermedio1.add(primeroInventario);
                lbTituloInventario.setText("Inventario: " + hilosInventario.size());
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
    

        
       
    
