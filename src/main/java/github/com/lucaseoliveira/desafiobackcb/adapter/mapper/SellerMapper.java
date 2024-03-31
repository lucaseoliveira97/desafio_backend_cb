package github.com.lucaseoliveira.desafiobackcb.adapter.mapper;

import github.com.lucaseoliveira.desafiobackcb.adapter.out.persistence.entity.BranchEntity;
import github.com.lucaseoliveira.desafiobackcb.adapter.out.persistence.entity.SellerEntity;
import github.com.lucaseoliveira.desafiobackcb.application.core.domain.Branch;
import github.com.lucaseoliveira.desafiobackcb.application.core.domain.Seller;

public class SellerMapper {
    static public Seller toDomain(SellerEntity sellerEntity)
    {
        BranchEntity branchEntity = sellerEntity.getBranch();
        return new Seller(sellerEntity.getId(),sellerEntity.getTaskId(),sellerEntity.getName(), sellerEntity.getBirthDate(),
                sellerEntity.getCpfCnpj(), sellerEntity.getEmail(), sellerEntity.getHiringType(),
                new Branch(branchEntity.getId(), branchEntity.getName(),branchEntity.getCnpj(),branchEntity.getCity(),
                        branchEntity.getUf(),branchEntity.getType(), branchEntity.isActive(), branchEntity.getRegistrationDate(),
                        branchEntity.getRegistrationDate()));
    }

}
