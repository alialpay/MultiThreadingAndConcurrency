
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Main {
    public static void main(String[] args) {
        ReentrantLockOrnegi re = new ReentrantLockOrnegi();
        
        Thread thread1 = new Thread(new Runnable(){
            @Override
            public void run() {
                re.thread1Fonksiyonu();
            }
        
    });
        Thread thread2 = new Thread(new Runnable(){
            @Override
            public void run() {
                re.thread2Fonksiyonu();
            }
        
    });
        
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        re.threadOver();
    }
}
