package com.mycompany.monkey;

import javax.swing.JFrame;

/**
 *
 * @author Javier
 */

public class Monkey extends JFrame{

    
    public Monkey() {
        setTitle("MonkeySimulation");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MonkeyVentana ventana = new MonkeyVentana();
        this.getContentPane().add(ventana);
        this.pack();
        this.setLocationRelativeTo(null);
            this.setVisible(true);
    }
    
    public static void main(String[] args) {
        MonkeyMenu ventana = new MonkeyMenu();
        ventana.setVisible(true);
    }
}
