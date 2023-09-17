package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import no.hvl.dat250.jpa.tutorial.creditcards.*;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
    }

  }

  private static void createObjects(EntityManager em) {
    
    // ------ Pincode ------
    Pincode pincode = new Pincode();
    pincode.setCode("123");
    pincode.setCount(1);

    // ---- Credic cards ----
    CreditCard creditCard1 = new CreditCard();
    creditCard1.setNumber(12345);
    creditCard1.setBalance(-5000);
    creditCard1.setCreditLimit(-10000);
    creditCard1.setPincode(pincode);
    
    CreditCard creditCard2 = new CreditCard();
    creditCard2.setNumber(123);
    creditCard2.setBalance(1);
    creditCard2.setCreditLimit(2000);
    creditCard2.setPincode(pincode);

    Collection<CreditCard> cards = new ArrayList<>();  // This is a mess.....
    cards.add(creditCard1);
    cards.add(creditCard2);
    
    // ------ Bank ------
    Bank bank = new Bank();
    bank.setName("Pengebank");
    bank.setOwnedCards(cards);

    creditCard1.setOwningBank(bank);
    creditCard2.setOwningBank(bank);
  
    // ------ Customer ------
    Customer customer = new Customer();
    customer.setName("Max Mustermann");
    customer.setCreditCards(cards);

    // ------ Addresses ------
    Address address = new Address();
    address.setStreet("Inndalsveien");
    address.setNumber(28);

    
    Collection<Address> addresses = new ArrayList<>();
    addresses.add(address);
    customer.setAddresses(addresses);
    
    Collection<Customer> owners = new ArrayList<>();
    owners.add(customer);
    address.setOwners(owners);

    em.persist(pincode);
    em.persist(creditCard1);
    em.persist(creditCard2);
    em.persist(bank);
    em.persist(customer);
    em.persist(address);
  }
}
