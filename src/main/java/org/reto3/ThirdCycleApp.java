package org.reto3;

import org.apache.tomcat.jni.Address;
import org.reto3.entities.Category;
import org.reto3.entities.Farm;
import org.reto3.repositories.CategoryRepository;
import org.reto3.repositories.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThirdCycleApp {

//    @Autowired CategoryRepository categoryRepository;
//    @Autowired FarmRepository farmRepository;
    public static void main(String[] args) {
        System.out.println("Beginning Properly!");
        SpringApplication.run(ThirdCycleApp.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception
//    {
//        Category category = new Category();
//        categoryRepository.save (category);
//        Farm farm = new Farm();
//        farmRepository.save (farm);
//    }
}