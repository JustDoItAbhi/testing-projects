package bank.credit.debit.accounts.bankcreditdebitaccounts.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="CREDIT_ACCOUNT")
@PrimaryKeyJoinColumn(name="ACCOUNT_ID")
public class CreditAccount extends Account{

    @OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    private Set<CreditCard> creditCard = new HashSet<>();

    @Column(name = "INTEREST_RATE")
    private double interestRate;
}




