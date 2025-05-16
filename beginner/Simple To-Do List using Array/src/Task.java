import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class Task {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private String description;
    private boolean isDone;
    private LocalDate dueDate;
    private Priorities priority;
    private Category category;

    public Task(String description, LocalDate dueDate, Priorities priority, Category category) {
        this.id = count.incrementAndGet();
        this.description = description;
        this.isDone = false;
        this.dueDate = dueDate;
        this.priority = priority;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Priorities getPriority() {
        return priority;
    }

    public void setPriority(Priorities priority) {
        this.priority = priority;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", isDone=" + isDone +
                ", dueDate=" + dueDate +
                ", priority=" + priority +
                ", category=" + category +
                '}';
    }
}
