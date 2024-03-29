package github.com.lucaseoliveira.desafiobackcb.adapter.out.persistence.repository;

import github.com.lucaseoliveira.desafiobackcb.adapter.out.persistence.entity.SellerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends CrudRepository<SellerEntity, Long> {
}
