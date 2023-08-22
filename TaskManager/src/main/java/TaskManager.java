import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    // Cria uma nova tarefa e a adiciona à lista de tarefas
    public void createTask(Task task) {
        tasks.add(task);
        tasks.sort(new TaskComparator());
    }

    // Atualiza uma tarefa existente na lista
    public void updateTask(int index, Task updatedTask) {
        tasks.set(index, updatedTask);
        tasks.sort(new TaskComparator());
    }
    
    // Exclui uma tarefa da lista
    public void deleteTask(int index) {
    	// adicionando tratamento de exeções para remoção
    	try {
            tasks.remove(index);
        } catch (IndexOutOfBoundsException e) {
        	// Se o índice estiver fora dos limites da lista, lança uma exceção com uma mensagem explicativa
            throw new IllegalArgumentException("Índice inválido: " + index);
        }
    }

    // Obtém a lista completa de tarefas
    public List<Task> getTasks() {
        return tasks;
    }

    // Define a prioridade de uma tarefa e reordena a lista
    public void setTaskPriority(int index, Priority priority) {
        tasks.get(index).setPriority(priority);
        tasks.sort(new TaskComparator());
    }


    // Comparador interno para ordenar as tarefas por data de vencimento e prioridade
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