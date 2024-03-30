package github.com.lucaseoliveira.desafiobackcb.adapter.out.persistence.integration;

import github.com.lucaseoliveira.desafiobackcb.adapter.out.persistence.repository.SellerRepository;
import github.com.lucaseoliveira.desafiobackcb.application.core.ports.out.DeleteSellerOutPort;
import org.springframework.stereotype.Component;

@Component
public class DeleteSellerAdapter implements DeleteSellerOutPort {
    SellerRepository sellerRepository;
    public DeleteSellerAdapter(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public void removeSeller(Long sellerId) {
        sellerRepository.deleteById(sellerId);
    }
}
