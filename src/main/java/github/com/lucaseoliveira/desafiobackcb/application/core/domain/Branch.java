package github.com.lucaseoliveira.desafiobackcb.application.core.domain;

import java.time.LocalDateTime;
import java.util.Date;

public record Branch(Long id,
                     String name,
                     String cnpj,
                     String city,
                     String uf,
                     String type,
                     boolean active,
                     LocalDateTime registrationDate,
                     LocalDateTime lastUpdate) {
}
