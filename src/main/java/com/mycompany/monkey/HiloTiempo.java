/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monkey;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Javier
 */
public class HiloTiempo extends Thread {
    
    private JLabel lbTiempo;
    private int min = 0, seg = 0;

    public HiloTiempo(JLabel lbTiempo) {
        this.lbTiempo = lbTiempo;
    }
    
    //metodo para trabjar el hilo del tiempo
    @Override
    public void run(){
        while(true){
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloTiempo.class.getName()).log(Level.SEVERE, null, ex);
            }
            seg++;
            if(seg >= 60) {
                min++;
                seg = 0;
            }
            lbTiempo.setText(min + ":" + seg);
        }
        
    }
    
}
