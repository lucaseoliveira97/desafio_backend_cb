package github.com.lucaseoliveira.desafiobackcb.adapter.out.persistence.integration;

import github.com.lucaseoliveira.desafiobackcb.adapter.mapper.SellerMapper;
import github.com.lucaseoliveira.desafiobackcb.adapter.out.persistence.repository.SellerRepository;
import github.com.lucaseoliveira.desafiobackcb.application.core.domain.Seller;
import github.com.lucaseoliveira.desafiobackcb.application.core.ports.out.FindSellersPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class FindSellersAdapter implements FindSellersPort {
    final SellerRepository sellerRepository;
    public FindSellersAdapter(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }
    @Override
    public List<Seller> findSellers() {
        return StreamSupport.stream(sellerRepository.findAll().spliterator(), false).
                map(SellerMapper::toDomain).
                collect(Collectors.toList());
    }

    @Override
    public Optional<Seller> findSeller(Long id) {
        return sellerRepository.findById(id).map(SellerMapper::toDomain);
    }
}
