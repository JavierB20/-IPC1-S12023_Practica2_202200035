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
    private String primeroIntermedio, primeroIntermedio2;
    
    private boolean inicio = true;
    
    public HilosMateriaPrima3(JLabel lbTituloEmpaquetado){
        this.lbTituloEmpaquetado = lbTituloEmpaquetado;
    }
      
    @Override
    public void run() {
        
        while(!inicio){
            if(!VaraiblesGlobales.hilosIntermedio2.isEmpty()){
                System.out.println("YA hilo 3");
                //Dara el intervalo de tiempo asignado en el menu
                try {
                    sleep(VaraiblesGlobales.tiempoEmpaquetado * 1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(HilosMateriaPrima3.class.getName()).log(Level.SEVERE, null, ex);
                }

                //Liminatara a que el arreglo de produccion solo tenga 2 objetos y el de inicio tenga algo
                if(VaraiblesGlobales.hilosEmpaquetado.size() < 3 && !VaraiblesGlobales.hilosIntermedio2.isEmpty()){
                    //validar que el arreglo de inicio tenga datos
                    if(VaraiblesGlobales.hilosIntermedio2.get(0) != null) {
                        //Variable auxiliar para guardar primera posicion y pasar al segundo arreglo
                        primeroIntermedio = VaraiblesGlobales.hilosIntermedio2.get(0);
                        VaraiblesGlobales.hilosIntermedio2.removeFirst();
                        VaraiblesGlobales.hilosEmpaquetado.add(primeroIntermedio);
                        lbTituloEmpaquetado.setText("Empaquetado: " + VaraiblesGlobales.hilosEmpaquetado.size());
                        
                        //Cuando haya llegado al limite el arreglo de inventario empezara a mover los datos
                        if(VaraiblesGlobales.hilosEmpaquetado.size() == 3 && !VaraiblesGlobales.hilosIntermedio2.isEmpty()) {
                            primeroIntermedio2 = VaraiblesGlobales.hilosEmpaquetado.get(0);  
                            VaraiblesGlobales.hilosEmpaquetado.removeFirst();
                            VaraiblesGlobales.hilosIntermedio3.add(primeroIntermedio2);
                            lbTituloEmpaquetado.setText("Empaquetado: " + VaraiblesGlobales.hilosEmpaquetado.size());
                        }
                    }
                }
                //Cuando solo hayan datos en inventario los movera al siguiente arreglo
                else if (!VaraiblesGlobales.hilosEmpaquetado.isEmpty() && VaraiblesGlobales.hilosIntermedio2.isEmpty()){
                    primeroIntermedio2 = VaraiblesGlobales.hilosEmpaquetado.get(0);  
                    VaraiblesGlobales.hilosEmpaquetado.removeFirst();
                    VaraiblesGlobales.hilosIntermedio3.add(primeroIntermedio2);
                    lbTituloEmpaquetado.setText("Empaquetado: " + VaraiblesGlobales.hilosEmpaquetado.size());
                }
                //Cuando ya no hayan mas cosas el buclo se apagara
                else if (VaraiblesGlobales.hilosIntermedio2.isEmpty() && VaraiblesGlobales.hilosEmpaquetado.isEmpty() && VaraiblesGlobales.hilosProduccion.isEmpty()){
                    inicio = false;
                    break;
                }
            }
            System.out.println("Aun no h3");
        }
        
    }
}
    

        
       
    
