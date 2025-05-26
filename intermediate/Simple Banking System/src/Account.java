import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Account {

    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id;
    private  double balance;
    private  boolean isActive;
    private LocalDateTime createdAt;
    private String accountType;
    private  Customer owner;
    private final List<Movements> movements;

    public List<Movements> getMovements() {
        return movements;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", accountType='" + accountType + '\'' +
                ", owner=" + owner.getFirstName() +
                '}';
    }

    public Account(LocalDateTime createdAt, String accountType, Customer owner) {
        this.id = count.incrementAndGet();
        this.balance = 0;
        this.isActive = true;
        this.createdAt = createdAt;
        this.accountType = accountType;
        this.owner = owner;
        this.movements = new ArrayList<>();
    }

    public void getTransactions() {
        for (Movements movement : movements){

            System.out.println("ID of movement: " + movement.getId());
            System.out.println("Type of movevemnt: " + movement.getTypeOfMovement());
            System.out.println("Value: " + movement.getValueOfMovement());
            System.out.println("=======================================================");
        }
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }
}
