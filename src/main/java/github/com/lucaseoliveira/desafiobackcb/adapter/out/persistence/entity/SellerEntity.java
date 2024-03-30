package github.com.lucaseoliveira.desafiobackcb.adapter.out.persistence.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.rmi.server.UID;
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
    @Column(nullable = false)
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

    public SellerEntity(String registration, String name, LocalDate birthDate,String cpfCnpj, String email, String hiringType, Long branchId)
    {
        this.registration = registration;
        this.name = name;
        this.birthDate = birthDate;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.hiringType = hiringType;
        this.branch = new BranchEntity(branchId);
    }
    public void setId(Long id) {this.id = id;}

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
