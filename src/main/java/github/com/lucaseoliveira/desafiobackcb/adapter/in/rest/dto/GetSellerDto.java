package github.com.lucaseoliveira.desafiobackcb.adapter.in.rest.dto;

import github.com.lucaseoliveira.desafiobackcb.application.core.domain.Seller;

import java.time.LocalDate;

public record GetSellerDto(String id,
                           String name,
                           LocalDate birthDate,
                           String cpfCnpj,
                           String email,
                           String hiringType,
                           GenericBranchDto branch) {
    static public GetSellerDto fromDomain(Seller seller)
    {
        return new GetSellerDto(seller.getId(),seller.name(),seller.birthDate(), seller.cpfCnpj(),seller.email(), seller.hiringType(),
                new GenericBranchDto(seller.branch().id(),seller.branch().name(), seller.branch().cnpj(), seller.branch().city(),seller.branch().uf(),
                        seller.branch().type(), seller.branch().active(), seller.branch().registrationDate(),
                        seller.branch().lastUpdate()));
    }
}