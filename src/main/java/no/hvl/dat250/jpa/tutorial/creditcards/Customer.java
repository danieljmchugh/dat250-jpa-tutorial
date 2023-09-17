package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import java.util.ArrayList;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    private Collection<Address> addresses = new ArrayList<>();
    
    @ManyToMany
    private Collection<CreditCard> creditCards = new ArrayList<>();
}
