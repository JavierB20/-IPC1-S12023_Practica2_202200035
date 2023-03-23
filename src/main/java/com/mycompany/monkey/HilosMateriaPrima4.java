/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monkey;

import static java.lang.Thread.sleep;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Javier
 */
public class HilosMateriaPrima4 extends Thread{
    
    private JLabel lbTituloSalida, lbTituloFinal;
    private JButton btnReporte, btnRegresar;
    
    LinkedList<String> hilosSalida = new LinkedList<String>();
    LinkedList<String> hilosFinal = new LinkedList<String>();
    private String primeroIntermedio, primeroSalida;
    
    private boolean inicio = true;
    
    public HilosMateriaPrima4(JLabel lbTituloSalida, JLabel lbTituloFinal, JButton btnRegresar, JButton btnReporte){
        this.lbTituloSalida = lbTituloSalida;
        this.lbTituloFinal = lbTituloFinal;
        this.btnRegresar = btnRegresar;
        this.btnReporte = btnReporte;
    }
      
    @Override
    public void run() {
        
        while(inicio) {
        try {
            sleep(VaraiblesGlobales.tiempoSalida * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(HilosMateriaPrima.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(hilosSalida.size() <= 4 && !VaraiblesGlobales.hilosIntermedio3.isEmpty()){
                if(VaraiblesGlobales.hilosIntermedio3.get(0) != null) {
                    if(!VaraiblesGlobales.hilosIntermedio3.isEmpty()) {
                        primeroIntermedio = VaraiblesGlobales.hilosIntermedio3.get(0);
                        VaraiblesGlobales.hilosIntermedio3.removeFirst();
                        hilosSalida.add(primeroIntermedio);
                        lbTituloSalida.setText("Salida: " + hilosSalida.size());
                        
                        if(hilosSalida.size() == 4 && !VaraiblesGlobales.hilosIntermedio3.isEmpty()) {
                            primeroSalida = hilosSalida.get(0);  
                            hilosSalida.removeFirst();
                            hilosFinal.add(primeroSalida);
                            lbTituloSalida.setText("Salida: " + hilosSalida.size());
                            lbTituloFinal.setText("Final: " + hilosFinal.size());
//                            System.out.println("Hilo Inventario" + hilosInventario);
//                            System.out.println("Hilo intermedio1" + hilosIntermedio1);
                        }
                    }
                }
            }
            else if (!hilosSalida.isEmpty() && VaraiblesGlobales.hilosIntermedio3.isEmpty()){
                primeroSalida = hilosSalida.get(0);  
                hilosSalida.removeFirst();
                hilosFinal.add(primeroSalida);
                lbTituloSalida.setText("Salida:  " + hilosSalida.size());
                lbTituloFinal.setText("Final:  " + hilosFinal.size());
//                System.out.println("Hilo Inventario2" + hilosInventario);
//                System.out.println("Hilo Intermedio2" + hilosIntermedio1);

            }
            else {
                //pasar botones de regreso y reporte con propiedad enabked
                btnReporte.setEnabled(true);
                btnRegresar.setEnabled(true);
                inicio = false;
                break;
            }

        }
    } 
}
    

        
       
    
