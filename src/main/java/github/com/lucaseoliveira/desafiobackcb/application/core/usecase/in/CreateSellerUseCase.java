package github.com.lucaseoliveira.desafiobackcb.application.core.usecase.in;

import github.com.lucaseoliveira.desafiobackcb.application.core.domain.Seller;
import github.com.lucaseoliveira.desafiobackcb.application.core.domain.SellerTask;
import github.com.lucaseoliveira.desafiobackcb.application.core.ports.in.CreateSellerPort;
import github.com.lucaseoliveira.desafiobackcb.application.core.ports.out.InsertSellerPort;
import github.com.lucaseoliveira.desafiobackcb.application.core.tasks.TaskManager;

import java.util.UUID;

public class CreateSellerUseCase implements CreateSellerPort {
    private final InsertSellerPort insertSellerRepository;
    private final TaskManager<SellerTask> createTaskManager = new TaskManager<SellerTask>();

    public CreateSellerUseCase(InsertSellerPort insertSellerRepository) {
        this.insertSellerRepository = insertSellerRepository;
    }

    @Override
    public UUID createSeller(Seller seller) {
        UUID id = UUID.randomUUID();
        SellerTask sellerTask = new SellerTask(id, seller, SellerTask.TaskStatus.STARTED);
        createTaskManager.addTask(id, sellerTask, ()->{
            System.out.println("Iniciando thread");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Seller createdSeller = insertSellerRepository.createSeller(sellerTask.seller());
            createTaskManager.updateTask(id, sellerTask);
            System.out.println("Finalizando thread");
        });
        return id;
    }

    @Override
    public SellerTask getCreateSellerStatus(UUID taskId) {
        return createTaskManager.getTask(taskId);
    }
}
