package q54.rublication.aruthor.relations.q54publicationaruthorrelationssingletable.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CurrentTimestamp;
import q54.rublication.aruthor.relations.q54publicationaruthorrelationssingletable.entity.Author;

@Entity
@Table(name = "PUBLICATION")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "PUBLICATION_TYPE",discriminatorType =DiscriminatorType.STRING)
public abstract class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Version
    @Column(name="VERSION")
    private int version;
    @Column(name = "TITLE")
    private String title;
    @CurrentTimestamp
    @Temporal(TemporalType.DATE)
    private LocalDate publishingDate;

    @ManyToMany(mappedBy = "publications")
    private Set<Author> authors = new HashSet<>();
}
