package github.com.lucaseoliveira.desafiobackcb.adapter.in.rest.dto;

import github.com.lucaseoliveira.desafiobackcb.application.core.domain.Branch;
import github.com.lucaseoliveira.desafiobackcb.application.core.domain.Seller;

import java.time.LocalDate;

public record CreateSellerDto(String registration,
                              String name,
                              LocalDate birthDate,
                              String cpfCnpj,
                              String email,
                              String hiringType,
                              Long branchId) {

    static public Seller toDomain(CreateSellerDto createSellerDto)
    {
        return new Seller(null, createSellerDto.registration,createSellerDto.name,createSellerDto.birthDate,createSellerDto.cpfCnpj,
                createSellerDto.email,createSellerDto.hiringType,new Branch(createSellerDto.branchId));
    }
}
