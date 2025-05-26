import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class Movements {

    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id;
    private LocalDateTime transactionTimeStamp;
    private String typeOfMovement;
    private double valueOfMovement;

    public Movements(LocalDateTime transactionTimeStamp, String typeOfMovement, double valueOfMovement) {
        this.id = count.incrementAndGet();
        this.transactionTimeStamp = transactionTimeStamp;
        this.typeOfMovement = typeOfMovement;
        this.valueOfMovement = valueOfMovement;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getTransactionTimeStamp() {
        return transactionTimeStamp;
    }

    public void setTransactionTimeStamp(LocalDateTime transactionTimeStamp) {
        this.transactionTimeStamp = transactionTimeStamp;
    }

    public String getTypeOfMovement() {
        return typeOfMovement;
    }

    public void setTypeOfMovement(String typeOfMovement) {
        this.typeOfMovement = typeOfMovement;
    }

    public double getValueOfMovement() {
        return valueOfMovement;
    }

    public void setValueOfMovement(double valueOfMovement) {
        this.valueOfMovement = valueOfMovement;
    }
}
