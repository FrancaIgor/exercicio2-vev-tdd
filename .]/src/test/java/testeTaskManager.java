import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TaskManagerTest {

    private TaskManager taskManager;

    @Before
    public void setUp() {
        taskManager = new TaskManager();
    }

    @Test
    public void testCreateTask() {
        Task task = new Task("Task 1", "Description 1", "2023-08-25", Priority.MEDIUM);
        taskManager.createTask(task);

        List<Task> tasks = taskManager.getTasks();
        assertEquals(1, tasks.size());
        assertEquals(task, tasks.get(0));
    }

    @Test
    public void testUpdateTask() {
        Task task = new Task("Task 1", "Description 1", "2023-08-25", Priority.MEDIUM);
        taskManager.createTask(task);

        Task updatedTask = new Task("Updated Task", "Updated Description", "2023-08-30", Priority.HIGH);
        taskManager.updateTask(0, updatedTask);

        List<Task> tasks = taskManager.getTasks();
        assertEquals(1, tasks.size());
        assertEquals(updatedTask, tasks.get(0));
    }

    @Test
    public void testDeleteTask() {
        Task task = new Task("Task 1", "Description 1", "2023-08-25", Priority.MEDIUM);
        taskManager.createTask(task);

        taskManager.deleteTask(0);

        List<Task> tasks = taskManager.getTasks();
        assertTrue(tasks.isEmpty());
    }

    @Test
    public void testListTasks() {
        Task task1 = new Task("Task 1", "Description 1", "2023-08-25", Priority.MEDIUM);
        Task task2 = new Task("Task 2", "Description 2", "2023-08-23", Priority.LOW);
        taskManager.createTask(task1);
        taskManager.createTask(task2);

        List<Task> tasks = taskManager.getTasks();
        assertEquals(2, tasks.size());
        assertEquals(task2, tasks.get(0));  // Sorted by date and then priority
        assertEquals(task1, tasks.get(1));
    }

    @Test
    public void testSetPriority() {
        Task task = new Task("Task 1", "Description 1", "2023-08-25", Priority.MEDIUM);
        taskManager.createTask(task);

        taskManager.setTaskPriority(0, Priority.HIGH);

        List<Task> tasks = taskManager.getTasks();
        assertEquals(Priority.HIGH, tasks.get(0).getPriority());
    }
}
