package github.com.lucaseoliveira.desafiobackcb.application.core.ports.in;

import github.com.lucaseoliveira.desafiobackcb.application.core.domain.Seller;

import java.util.UUID;

public interface UpdateSellerPort {
    Seller updateSeller(Long id, Seller seller) throws Exception;
}
