package github.com.lucaseoliveira.desafiobackcb.adapter.out.persistence.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "sellers")
public class Seller {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    String registration;
    @Column(nullable = false)
    String name;
    Date birthDate;
    @Column(nullable = false)
    String cpfCnpj;
    @Column(nullable = false)
    String email;
    @Column(nullable = false)
    String hiringType;
    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;
}
