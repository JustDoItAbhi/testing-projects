package category.category.controller;

import category.category.modles.Category;
import category.category.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @PostMapping("/create")
    public ResponseEntity<Category> create(@RequestBody Category category){
        return ResponseEntity.ok(categoryService.addCategory(category));
    }
//    @GetMapping("/")
//    public ResponseEntity<List<Category>> getAll(){
//        return ResponseEntity.ok(categoryService.getList());
//    }
    @GetMapping("/")
    public ResponseEntity<List<Category>> getPremium(){
        return ResponseEntity.ok(categoryService.getAllPremiumCategories());
    }
    @GetMapping("/between/{id1}/{id2}")
    public ResponseEntity<List<Category>> getbetween(@PathVariable("id1")Long id1,@PathVariable("id2")Long id2){
        return ResponseEntity.ok(categoryService.getCategoriesBetweenIds(id1,id2));
    }
    @GetMapping("/name")
    public ResponseEntity<List<Category>> getbetween(@RequestParam ("name")String name){
        return ResponseEntity.ok(categoryService.getCategoriesWithMatchingName(name));
    }
}
