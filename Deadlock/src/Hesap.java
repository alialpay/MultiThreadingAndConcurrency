
public class Hesap {
    private int bakiye = 10000;
    
    public void paraCek(int miktar) {
        bakiye -= miktar;
        
    }
    public void paraYatır(int miktar) {
        bakiye += miktar;
    }
    
    public static void paraTransferi(Hesap hesap1, Hesap hesap2, int miktar) {
        hesap1.paraCek(miktar);
        hesap2.paraYatır(miktar);
    }

    public int getBakiye() {
        return bakiye;
    }

    public void setBakiye(int bakiye) {
        this.bakiye = bakiye;
    }
    
    
}
