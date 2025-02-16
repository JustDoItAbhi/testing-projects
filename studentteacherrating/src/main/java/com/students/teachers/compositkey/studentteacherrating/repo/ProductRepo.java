package org.example.evaluations.evaluation.repos;

import java.util.Date;
import java.util.List;

import com.students.teachers.compositkey.studentteacherrating.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;
@Repository
public interface ProductRepo extends JpaRepository<Products,Long> {
    //1. find product by product name
    List<Products> findByName(String name);

    //2. delete by id
    void deleteById(long id);

    //3. delete all
    void deleteAll();

    //4. delete by name and retrun count of deleted product
    long deleteByName(String name);

    //5. Delete Products with specific Category Name
    @Transactional
    @Modifying
    @Query("DELETE FROM Product p WHERE p.category.name=:categoryName")
    void deleteByCategoryName(@Param("categoryName") String categoryName);

    // write query for below
    //6. delete product if id ==categoryid , method name void, deleteproductwhereidmetchescategoryid(long categoryid)
    @Transactional
    @Modifying
    @Query("DELETE FROM Product p WHERE p.category.id= :categoryId")
    void deleteProductWhereIdMatchesCategoryId(@Param("categoryId")  long categoryId);

    @Transactional
    @Modifying
    @Query("DELETE FROM Product p WHERE p.createdAt < :retainDate")
    int retainProductsAfter(@Param("retainDate") Date retainDate);

    // get the delete count of products return type
/*
 * If all products belonging to particular Category are deleted, ultimately, that category should also get deleted. Similarly if we are onboarding a new product and if category is not present in DB already, a new Category should also get created along with Product. To make sure, both of these happen, you need to make some changes into Product Class. Please do that as part of this assignment.
You are also provided with CategoryRepo Nothing need to be done in it.
 */
}
