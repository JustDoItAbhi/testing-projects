package q54.rublication.aruthor.relations.q54publicationaruthorrelationssingletable.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
// @Table(name="BLOG_POST")
@DiscriminatorValue("BlogPost")
public class BlogPost extends Publication {
    @Column(name="URL")
    private String url;
}
