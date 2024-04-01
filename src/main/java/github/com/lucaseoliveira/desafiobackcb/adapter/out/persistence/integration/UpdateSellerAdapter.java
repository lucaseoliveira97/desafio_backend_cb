package github.com.lucaseoliveira.desafiobackcb.adapter.out.persistence.integration;

import github.com.lucaseoliveira.desafiobackcb.adapter.mapper.SellerMapper;
import github.com.lucaseoliveira.desafiobackcb.adapter.out.persistence.entity.SellerEntity;
import github.com.lucaseoliveira.desafiobackcb.adapter.out.persistence.repository.SellerRepository;
import github.com.lucaseoliveira.desafiobackcb.application.core.domain.Seller;
import github.com.lucaseoliveira.desafiobackcb.application.core.ports.out.UpdateSellerOutPort;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.Optional;

@Component
public class UpdateSellerAdapter implements UpdateSellerOutPort {
    @PersistenceContext
    private EntityManager entityManager;
    SellerRepository sellerRepository;
    public UpdateSellerAdapter(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    @Transactional
    public Seller updateSeller(Long id, Seller seller) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaUpdate<SellerEntity> criteriaUpdate = cb.createCriteriaUpdate(SellerEntity.class);
        Root<SellerEntity> root = criteriaUpdate.from(SellerEntity.class);
        criteriaUpdate.set("name", seller.name());
        criteriaUpdate.where(cb.equal(root.get("id"), id));

        int i = entityManager.createQuery(criteriaUpdate).executeUpdate();

        return null;
    }
}
