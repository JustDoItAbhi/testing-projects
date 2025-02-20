package q54.rublication.aruthor.relations.q54publicationaruthorrelationssingletable.entity;

import jakarta.persistence.*;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.List;
@Entity
@DiscriminatorValue("AUTHOR")
//@Table(name = "AUTHOR")
public  class Author extends Publication{
    @Id
    @Column(name="ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "PUBLICATIONS_AUTHORS",
            joinColumns = @JoinColumn(name="AUTHOR_ID"),
            inverseJoinColumns = @JoinColumn(name="publication_id"))
    private List<Publication> publications;
}
