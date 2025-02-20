package bank.credit.debit.accounts.bankcreditdebitaccounts.entity;

import jakarta.persistence.*;

@Entity
@Table(name="DEBIT_CARD")
public class DebitCard {
    @Id
    @Column(name="ID")
    private String id;
    @OneToOne
    @JoinColumn(name="DEBIT_ACCOUNT_ID")
    private DebitAccount debit;
}

