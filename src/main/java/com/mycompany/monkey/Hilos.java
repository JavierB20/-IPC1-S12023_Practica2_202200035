/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monkey;

/**
 *
 * @author Javier
 */
public class Hilos {
    
    public static void main(String[] args) {
        
        Thread hiloInicio = new Thread(new Inicio());
        Thread hiloInventario = new Thread(new Inventario());
        
        
        hiloInicio.start();
        hiloInventario.start();
        
        try {
            hiloInicio.join();
            hiloInventario.join();
        } catch (InterruptedException e) {
            System.out.println("Error" + e);
        }
        
         hiloInventario.interrupt();
    }
}


    class Inventario implements Runnable{
        private int unidadesProcesadas = 0;
        
        @Override
        public void run() {
            while (unidadesProcesadas < 5) {
                try {
                    // Esperar 20 segundos antes de procesar la siguiente unidad
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Esperar a recibir una unidad del otro hilo
                synchronized (this) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // Procesar la unidad recibida
                unidadesProcesadas++;
                System.out.println("Procesando unidad #" + unidadesProcesadas);
            }
            System.out.println("Hilo Limitador ha terminado.");
        }

        public synchronized void recibirUnidad() {
            notify();
        }
    }

    class Inicio implements Runnable{
        @Override
        public void run() {
            while (VaraiblesGlobales.materiaPrima > 0) {
                VaraiblesGlobales.materiaPrima--;
                System.out.println("Hilos de Salida: " + VaraiblesGlobales.materiaPrima);
            }
        System.out.println("Hilo Restador ha terminado.");
        }
    }
    
    class Fin implements Runnable {
        @Override
        public void run() {
            
        }
    }


