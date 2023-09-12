package functionalTests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class TaskManagerCreateTaskBoundaryTest {

    @Test
    public void testCreateTaskWithMinimumDueDate() {
        TaskManager taskManager = new TaskManager();
        Task task = new Task("Tarefa com Data Mínima", "Descrição da tarefa", "1900-01-01", Priority.LOW);
        assertEquals("Tarefa criada com sucesso", taskManager.createTask(task));
    }

    @Test
    public void testCreateTaskWithMaximumDueDate() {
        TaskManager taskManager = new TaskManager();
        Task task = new Task("Tarefa com Data Máxima", "Descrição da tarefa", "9999-12-31", Priority.LOW);
        assertEquals("Tarefa criada com sucesso", taskManager.createTask(task));
    }

    @Test
    public void testCreateTaskWithMinimumTitleLength() {
        TaskManager taskManager = new TaskManager();
        Task task = new Task("", "Descrição da tarefa", "2023-08-21", Priority.LOW);
        assertEquals("Tarefa criada com sucesso", taskManager.createTask(task));
    }

    @Test
    public void testCreateTaskWithMaximumTitleLength() {
        TaskManager taskManager = new TaskManager();
        String longTitle = "Título muito longo..."; // Um título com 1000 caracteres
        Task task = new Task(longTitle, "Descrição da tarefa", "2023-08-21", Priority.LOW);
        assertEquals("Tarefa criada com sucesso", taskManager.createTask(task));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateTaskWithInvalidDueDate() {
        TaskManager taskManager = new TaskManager();
        Task task = new Task("Tarefa com Data Inválida", "Descrição da tarefa", "Data Inválida", Priority.LOW);
        taskManager.createTask(task); // Deve lançar uma exceção
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateTaskWithInvalidTitle() {
        TaskManager taskManager = new TaskManager();
        String invalidTitle = "Título inválido"; // Título inválido
        Task task = new Task(invalidTitle, "Descrição da tarefa", "2023-08-21", Priority.LOW);
        taskManager.createTask(task); // Deve lançar uma exceção
    }
}
