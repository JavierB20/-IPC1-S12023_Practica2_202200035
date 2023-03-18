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
public class HilosMateriaPrima3 extends Thread{
    
    private JLabel lbTituloEmpaquetado;
    
    LinkedList<String> hilosEmpaquetado = new LinkedList<String>();
    private String primeroIntermedio, primeroProduccion, primeroIntermedio2;
    
    private boolean inicio = true;
    
    public HilosMateriaPrima3(JLabel lbTituloEmpaquetado){
        this.lbTituloEmpaquetado = lbTituloEmpaquetado;
    }
      
    @Override
    public void run() {
        
        while(inicio) {
        try {
            sleep(VaraiblesGlobales.tiempoEmpaquetado * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(HilosMateriaPrima.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(hilosEmpaquetado.size() <= 3 && !VaraiblesGlobales.hilosIntermedio2.isEmpty()){
                if(VaraiblesGlobales.hilosIntermedio2.get(0) != null) {
                    if(!VaraiblesGlobales.hilosIntermedio2.isEmpty()) {
                        primeroIntermedio = VaraiblesGlobales.hilosIntermedio2.get(0);
                        VaraiblesGlobales.hilosIntermedio2.removeFirst();
                        hilosEmpaquetado.add(primeroIntermedio);
                        lbTituloEmpaquetado.setText("Empaquetado: " + hilosEmpaquetado.size());
                        
                        if(hilosEmpaquetado.size() == 3 && !VaraiblesGlobales.hilosIntermedio2.isEmpty()) {
                            primeroProduccion = hilosEmpaquetado.get(0);  
                            hilosEmpaquetado.removeFirst();
                            VaraiblesGlobales.hilosIntermedio3.add(primeroProduccion);
                            lbTituloEmpaquetado.setText("Empaquetado: " + hilosEmpaquetado.size());
//                            System.out.println("Hilo Inventario" + hilosInventario);
//                            System.out.println("Hilo intermedio1" + hilosIntermedio1);
                        }
                    }
                }
            }
            else if (!hilosEmpaquetado.isEmpty() && VaraiblesGlobales.hilosIntermedio2.isEmpty()){
                primeroProduccion = hilosEmpaquetado.get(0);  
                hilosEmpaquetado.removeFirst();
                VaraiblesGlobales.hilosIntermedio3.add(primeroProduccion);
                lbTituloEmpaquetado.setText("Producción:  " + hilosEmpaquetado.size());
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
    

        
       
    
