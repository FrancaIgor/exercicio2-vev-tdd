package functionalTests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaskManagerCreateTaskDecisionTableTest {

    @Test
    public void testCreateTaskValidDueDateValidTitle() {
        TaskManager taskManager = new TaskManager();
        Task task = new Task("Tarefa Válida", "Descrição da tarefa", "2023-08-21", Priority.LOW);
        assertEquals("Tarefa criada com sucesso", taskManager.createTask(task));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateTaskValidDueDateInvalidTitle() {
        TaskManager taskManager = new TaskManager();
        String invalidTitle = "Título inválido"; // Título inválido
        Task task = new Task(invalidTitle, "Descrição da tarefa", "2023-08-21", Priority.LOW);
        taskManager.createTask(task); // Deve lançar uma exceção
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateTaskInvalidDueDateValidTitle() {
        TaskManager taskManager = new TaskManager();
        Task task = new Task("Tarefa com Data Inválida", "Descrição da tarefa", "Data Inválida", Priority.LOW);
        taskManager.createTask(task); // Deve lançar uma exceção
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateTaskInvalidDueDateInvalidTitle() {
        TaskManager taskManager = new TaskManager();
        String invalidTitle = "Título inválido"; // Título inválido
        Task task = new Task(invalidTitle, "Descrição da tarefa", "Data Inválida", Priority.LOW);
        taskManager.createTask(task); // Deve lançar uma exceção
    }
}
