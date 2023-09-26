package junit5Tests;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Task {
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

    // Método para definir a data de vencimento da tarefa
    public void setDueDate(String dueDate) {
    	
        try {
        	// Converte a String de data em LocalDate
            this.dueDate = LocalDate.parse(dueDate);
        } catch (DateTimeParseException e) {
        	// Lança uma exceção se a conversão falhar
            throw new IllegalArgumentException("Data de vencimento inválida. Use o formato yyyy-MM-dd.");
        }
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
