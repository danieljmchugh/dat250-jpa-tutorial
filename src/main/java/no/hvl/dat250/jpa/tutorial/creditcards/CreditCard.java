package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private Integer creditLimit;
    private Integer balance;
    
    @ManyToOne
    private Bank owningBank;
    
    @ManyToOne
    private Pincode pincode;
}
