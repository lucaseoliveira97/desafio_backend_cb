package github.com.lucaseoliveira.desafiobackcb.application.core.ports.in;

import github.com.lucaseoliveira.desafiobackcb.application.core.domain.Seller;
import github.com.lucaseoliveira.desafiobackcb.application.core.domain.SellerTask;
import github.com.lucaseoliveira.desafiobackcb.application.core.exceptions.SellerTaskNotFoundExpection;

import java.util.UUID;

public interface CreateSellerPort {
    UUID createSeller(Seller seller);
    SellerTask getCreateSellerStatus(UUID taskId) throws SellerTaskNotFoundExpection;
}
