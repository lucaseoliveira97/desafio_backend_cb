package github.com.lucaseoliveira.desafiobackcb.application.core.domain;

import github.com.lucaseoliveira.desafiobackcb.adapter.in.rest.dto.GenericBranchDto;

import java.time.LocalDate;
import java.util.Date;


public record Seller(Long id,
                     String registration,
                     String name,
                     LocalDate birthDate,
                     String cpfCnpj,
                     String email,
                     String hiringType,
                     Branch branch) {
}