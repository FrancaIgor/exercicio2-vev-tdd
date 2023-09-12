package functionalTests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaskManagerCreateTaskEquivalenceTest {

    @Test
    public void testCreateTaskWithValidDueDate() {
        TaskManager taskManager = new TaskManager();
        Task task = new Task("Tarefa com Data Válida", "Descrição da tarefa", "2023-08-21", Priority.LOW);
        assertEquals("Tarefa criada com sucesso", taskManager.createTask(task));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateTaskWithInvalidDueDate() {
        TaskManager taskManager = new TaskManager();
        Task task = new Task("Tarefa com Data Inválida", "Descrição da tarefa", "Data Inválida", Priority.LOW);
        taskManager.createTask(task); // Deve lançar uma exceção
    }

    @Test
    public void testCreateTaskWithValidTitle() {
        TaskManager taskManager = new TaskManager();
        Task task = new Task("Tarefa com Título Válido", "Descrição da tarefa", "2023-08-21", Priority.LOW);
        assertEquals("Tarefa criada com sucesso", taskManager.createTask(task));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateTaskWithInvalidTitle() {
        TaskManager taskManager = new TaskManager();
        String invalidTitle = "Título inválido"; // Título inválido
        Task task = new Task(invalidTitle, "Descrição da tarefa", "2023-08-21", Priority.LOW);
        taskManager.createTask(task); // Deve lançar uma exceção
    }
}
