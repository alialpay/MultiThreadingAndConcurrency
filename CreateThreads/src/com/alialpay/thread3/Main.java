/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alialpay.thread3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alial
 */
public class Main {
    public static void main(String[] args) {
        
       /* Thread printer1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread çalışıyor...");
                for(int i = 1; i <=10; i++) {
                    try {
                        System.out.println("Yazıyor : " + i);
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });*/
        
        //printer1.start();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread çalışıyor...");
                for(int i = 1; i <=10; i++) {
                    try {
                        System.out.println("Yazıyor : " + i);
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
        
        System.out.println("Main Thread çalışıyor...");
    }
}
