package category.category.service;
import category.category.modles.Category;
import category.category.repo.CategoryRepository;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StorageCategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepo;
    @Override
    public Category addCategory( Category category) {
//        Optional<Category> existingCategory=categoryRepo.findById(category.getId());
//        if(existingCategory.isPresent()){
//            throw new RuntimeException(" CATEGORY ALREADY EXISTS"+ category.getId());
//        }
        Category savingCategory=new Category();
        savingCategory.setId(category.getId());
        savingCategory.setName(category.getName());
        savingCategory.setDescription(category.getDescription());
        savingCategory.setIsPremium(category.getIsPremium());
        categoryRepo.save(savingCategory);
        //Add your implementation here.
        return savingCategory;
    }

    public List<Category> getAllPremiumCategories() {
        //Add your implementation here.
        List<Category>categoryList=categoryRepo.getPremiumCategories();

        return categoryList;
    }

    public List<Category> getCategoriesBetweenIds(Long categoryId1,Long categoryId2) {
        //Add your implementation here.
        List<Category>categoryList=categoryRepo.findAll();
        Optional<Category> existingCategory1=categoryRepo.findById(categoryId1);
        Optional<Category> existingCategory2=categoryRepo.findById(categoryId2);
        if(existingCategory1.isEmpty()|| existingCategory2.isEmpty()){
            throw new RuntimeException(" CATEGORY ALREADY EXISTS");
        }

        return categoryRepo.findByIdBetweens(categoryId1,categoryId2);
    }


    public List<Category> getCategoriesWithMatchingName(String categoryName) {

        //Add your implementation here.
        return categoryRepo.findByName(categoryName);
//        return categoryRepo.findByNameContainingIgnoreCase(categoryName);
    }

    @Override
    public List<Category> getList() {
        List<Category>categoryList=categoryRepo.findAll();
        return categoryList;
    }
}
