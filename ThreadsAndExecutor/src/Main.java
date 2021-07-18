
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    public static void main(String[] args) {
      
        ExecutorService executor = Executors.newFixedThreadPool(2); // aynı anda ikisi çalışacak şekilde thread havuzu oluşturruldu
        
        for(int i =1; i<=5; i++){ 
            
            executor.submit(new Writer(String.valueOf(i), i)); // 5 adet executor oluşturuldu
                       
        }
        
        executor.shutdown(); // executor ı kapatıyoruz yoksa sonsuz çaılışır
        System.out.println("Bütün işler teslim edildi...");
        
        try {
            executor.awaitTermination(1, TimeUnit.DAYS); // çok büyük bir iş verilmiş olabileceği için otomatik olarak 1 günlük işlem sonrası kapanacak komutunu veriyoruz
            } catch (InterruptedException ex) {             // yani en fazlabu iş için 1 gün beklerim diyoruz avaitTermibation ile
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println("Bütün işler bitti...");
            
            
            
            
            
            /* // Bu yöntem çok thread kullanılıyorsa amele bir yöntem
            Thread t1 = new Thread(new Writer("1", 1));
            Thread t2 = new Thread(new Writer("2", 2));
            Thread t3 = new Thread(new Writer("3", 3));
            Thread t4 = new Thread(new Writer("4", 4));
            Thread t5 = new Thread(new Writer("5", 5));
            System.out.println("Bütün işler teslim edildi...");
            t1.start();
            t2.start();
            
            try {
            t1.join();
            t2.join();
            } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            t3.start();
            t4.start();
            
            try {
            t3.join();
            t4.join();
            } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            t5.start();
            try {
            t5.join();
            } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Bütün işler tamamlandı...");
        */  
    }
}
