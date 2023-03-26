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
    private String primeroInicio, primeroInventario;
    
    private boolean inicio = true;
    
    public HilosMateriaPrima(JLabel lbTituloInicio, JLabel lbTituloInventario){
        this.lbTituloInicio = lbTituloInicio;
        this.lbTituloInventario = lbTituloInventario;
    }
      
    @Override
    public void run() {
        
 
        //Iniciara el hilo y llenara el arreglo
        for (int i = 0; i < 10; i++) {
            hilosInicio.add("hilo" + (i +1));
        }
        
        
        //Siempre se ejecutara
        while(inicio) {
            
            //Dara el intervalo de tiempo asignado en el menu
            try {
                sleep(VaraiblesGlobales.tiempoInventario * 1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(HilosMateriaPrima.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //Liminatara a que el arreglo de inventario solo tenga 5 objetos y el de inicio tenga algo
            if(VaraiblesGlobales.hilosInventario.size() <= 5 && !hilosInicio.isEmpty()){
                //validar que el arreglo de inicio tenga datos
                if(hilosInicio.get(0) != null) {
                    //Variable auxiliar para guardar primera posicion y pasar al segundo arreglo
                    primeroInicio = hilosInicio.get(0);
                    hilosInicio.removeFirst();
                    VaraiblesGlobales.hilosInventario.add(primeroInicio);
                    lbTituloInicio.setText("Inicio: " + hilosInicio.size());
                    lbTituloInventario.setText("Inventario: " + VaraiblesGlobales.hilosInventario.size());

                    //Cuando haya llegado al limite el arreglo de inventario empezara a mover los datos
                    if(VaraiblesGlobales.hilosInventario.size() == 5 && !hilosInicio.isEmpty()) {
                        primeroInventario = VaraiblesGlobales.hilosInventario.get(0);  
                        VaraiblesGlobales.hilosInventario.removeFirst();
                        VaraiblesGlobales.hilosIntermedio1.add(primeroInventario);
                        lbTituloInventario.setText("Inventario: " + VaraiblesGlobales.hilosInventario.size());
                    }
                }
            }
            //Cuando solo hayan datos en inventario los movera al siguiente arreglo
            else if (!VaraiblesGlobales.hilosInventario.isEmpty() && hilosInicio.isEmpty()){
                primeroInventario = VaraiblesGlobales.hilosInventario.get(0);  
                VaraiblesGlobales.hilosInventario.removeFirst();
                VaraiblesGlobales.hilosIntermedio1.add(primeroInventario);
                lbTituloInventario.setText("Inventario: " + VaraiblesGlobales.hilosInventario.size());
            }
            //Cuando ya no hayan mas cosas el buclo se apagara
            else {
                inicio = false;
                break;
            }

        }
    } 
}
    

        
       
    
