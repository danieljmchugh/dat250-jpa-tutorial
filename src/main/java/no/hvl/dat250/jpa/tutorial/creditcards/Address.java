package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Set;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private Integer number;
    
    @ManyToMany(mappedBy = "addresses")
    private Collection<Customer> owners = new ArrayList<>();;

    public Set getOwners() {
        return Set.copyOf(owners);
    }
}
