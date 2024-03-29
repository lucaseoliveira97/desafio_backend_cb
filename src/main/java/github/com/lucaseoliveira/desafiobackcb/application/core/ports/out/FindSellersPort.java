package github.com.lucaseoliveira.desafiobackcb.application.core.ports.out;

import github.com.lucaseoliveira.desafiobackcb.adapter.out.persistence.entity.SellerEntity;
import github.com.lucaseoliveira.desafiobackcb.application.core.domain.Seller;

import java.util.List;
import java.util.Optional;

public interface FindSellersPort {
    List<Seller> findSellers();
    Optional<Seller> findSeller(Long id);
}
