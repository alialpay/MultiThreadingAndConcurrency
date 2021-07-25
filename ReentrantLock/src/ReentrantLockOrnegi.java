
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ReentrantLockOrnegi {
    private int say = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
            
            
    public void artir(){
        for ( int i = 0; i < 10000; i++)
        say++;
        
    }
    public void thread1Fonksiyonu(){
        
        lock.lock();
        System.out.println("Thread 1 çalışıyor...");
        System.out.println("Thread 1 uyandırılmayı bekliyor...");
        
        try {
            condition.await(); // synchronized daki wait metoduyla aynı
        } catch (InterruptedException ex) {
            Logger.getLogger(ReentrantLockOrnegi.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Thread 1 uyandırıldı ve işlemine devam ediyor...");
        
        artir();
        
        lock.unlock();
        
    }
    public void thread2Fonksiyonu(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ReentrantLockOrnegi.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scanner scanner = new Scanner(System.in);
        
         
        lock.lock();
        System.out.println("Thread 2 çalışıyor...");
        
           //try ve finally bloklarıyla yazmak artir() fonksiyonundan kaynaklanabilecek bir exceptiona karşı güvenlik önlemidir.
        artir();
        System.out.println("Devam etmek için bir tuşa basın...");
        scanner.nextLine();
        condition.signal(); // thread2 thread1'e : ben işimi bitiriyorum sen de uyanmaya başla artık
        System.out.println("Thread 1'i uyandırdım ben gidiyorum.");
        
        lock.unlock();
        
    }
    public void threadOver(){
        System.out.println("Say değişkeninin değeri : " + say);
    }
}
