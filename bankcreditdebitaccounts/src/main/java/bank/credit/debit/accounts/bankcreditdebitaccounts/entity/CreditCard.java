package bank.credit.debit.accounts.bankcreditdebitaccounts.entity;

import jakarta.persistence.*;

@Entity
@Table(name="CREDIT_CARD")
public class CreditCard extends Account {
    @Id
    @Column(name="ID")
    private String id;
    @ManyToOne
    @JoinColumn(name="CREDIT_ACCOUNT_ID")
    private CreditAccount credit;
}

