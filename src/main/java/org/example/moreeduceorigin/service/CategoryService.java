package org.example.moreeduceorigin.service;

import org.example.moreeduceorigin.dto.CategoryDto;
import org.example.moreeduceorigin.model.Category;
import org.example.moreeduceorigin.model.Result;
import org.example.moreeduceorigin.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    public List<Category> getAllCategory(){
        return categoryRepo.findAll();
    }

    public Category getById(Long id){
        return categoryRepo.findById(id).get();
    }
    public Result create(CategoryDto categoryDto){
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        categoryRepo.save(category);
        return  new Result(true , "Created");
    }
    public Result update(Long id , CategoryDto categoryDto){
        Optional<Category> byId = categoryRepo.findById(id);
        Category category = byId.get();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        categoryRepo.save(category);
        return  new Result(true , "Updated");
    }
    public Result delete(Long id){
        categoryRepo.deleteById(id);
        return  new Result(true , "Deleted");
    }
}
