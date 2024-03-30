package github.com.lucaseoliveira.desafiobackcb.application.core.usecase.in;

import github.com.lucaseoliveira.desafiobackcb.application.core.domain.Seller;
import github.com.lucaseoliveira.desafiobackcb.application.core.ports.in.CreateSellerPort;
import github.com.lucaseoliveira.desafiobackcb.application.core.ports.out.InsertSellerPort;
import github.com.lucaseoliveira.desafiobackcb.application.core.tasks.TaskManager;

import java.util.UUID;

public class CreateSellerUseCase implements CreateSellerPort {
    private final InsertSellerPort insertSellerRepository;
    private final TaskManager<Seller> createTaskManager = new TaskManager<Seller>();

    public CreateSellerUseCase(InsertSellerPort insertSellerRepository) {
        this.insertSellerRepository = insertSellerRepository;
    }

    @Override
    public UUID createSeller(Seller seller) {
        UUID id = UUID.randomUUID();
        createTaskManager.addTask(id, seller, ()->{
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            insertSellerRepository.createSeller(seller);
            createTaskManager.finishThread(id);
        });
        return id;
    }
}
