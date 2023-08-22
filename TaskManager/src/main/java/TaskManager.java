import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void createTask(Task task) {
        tasks.add(task);
        tasks.sort(new TaskComparator());
    }

    public void updateTask(int index, Task updatedTask) {
        tasks.set(index, updatedTask);
        tasks.sort(new TaskComparator());
    }

    public void deleteTask(int index) {
        tasks.remove(index);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTaskPriority(int index, Priority priority) {
        tasks.get(index).setPriority(priority);
        tasks.sort(new TaskComparator());
    }

    private class TaskComparator implements Comparator<Task> {
        @Override
        public int compare(Task task1, Task task2) {
            int dateComparison = task1.getDueDate().compareTo(task2.getDueDate());
            if (dateComparison == 0) {
                return task1.getPriority().compareTo(task2.getPriority());
            }
            return dateComparison;
        }
    }
}