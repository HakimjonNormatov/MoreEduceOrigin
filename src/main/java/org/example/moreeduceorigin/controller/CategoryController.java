package org.example.moreeduceorigin.controller;

import org.example.moreeduceorigin.dto.AddressDto;
import org.example.moreeduceorigin.dto.CategoryDto;
import org.example.moreeduceorigin.model.Address;
import org.example.moreeduceorigin.model.Category;
import org.example.moreeduceorigin.model.Result;
import org.example.moreeduceorigin.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Category> getAll(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Long id){
        return categoryService.getById(id);
    }

    @PostMapping
    public HttpEntity<?> add(@RequestBody CategoryDto categoryDto){
        Result result = categoryService.create(categoryDto);
        return new ResponseEntity<>(result , HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public HttpEntity<?>put(@RequestBody CategoryDto categoryDto , @PathVariable Long id){
        Result result = categoryService.update(categoryDto, id);
        return new ResponseEntity<>(result , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?>delete(@PathVariable Long id){
        Result result = categoryService.delete(id);
        return new ResponseEntity<>(result , HttpStatus.OK);
    }
}
