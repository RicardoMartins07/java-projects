import java.time.LocalDateTime;

public class Account {

    private  int id;
    private  double balance;
    private  boolean isActive;
    private LocalDateTime createdAt;
    private AccountType accountType;
    private  Customer owner;

    public Account(LocalDateTime createdAt, AccountType accountType, Customer owner) {
        this.balance = 0;
        this.isActive = true;
        this.createdAt = createdAt;
        this.accountType = accountType;
        this.owner = owner;
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

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }
}
