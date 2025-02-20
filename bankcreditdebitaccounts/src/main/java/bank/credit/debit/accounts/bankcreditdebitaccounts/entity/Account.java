package bank.credit.debit.accounts.bankcreditdebitaccounts.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ACCOUNT")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @Column(name="OWNER")
    private String owner;
}

