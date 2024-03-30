package github.com.lucaseoliveira.desafiobackcb.application.core.ports.out;

import github.com.lucaseoliveira.desafiobackcb.application.core.domain.Seller;

public interface InsertSellerPort {
    Seller createSeller(Seller seller);
}
