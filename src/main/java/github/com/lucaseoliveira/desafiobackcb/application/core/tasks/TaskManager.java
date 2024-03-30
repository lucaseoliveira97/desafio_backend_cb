package github.com.lucaseoliveira.desafiobackcb.application.core.tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskManager<T> {
    private Map<UUID, Status> createdTasks;
    private ExecutorService es;
    private enum Status {
        STARDED,
        FINISH
    }

    public TaskManager()
    {
        createdTasks = new HashMap<UUID, Status>();
        es = Executors.newFixedThreadPool(5);
    }
    public void addTask(UUID id, T task, Runnable thread)
    {
        createdTasks.put(id, Status.STARDED);
        es.execute(thread);
    }
    public void finishThread(UUID id)
    {
        createdTasks.replace(id, Status.FINISH);
    }
}
