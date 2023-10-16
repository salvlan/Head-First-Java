public class RyanAndMonicaJob implements Runnable {

    private BankAccount account = new BankAccount();

    public static void main(String[] args) {
        RyanAndMonicaJob theJob = new RyanAndMonicaJob();
        Thread ryan = new Thread(theJob);
        Thread monica = new Thread(theJob);
        ryan.setName("Ryan");
        monica.setName("Monica");
        ryan.start();
        monica.start();
    }

    public void run(){
        for (int x=0; x<10; x++){
            makeWithdrawal(10);
            if (account.getBalance()<0){
                System.out.println("Overdrawn!");
            }
        }
    }

    private synchronized void makeWithdrawal(int amount){
        if (account.getBalance()>=amount){
            System.out.println(Thread.currentThread().getName() + " is about to withdraw");
            try {
                System.out.println (Thread.currentThread().getName() + " is going to sleep");
                Thread.sleep(500);
            } catch (InterruptedException ex){
                ex.printStackTrace();
            }
            System.out.println (Thread.currentThread().getName() + " woke up");
            account.withdraw(amount);
            System.out.println (Thread.currentThread().getName() + " completes the withdrawal");
        } else {
            System.out.println ("Sorry, not enough for " + Thread.currentThread().getName());
        }
    }
}
