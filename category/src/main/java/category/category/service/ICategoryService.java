package category.category.service;

import category.category.modles.Category;

import java.util.List;

public interface ICategoryService {
    Category addCategory(Category category);

    List<Category> getAllPremiumCategories();

    List<Category> getCategoriesBetweenIds(Long categoryId1,Long categoryId2);

    List<Category> getCategoriesWithMatchingName(String categoryName);
    List<Category>getList();
}
