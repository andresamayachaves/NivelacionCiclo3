package org.reto3.controllers;

import org.reto3.entities.Category;
import org.reto3.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
@RequestMapping("/api/Category")
public class CategoryController {

    //Attributes
    @Autowired
    CategoryService categoryService;

    //Constructor
    public CategoryController(CategoryService categoryService) {this.categoryService = categoryService;}

    //Methods
    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAllCategories(){
        return new ResponseEntity<List<Category>>(this.categoryService .getAllCategories(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Category>  getCategoryById(@PathVariable("id") int id) {
        return new ResponseEntity<Category>(this.categoryService.getCategoryById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<List<Category>> createCategory(@RequestBody Category categ){
        //Category fullCategory = this.categoryService.completeCategory(categ);
        this.categoryService.createCategory(categ);
        return new ResponseEntity<List<Category>>(this.categoryService.getAllCategories(), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<List<Category>> updateCategory(@RequestBody Category category){
        System.out.println("Input  attributes");
        System.out.println("id: " + category.getId());
        System.out.println("name: " + category.getName());
        System.out.println("description: " + category.getDescription());
        this.categoryService.updateCategory(category.getId(), category);
        return new ResponseEntity<List<Category>>(categoryService.getAllCategories(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") int id){
        this.categoryService.deleteCategory(id);
        return new ResponseEntity<String>("Category has been deleted", HttpStatus.NO_CONTENT);
    }
}
