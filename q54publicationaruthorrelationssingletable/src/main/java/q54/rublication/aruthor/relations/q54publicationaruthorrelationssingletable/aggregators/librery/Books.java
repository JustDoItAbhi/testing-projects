package q54.rublication.aruthor.relations.q54publicationaruthorrelationssingletable.aggregators.products.librery;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Books {
    private String title;
    private String author;
    private int ISBN;

    public Books(String title, String author, int ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }
}
