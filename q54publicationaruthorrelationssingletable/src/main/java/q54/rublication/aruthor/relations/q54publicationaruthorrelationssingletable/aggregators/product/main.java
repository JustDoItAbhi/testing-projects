package q54.rublication.aruthor.relations.q54publicationaruthorrelationssingletable.aggregators.products.product;

import q54.rublication.aruthor.relations.q54publicationaruthorrelationssingletable.aggregators.products.librery.Books;
import q54.rublication.aruthor.relations.q54publicationaruthorrelationssingletable.aggregators.products.librery.Library;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {


        Products products = new Products("phone", 500);
        Products products1 = new Products("phone1", 100);
        Products products2 = new Products("phone2", 100);
        Products products3 = new Products("phone3", 100);
        Products products4 = new Products("phone4", 100);
        Products products5 = new Products("phone5", 100);
        List<Products> productsList = new ArrayList<>();
        productsList.add(products);
        productsList.add(products1);
        productsList.add(products2);
        productsList.add(products3);
        productsList.add(products4);
        productsList.add(products5);
        Subscribe subscribe=new Subscribe(productsList);
       long ans= subscribe.calculateTotalPrice();
//        System.out.println("total "+ans);

        Books books=new Books("conjuring","john",1);
        Books books1=new Books("tarzan","johnny",2);
        Books books2=new Books("ghost","wick",3);
        List<Books>booksList=new ArrayList<>();
        booksList.add(books1);
        booksList.add(books);
        booksList.add(books2);

        Library library=new Library(booksList);
        System.out.println(library.findByTitle("tarzan"));


    }
}