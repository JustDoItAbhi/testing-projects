package q54.rublication.aruthor.relations.q54publicationaruthorrelationssingletable.aggregators.products.librery;

import lombok.Data;

import java.util.List;
@Data
public class Library {
    List<Books> booksList;

    public Library(List<Books> booksList) {
        this.booksList = booksList;
    }
    public Books findByTitle(String title){
        String bookTatile="";
        Books books1=new Books();
        for(Books books:booksList){
            bookTatile=books.getTitle();
        books1=books;
        }
        return books1;
    }
}
