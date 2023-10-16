public class BalanceTest {
    public static void main(String[] args) {
        Balance job = new Balance();
        Thread a = new Thread (job);
        Thread b = new Thread (job);
        a.start();
        b.start();
    }
}

