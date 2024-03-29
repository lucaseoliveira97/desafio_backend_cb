package github.com.lucaseoliveira.desafiobackcb.adapter.in.rest.dto;

import java.time.LocalDate;

public record GetSellerDto(Long id,
                           String registration,
                           String name,
                           LocalDate birthDate,
                           String cpfCnpj,
                           String email,
                           String hiringType,
                           GenericBranchDto branch) {
}