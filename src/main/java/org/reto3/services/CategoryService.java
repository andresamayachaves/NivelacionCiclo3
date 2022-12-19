package org.reto3.services;

import org.reto3.entities.Category;
import org.reto3.entities.Farm;
import org.reto3.entities.Message;
import org.reto3.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    //Attributes
    @Autowired
    private CategoryRepository categoryRepository;

    // CRUD Methods

    public List<Category> getAllCategories() {
        return this.categoryRepository.findAll();
    }

    public Category  getCategoryById(int id){
        if(this.categoryRepository.findById(id).isPresent()){
            return this.categoryRepository.findById(id).get();
        }else{
            return null;
        }
    }

    public Category createCategory(Category category) {
        return this.categoryRepository.save(category);
    }
    public void updateCategory(int idCategory, Category capturedData) {
        Optional<Category> categoryToUpdate =  this.categoryRepository.findById(idCategory);
        if(!categoryToUpdate.isEmpty()) {
            Category categoryDB = categoryToUpdate.get();
            setAllAtts(categoryDB, capturedData);
            this.categoryRepository.save(categoryDB);
        }
    }

    private void setAllAtts(Category fmToUpdate, Category newData){
        if(newData.getName() != null)       fmToUpdate.setName(newData.getName());
        if(newData.getDescription() != null) fmToUpdate.setDescription(newData.getDescription());
    }

    public void deleteCategory(int id) {
        if(!this.categoryRepository.findById(id).isEmpty()){
            this.categoryRepository.deleteById(id );
        }
    }

    public Category completeCategory(Category categoryIn) {
        Category categoryOut = new Category();
        Integer newId = Integer.valueOf( String.valueOf(categoryRepository.count()))+1;
        System.out.println(newId);

        categoryOut.setId(newId);
        categoryOut.setName(categoryIn.getName());
        categoryOut.setDescription(categoryIn.getDescription());
        categoryOut.setFarms(categoryIn.getFarms());
        return categoryOut;
    }
}
