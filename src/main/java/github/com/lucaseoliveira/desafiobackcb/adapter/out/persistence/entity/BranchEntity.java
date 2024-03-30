package github.com.lucaseoliveira.desafiobackcb.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.rmi.server.UID;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Table(name = "branches")
public class BranchEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    String name;
    String cnpj;
    String city;
    String uf;
    String type;
    boolean active;
    LocalDateTime registrationDate;
    LocalDateTime lastUpdate;
    @OneToMany(mappedBy="branch")
    private List<SellerEntity> sellers;
    public BranchEntity(Long id)
    {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getCity() {
        return city;
    }

    public String getUf() {
        return uf;
    }

    public String getType() {
        return type;
    }

    public boolean isActive() {
        return active;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

}
