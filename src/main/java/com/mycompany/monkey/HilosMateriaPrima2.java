/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monkey;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Javier
 */
public class HilosMateriaPrima2 extends Thread{
    
    private JLabel lbTituloProduccion;
    
    private String primeroIntermedio, primeroProduccion;
    
    private boolean inicio = false;
    
    public HilosMateriaPrima2(JLabel lbTituloProduccion){
        this.lbTituloProduccion = lbTituloProduccion;
    }
      
    @Override
    public void run() {
        
        while(!inicio){
            if(!VaraiblesGlobales.hilosIntermedio1.isEmpty()){
                System.out.println("YA");
                //Dara el intervalo de tiempo asignado en el menu
                try {
                    sleep(VaraiblesGlobales.tiempoProduccion * 1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(HilosMateriaPrima2.class.getName()).log(Level.SEVERE, null, ex);
                }

                //Liminatara a que el arreglo de produccion solo tenga 2 objetos y el de inicio tenga algo
                if(VaraiblesGlobales.hilosProduccion.size() < 2 && !VaraiblesGlobales.hilosIntermedio1.isEmpty()){
                    //validar que el arreglo de inicio tenga datos
                    if(VaraiblesGlobales.hilosIntermedio1.get(0) != null) {
                        //Variable auxiliar para guardar primera posicion y pasar al segundo arreglo
                        primeroProduccion = VaraiblesGlobales.hilosIntermedio1.get(0);
                        VaraiblesGlobales.hilosIntermedio1.removeFirst();
                        VaraiblesGlobales.hilosProduccion.add(primeroProduccion);
                        lbTituloProduccion.setText("Produccion: " + VaraiblesGlobales.hilosProduccion.size());
                        
                        //Cuando haya llegado al limite el arreglo de inventario empezara a mover los datos
                        if(VaraiblesGlobales.hilosProduccion.size() == 2 && !VaraiblesGlobales.hilosIntermedio1.isEmpty()) {
                            primeroProduccion = VaraiblesGlobales.hilosProduccion.get(0);  
                            VaraiblesGlobales.hilosProduccion.removeFirst();
                            VaraiblesGlobales.hilosIntermedio2.add(primeroProduccion);
                            lbTituloProduccion.setText("Produccion: " + VaraiblesGlobales.hilosProduccion.size());
                        }
                    }
                }
                //Cuando solo hayan datos en inventario los movera al siguiente arreglo
                else if (!VaraiblesGlobales.hilosProduccion.isEmpty() || VaraiblesGlobales.hilosIntermedio1.isEmpty()){
                    primeroProduccion = VaraiblesGlobales.hilosProduccion.get(0);  
                    VaraiblesGlobales.hilosProduccion.removeFirst();
                    VaraiblesGlobales.hilosIntermedio2.add(primeroProduccion);
                    lbTituloProduccion.setText("Produccion: " + VaraiblesGlobales.hilosProduccion.size());
                }
                //Cuando ya no hayan mas cosas el buclo se apagara
                else if (VaraiblesGlobales.hilosIntermedio1.isEmpty() && VaraiblesGlobales.hilosProduccion.isEmpty() && VaraiblesGlobales.hilosInventario.isEmpty()){
                    inicio = false;
                    break;
                }
            }
//            else if (VaraiblesGlobales.hilosProduccion.size() <= 2) {
//                System.out.println("YA final");
//                primeroProduccion = VaraiblesGlobales.hilosProduccion.get(0);  
//                VaraiblesGlobales.hilosProduccion.removeFirst();
//                VaraiblesGlobales.hilosIntermedio2.add(primeroProduccion);
//                lbTituloProduccion.setText("Produccion: " + VaraiblesGlobales.hilosProduccion.size());
//            }
                System.out.println("Aun no");

        }
        

        
    }

}
        
        
        
       

    

        
       
    
