package github.com.lucaseoliveira.desafiobackcb.application.core.domain;

import java.time.LocalDate;


public record Seller(Long id,
                     String registration,
                     String name,
                     LocalDate birthDate,
                     String cpfCnpj,
                     String email,
                     String hiringType,
                     Branch branch) {
}