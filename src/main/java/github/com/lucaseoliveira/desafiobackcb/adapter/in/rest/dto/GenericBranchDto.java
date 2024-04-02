package github.com.lucaseoliveira.desafiobackcb.adapter.in.rest.dto;

import java.time.LocalDateTime;

public record GenericBranchDto(Long id,
                               String name,
                               String cnpj,
                               String city,
                               String uf,
                               String type,
                               boolean active,
                               LocalDateTime registrationDate,
                               LocalDateTime lastUpdate) {
}
