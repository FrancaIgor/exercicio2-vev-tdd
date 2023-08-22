import java.time.LocalDate;

class Task {
    private String title;
    private String description;
    private LocalDate dueDate;
    private Priority priority;

    public Task(String title, String description, String dueDate, Priority priority) {
        this.title = title;
        this.description = description;
        this.dueDate = LocalDate.parse(dueDate);
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = LocalDate.parse(dueDate);
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
