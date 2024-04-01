package github.com.lucaseoliveira.desafiobackcb.application.core.usecase.in;

import github.com.lucaseoliveira.desafiobackcb.application.core.domain.Seller;
import github.com.lucaseoliveira.desafiobackcb.application.core.domain.SellerTask;
import github.com.lucaseoliveira.desafiobackcb.application.core.exceptions.SellerTaskNotFoundExpection;
import github.com.lucaseoliveira.desafiobackcb.application.core.ports.in.CreateSellerPort;
import github.com.lucaseoliveira.desafiobackcb.application.core.ports.out.InsertSellerPort;
import github.com.lucaseoliveira.desafiobackcb.application.core.tasks.TaskManager;

import java.util.UUID;

public class CreateSellerUseCase implements CreateSellerPort {
    private final InsertSellerPort insertSellerRepository;
    private final TaskManager<SellerTask> createTaskManager = new TaskManager<>();

    public CreateSellerUseCase(InsertSellerPort insertSellerRepository) {
        this.insertSellerRepository = insertSellerRepository;
    }

    @Override
    public UUID createSeller(Seller seller) {
        UUID id = UUID.randomUUID();
        SellerTask sellerTask = new SellerTask(id, seller, SellerTask.TaskStatus.STARTED);
        createTaskManager.addTask(id, sellerTask, ()->{
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                if(sellerTask.getSeller().validate())
                {
                    Seller createdSeller = insertSellerRepository.createSeller(sellerTask.getSeller());
                    sellerTask.setSeller(createdSeller);
                    sellerTask.setStatus(SellerTask.TaskStatus.COMPLETED);
                    createTaskManager.updateTask(id, sellerTask);
                }
            } catch (Exception e) {
                sellerTask.setMessage(e.getMessage());
                sellerTask.setStatus(SellerTask.TaskStatus.ERROR);
                createTaskManager.updateTask(id, sellerTask);
            }

        });
        return id;
    }

    @Override
    public SellerTask getCreateSellerStatus(UUID taskId) throws SellerTaskNotFoundExpection {
        SellerTask task = createTaskManager.getTask(taskId);
        if(task != null)
        {
            return task;
        }
        throw new SellerTaskNotFoundExpection(taskId);
    }
}
