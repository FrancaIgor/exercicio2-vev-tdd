package junit5Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskManagerCreateTaskBoundaryTest {

    private TaskManager taskManager;

    @BeforeEach
    void setUp() {
        taskManager = new TaskManager();
    }

    @Test
    void testCreateTaskWithMinimumDueDate() {
        Task task = new Task("Tarefa com Data Mínima", "Descrição da tarefa", "1900-01-01", Priority.LOW);
        assertEquals("Tarefa criada com sucesso", taskManager.createTask(task));
    }

    @Test
    void testCreateTaskWithMaximumDueDate() {
        Task task = new Task("Tarefa com Data Máxima", "Descrição da tarefa", "9999-12-31", Priority.LOW);
        assertEquals("Tarefa criada com sucesso", taskManager.createTask(task));
    }

    @Test
    void testCreateTaskWithMinimumTitleLength() {
        Task task = new Task("", "Descrição da tarefa", "2023-08-21", Priority.LOW);
        assertEquals("Tarefa criada com sucesso", taskManager.createTask(task));
    }

    @Test
    void testCreateTaskWithMaximumTitleLength() {
        String longTitle = "Título muito longo..."; // Um título com 1000 caracteres
        Task task = new Task(longTitle, "Descrição da tarefa", "2023-08-21", Priority.LOW);
        assertEquals("Tarefa criada com sucesso", taskManager.createTask(task));
    }

    @Test
    void testCreateTaskWithInvalidDueDate() {
        Task task = new Task("Tarefa com Data Inválida", "Descrição da tarefa", "Data Inválida", Priority.LOW);
        assertThrows(IllegalArgumentException.class, () -> taskManager.createTask(task));
    }

    @Test
    void testCreateTaskWithInvalidTitle() {
        String invalidTitle = "Título inválido"; // Título inválido
        Task task = new Task(invalidTitle, "Descrição da tarefa", "2023-08-21", Priority.LOW);
        assertThrows(IllegalArgumentException.class, () -> taskManager.createTask(task));
    }
}
