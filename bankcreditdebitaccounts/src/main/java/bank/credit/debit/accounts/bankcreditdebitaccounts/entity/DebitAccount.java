package bank.credit.debit.accounts.bankcreditdebitaccounts.entity;

import jakarta.persistence.*;

@Entity
@Table(name="DEBIT_ACCOUNT")
public class DebitAccount extends Account {
    @OneToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private DebitCard debitCard;
    @Column(name="BALANCE")
    private double balance;
}

