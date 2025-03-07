package question57.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import question57.repository.CategoryRepo;

import java.util.List;
@Service
public class CategoryServiceImpl {
    @Autowired
    private CategoryRepo categoryRepo;

    public List<String> getNamesOfAllCategoriesAndLinkedProductsAndTheirImages() {
        return null;
    }

    public List<String> getNamesOfAllCategoriesAndTheirSubCategories() {
        return null;
    }
}
