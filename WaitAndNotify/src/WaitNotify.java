
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class WaitNotify {
    private Object lock = new Object();
    
    public void thread1Fonksiyonu(){
        
        synchronized(lock) { 
            System.out.println("Thread 1 çalışıyor...");
            System.out.println("Thread 1 Thread 2'nin kendisini uyandırmasını bekliyor...");
            
            try {
                lock.wait(); // burda anahtarı teslim edeceğim ve başka birisi beni uyandırana kadar hareket etmicem demek
                        // başka bir thread notify edene kadar çalışmaz
            } catch (InterruptedException ex) {
                Logger.getLogger(WaitNotify.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Thread 1 uyandı. Devam ediyor..");
        }
        
    }
    public void thread2Fonksiyonu(){
        Scanner scanner = new Scanner(System.in);
        try {
            Thread.sleep(2000); // bu threadi iki saniye uyutuyoruz. thread1 işleme başlasın diye
        } catch (InterruptedException ex) {
            Logger.getLogger(WaitNotify.class.getName()).log(Level.SEVERE, null, ex);
        }
        synchronized(lock) {
            System.out.println("Thread 2 çalışıyor...");
            System.out.println("Devam etmek için bir tuşa basın...");
            
            scanner.nextLine();
            
            notify();
            
            System.out.println("Thread2 : Uyandırdım abi ben gidiyorum ama 2 saniye bekle...");
            
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(WaitNotify.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
