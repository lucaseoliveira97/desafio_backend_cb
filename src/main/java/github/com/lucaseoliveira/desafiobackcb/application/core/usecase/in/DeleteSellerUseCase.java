package github.com.lucaseoliveira.desafiobackcb.application.core.usecase.in;

import github.com.lucaseoliveira.desafiobackcb.application.core.ports.in.DeleteSellerPort;
import github.com.lucaseoliveira.desafiobackcb.application.core.ports.out.DeleteSellerOutPort;

public class DeleteSellerUseCase implements DeleteSellerPort {
    private final DeleteSellerOutPort deleteSellersRepository;

    public DeleteSellerUseCase(DeleteSellerOutPort deleteSellersRepository) {
        this.deleteSellersRepository = deleteSellersRepository;
    }
    @Override
    public void removeSeller(Long sellerId) {
        deleteSellersRepository.removeSeller(sellerId);
    }
}
