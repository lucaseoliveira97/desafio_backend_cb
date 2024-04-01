package github.com.lucaseoliveira.desafiobackcb.application.core.ports.out;

import github.com.lucaseoliveira.desafiobackcb.application.core.domain.Seller;

public interface UpdateSellerOutPort {
    Seller updateSeller(Long id, Seller seller);
}
