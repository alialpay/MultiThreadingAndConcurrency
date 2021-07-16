
package com.alialpay.thread1;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Printer extends Thread{
    
    @Override
    public void run() {
        System.out.println(isim + " çalışıyor...");
        
        for(int i = 1; i<=10 ; i++) {
            try {
                System.out.println(isim + " yazıyor " + i);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Thread kesintiye uğradı!");
            }
           
            
        }
        System.out.println(isim + " işini bitirdi");
        for(int j = 1; j<=3; j++){
            try {
                System.out.print(".");
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("üç nokta yazılırken Thread kesintiye uğradı");
            }
        }
        
        
    }
    
    private String isim;

    public Printer(String isim) {   //constructor
        this.isim = isim;
    }

    
    
    
    
}
