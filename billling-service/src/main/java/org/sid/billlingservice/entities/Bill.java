package org.sid.billlingservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.billlingservice.model.Customer;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billDate;
    private Long customerId;
    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems;
    @Transient //demander jpa ignoré la class (ce attribut dans la class mais n'est pas dans la bd)
    private Customer customer;
}
