package github.com.lucaseoliveira.desafiobackcb.adapter.out.persistence.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Table(name = "sellers")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class SellerEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String registration;
    @Column(nullable = false)
    private String name;
    private LocalDate birthDate;
    @Column(nullable = false)
    private String cpfCnpj;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String hiringType;
    @ManyToOne
    @JoinColumn(name = "branch_id")
    private BranchEntity branch;

    public Long getId() {
        return id;
    }

    public String getRegistration() {
        return registration;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getEmail() {
        return email;
    }

    public String getHiringType() {
        return hiringType;
    }
    public BranchEntity getBranch() {
        return branch;
    }
}
