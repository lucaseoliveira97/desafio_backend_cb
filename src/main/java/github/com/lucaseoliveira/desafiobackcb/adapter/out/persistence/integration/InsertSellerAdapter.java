package github.com.lucaseoliveira.desafiobackcb.adapter.out.persistence.integration;

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
    public void createSeller(Seller seller) {
        SellerEntity sellerEntity = new SellerEntity(seller.registration(), seller.name(), seller.birthDate(),seller.cpfCnpj(),
                seller.email(),seller.hiringType(), seller.branch().id());
        sellerRepository.save(sellerEntity);
    }
}
