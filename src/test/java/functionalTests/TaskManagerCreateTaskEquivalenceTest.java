package functionalTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class TaskManagerCreateTaskEquivalenceTest {

    @Test
    void testCreateTaskWithValidDueDate() {
        TaskManager taskManager = new TaskManager();
        Task task = new Task("Tarefa com Data Válida", "Descrição da tarefa", "2023-08-21", Priority.LOW);
        assertEquals("Tarefa criada com sucesso", taskManager.createTask(task));
    }

    @Test
    void testCreateTaskWithInvalidDueDate() {
        TaskManager taskManager = new TaskManager();
        Task task = new Task("Tarefa com Data Inválida", "Descrição da tarefa", "Data Inválida", Priority.LOW);
        assertThrows(IllegalArgumentException.class, () -> taskManager.createTask(task));
    }

    @Test
    void testCreateTaskWithValidTitle() {
        TaskManager taskManager = new TaskManager();
        Task task = new Task("Tarefa com Título Válido", "Descrição da tarefa", "2023-08-21", Priority.LOW);
        assertEquals("Tarefa criada com sucesso", taskManager.createTask(task));
    }

    @Test
    void testCreateTaskWithInvalidTitle() {
        TaskManager taskManager = new TaskManager();
        String invalidTitle = "Título inválido"; // Título inválido
        Task task = new Task(invalidTitle, "Descrição da tarefa", "2023-08-21", Priority.LOW);
        assertThrows(IllegalArgumentException.class, () -> taskManager.createTask(task));
    }
}
