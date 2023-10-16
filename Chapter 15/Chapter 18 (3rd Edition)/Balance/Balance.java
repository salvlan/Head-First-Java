import java.util.concurrent.atomic.*;

public class Balance implements Runnable{
    private AtomicInteger balance = new AtomicInteger(0);

    public void run (){
        for (int i=0; i<50; i++){
            increment ();
            System.out.println("balance is " + balance);
        }
    }

    public void increment (){
        balance.incrementAndGet();
    }
}
