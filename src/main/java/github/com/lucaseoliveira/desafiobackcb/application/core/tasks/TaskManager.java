package github.com.lucaseoliveira.desafiobackcb.application.core.tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskManager<T> {
    private Map<UUID, T> createdTasks;
    private ExecutorService es;

    public TaskManager()
    {
        createdTasks = new HashMap<UUID, T>();
        es = Executors.newFixedThreadPool(5);
    }
    public T getTask(UUID id)
    {
        return createdTasks.get(id);
    }
    public void addTask(UUID id, T task, Runnable thread)
    {
        createdTasks.put(id, task);
        es.execute(thread);
    }
    public void updateTask(UUID id,T task)
    {
        createdTasks.replace(id, task);
    }
}
