package com.students.teachers.compositkey.studentteacherrating;

import com.students.teachers.compositkey.studentteacherrating.models.Categorys;
import com.students.teachers.compositkey.studentteacherrating.models.Products;
import com.students.teachers.compositkey.studentteacherrating.repo.CategoryRepo;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ProductRepoTest {

    @Autowired
    private org.example.evaluations.evaluation.repos.ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;


    @Test
    @Transactional
    void testDeleteById() {
        //Arrange
        Products product = new Products();
        product.setName("Tablet");
        product.setId(25L);
        Products savedProduct = productRepo.save(product);

        //Act
        productRepo.deleteById(savedProduct.getId());

        //Assert
        Optional<Products> deletedProduct = productRepo.findById(savedProduct.getId());
        assert(deletedProduct.isEmpty());
    }

    @Test
    @Transactional
    void testDeleteAll() {
        //Arrange
        Categorys category = new Categorys();
        category.setName("Electronics");
        category.setId(1L);
        Categorys savedCategory = categoryRepo.save(category);

        Products product1 = new Products();
        product1.setName("Laptop");
        product1.setCategory(savedCategory);
        product1.setId(22L);
        productRepo.save(product1);

        Products product2 = new Products();
        product2.setName("Smartphone");
        product2.setCategory(savedCategory);
        product2.setId(42L);
        productRepo.save(product2);

        //Act
        productRepo.deleteAll();

        //Assert
        long count = productRepo.count();
        assertEquals(0,count);
    }

    @Test
    @Transactional
    void testDeleteByName() {
        //Arrange
        Products product = new Products();
        product.setName("Monitor");
        product.setId(28L);
        productRepo.save(product);

        //Act
        Long deletedCount = productRepo.deleteByName("Monitor");

        //Assert
        assertThat(deletedCount).isEqualTo(1);
        List<Products> deletedProducts = productRepo.findByName("Monitor");
        assertEquals(0,deletedProducts.size());
    }

    @Test
    @Transactional
    void testDeleteByCategoryName() {
        //Arrange
        Categorys category = new Categorys();
        category.setName("Accessories");
        category.setId(5L);
        Categorys savedCategory = categoryRepo.save(category);

        Products product1 = new Products();
        product1.setName("Headphones");
        product1.setId(32L);
        product1.setCategory(savedCategory);
        productRepo.save(product1);

        Products product2 = new Products();
        product2.setName("Charger");
        product2.setId(52L);
        product2.setCategory(savedCategory);
        productRepo.save(product2);

        //Act
        productRepo.deleteByCategoryName("Accessories");

        //Assert
        long count = productRepo.count();
        assertEquals(0,count);
    }

    @Test
    @Transactional
    void testDeleteCategoriesWhereIdMatchesProductId() {
        //Arrange
        Categorys category = new Categorys();
        category.setName("Gaming");
        category.setId(10L);
        Categorys savedCategory = categoryRepo.save(category);

        Products product = new Products();
        product.setName("Console");
        product.setId(10L);
        product.setCategory(savedCategory);
        productRepo.save(product);

        //Act
        productRepo.deleteProductWhereIdMatchesCategoryId(savedCategory.getId());

        //Assert
        long count = productRepo.count();
        assertEquals(0,count);
    }

    @Test
    @Transactional
    void testDeleteCategoriesWhereIdDoesntMatchesAnyProductId() {
        //Arrange
        Categorys category = new Categorys();
        category.setName("Gaming");
        category.setId(10L);
        Categorys savedCategory = categoryRepo.save(category);

        Products product = new Products();
        product.setName("Console");
        product.setId(107L);
        product.setCategory(savedCategory);
        productRepo.save(product);

        Products product2 = new Products();
        product2.setName("Console");
        product2.setId(117L);
        product2.setCategory(savedCategory);
        productRepo.save(product2);

        //Act
        productRepo.deleteProductWhereIdMatchesCategoryId(savedCategory.getId());

        //Assert
        long count = productRepo.count();
        assertEquals(2,count);
    }

    @Test
    @Transactional
    void testRetainProductsAfter() {
        Products product1 = new Products();
        product1.setName("Old Product");
        product1.setId(1212L);
        product1.setCreatedAt(new Date(System.currentTimeMillis() - 10000000L));
        productRepo.save(product1);

        Products product2 = new Products();
        product2.setName("New Product");
        product2.setId(2121L);
        product2.setCreatedAt(new Date());
        productRepo.save(product2);

        Date retainDate = new Date(System.currentTimeMillis() - 5000000L);

        int deletedCount = productRepo.retainProductsAfter(retainDate);

        assertThat(deletedCount).isGreaterThan(0);

        List<Products> remainingProducts = productRepo.findAll();
        assertThat(remainingProducts).allMatch(product -> product.getCreatedAt().after(retainDate));
    }

    @Test
    @Transactional
    void testDeletingAllProductsBelongingToParticularCategoryAlsoResultInDeletionOfCategory() {
        //Arrange
        Categorys category = new Categorys();
        category.setName("Gaming");
        category.setId(10101L);

        Products product = new Products();
        product.setName("Console");
        product.setId(10700L);
        product.setCategory(category);
        productRepo.save(product);


        //Act
        productRepo.deleteById(10700L);

        //Assert
        long productCount = productRepo.count();
        long categoryCount = categoryRepo.count();
        assertEquals(0,productCount);
        assertEquals(0,categoryCount);
    }
}

