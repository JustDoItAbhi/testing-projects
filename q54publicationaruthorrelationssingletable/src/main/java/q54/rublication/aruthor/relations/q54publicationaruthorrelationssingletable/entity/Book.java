package q54.rublication.aruthor.relations.q54publicationaruthorrelationssingletable.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue("book")
public class Book extends Publication {
    @Column(name="NUMBER_OF_PAGES")
    private Integer numberOfPages;
    @Column(name="COST")
    private Double cost;
}
