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
    
    private JLabel lbTituloSalida, lbTituloFinal, lbTiempo;
    private JButton btnReporte, btnRegresar;
    
    LinkedList<String> hilosSalida = new LinkedList<String>();
    LinkedList<String> hilosFinal = new LinkedList<String>();
    private String primeroIntermedio;
    
    private boolean inicio = true;
    
    public HilosMateriaPrima4(JLabel lbTituloSalida, JLabel lbTituloFinal, JButton btnRegresar, JButton btnReporte, JLabel lbTiempo){
        this.lbTituloSalida = lbTituloSalida;
        this.lbTituloFinal = lbTituloFinal;
        this.btnRegresar = btnRegresar;
        this.btnReporte = btnReporte;
        this.lbTiempo = lbTiempo;
    }
      
    @Override
    public void run() {
        
        while(!inicio){
            if(!VaraiblesGlobales.hilosIntermedio3.isEmpty()){
                System.out.println("YA");
                //Dara el intervalo de tiempo asignado en el menu
                try {
                    sleep(VaraiblesGlobales.tiempoSalida * 1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(HilosMateriaPrima4.class.getName()).log(Level.SEVERE, null, ex);
                }

                //Liminatara a que el arreglo de produccion solo tenga 2 objetos y el de inicio tenga algo
                if(VaraiblesGlobales.hilosSalida.size() < 4 && !VaraiblesGlobales.hilosIntermedio3.isEmpty()){
                    //validar que el arreglo de inicio tenga datos
                    if(VaraiblesGlobales.hilosIntermedio3.get(0) != null) {
                        //Variable auxiliar para guardar primera posicion y pasar al segundo arreglo
                        primeroIntermedio = VaraiblesGlobales.hilosIntermedio3.get(0);
                        VaraiblesGlobales.hilosIntermedio3.removeFirst();
                        VaraiblesGlobales.hilosSalida.add(primeroIntermedio);
                        lbTituloSalida.setText("Salida: " + VaraiblesGlobales.hilosEmpaquetado.size());
                        
                        //Cuando haya llegado al limite el arreglo de inventario empezara a mover los datos
                        if(VaraiblesGlobales.hilosEmpaquetado.size() == 4 && !VaraiblesGlobales.hilosIntermedio3.isEmpty()) {
                            primeroIntermedio = VaraiblesGlobales.hilosSalida.get(0);  
                            VaraiblesGlobales.hilosSalida.removeFirst();
                            hilosFinal.add(primeroIntermedio);
                            lbTituloSalida.setText("Salida: " + VaraiblesGlobales.hilosEmpaquetado.size());
                            lbTituloFinal.setText("Final: " + hilosFinal.size());
                        }
                    }
                }
                //Cuando solo hayan datos en inventario los movera al siguiente arreglo
                else if (!VaraiblesGlobales.hilosSalida.isEmpty() && VaraiblesGlobales.hilosIntermedio3.isEmpty()){
                    primeroIntermedio = VaraiblesGlobales.hilosSalida.get(0);  
                    VaraiblesGlobales.hilosSalida.removeFirst();
                    hilosFinal.add(primeroIntermedio);
                    lbTituloSalida.setText("Salida: " + VaraiblesGlobales.hilosEmpaquetado.size());
                    lbTituloFinal.setText("Final: " + hilosFinal.size());       
                }
                //Cuando ya no hayan mas cosas el buclo se apagara
                else if (hilosSalida.size() == 30){
                    inicio = false;
                    btnReporte.setEnabled(false);
                    btnRegresar.setEnabled(false);
                    HiloTiempo hiloTiempo = new HiloTiempo(lbTiempo);
                    hiloTiempo.stop();
                    break;
                }
            }
            System.out.println("Aun no");
        }
        
    }
}
    

        
       
    
