package com.familyapp.grocery;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroceryController {

    private IGroceryService groceryService;

    public GroceryController(IGroceryService gs) {
            super();
            this.groceryService = gs;
    }

    @GetMapping("/groceries")
    public List<Grocery> findAll() {
        List<Grocery> users = this.groceryService.findAll();
        return users;
    }

    @GetMapping("/groceries/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Grocery grocery = this.groceryService.findById(id);
        if(grocery == null){
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Grocery not found");
        }
        return ResponseEntity.ok(grocery);

    }

    @DeleteMapping("/groceries/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean success = this.groceryService.delete(id);
        if(!success) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Grocery not found");
        }
        return ResponseEntity.ok(true);
    }

    @PostMapping("/groceries")
    public ResponseEntity<?> create(@RequestBody Grocery grocery){
        Grocery newGrocery = this.groceryService.create(grocery);
        return ResponseEntity.ok(newGrocery);
    }
  
    @PutMapping("/groceries/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Grocery formData) {
        Grocery updatedGrocery = this.groceryService.update(id, formData);
        if(updatedGrocery == null){
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Grocery not found");
        }
        return ResponseEntity.ok(updatedGrocery);
    }
}