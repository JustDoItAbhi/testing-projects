package category.category.repo;

import category.category.modles.Category;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query("SELECT c FROM Category c WHERE c.isPremium = true")
    List<Category> getPremiumCategories();
    @Query("SELECT c FROM Category c WHERE c.id BETWEEN :id1 AND :id2")
    List<Category> findByIdBetweens(@Param("id1") long id1,@Param("id2")long id2);

    @Query("SELECT c FROM Category c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Category>findByName(@Param("name")String name);


//List<Category>findByNameContainingIgnoreCase(String name);


//List<Category> findByIdBetween( long id1,long id2);
}











