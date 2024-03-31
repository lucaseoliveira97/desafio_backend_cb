package github.com.lucaseoliveira.desafiobackcb.adapter.out.persistence.integration;

import github.com.lucaseoliveira.desafiobackcb.adapter.mapper.SellerMapper;
import github.com.lucaseoliveira.desafiobackcb.adapter.out.persistence.entity.SellerEntity;
import github.com.lucaseoliveira.desafiobackcb.adapter.out.persistence.repository.SellerRepository;
import github.com.lucaseoliveira.desafiobackcb.application.core.domain.Seller;
import github.com.lucaseoliveira.desafiobackcb.application.core.ports.out.InsertSellerPort;
import org.springframework.stereotype.Component;

@Component
public class InsertSellerAdapter  implements InsertSellerPort {
    SellerRepository sellerRepository;
    public InsertSellerAdapter(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public Seller createSeller(Seller seller) {
        SellerEntity sellerEntity = new SellerEntity(seller.taskId(), seller.name(), seller.birthDate(),seller.cpfCnpj(),
                seller.email(),seller.hiringType(), seller.branch().id());
        return SellerMapper.toDomain(sellerRepository.save(sellerEntity));
    }
}
