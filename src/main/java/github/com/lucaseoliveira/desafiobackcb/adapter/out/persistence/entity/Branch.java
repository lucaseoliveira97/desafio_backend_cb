package github.com.lucaseoliveira.desafiobackcb.adapter.out.persistence.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "branches")
public class Branch {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    String name;
    String cnpj;
    String city;
    String uf;
    String type;
    boolean active;
    Date registrationDate;
    Date lastUpdate;
    @OneToMany(mappedBy="branch")
    private List<Seller> sellers;
}
