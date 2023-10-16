import java.util.concurrent.atomic.AtomicInteger;

class BankAccount {
    private final AtomicInteger balance = new AtomicInteger(100);
    public int getBalance() {
        return balance.get();
    }
    public void spend(String name, int amount) {
        int initialBalance = balance.get();
        if (initialBalance >= amount) {
            boolean success = balance.compareAndSet(initialBalance, initialBalance - amount);
            if (!success) {
                System.out.println("Sorry " + name + ", you haven't spent the money.");
            }
        } else {
            System.out.println("Sorry, not enough for " + name);
        }
    }
}

