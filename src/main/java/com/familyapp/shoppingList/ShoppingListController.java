package com.familyapp.shoppingList;

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
public class ShoppingListController {

    private IShoppingListService shoppingListService;

    public ShoppingListController(IShoppingListService sls) {
            super();
            this.shoppingListService = sls;
    }

    @GetMapping("/shoppingLists")
    public List<ShoppingList> findAll() {
        List<ShoppingList> shoppingLists = this.shoppingListService.findAll();
        return shoppingLists;
    }

    @GetMapping("/shoppingLists/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        ShoppingList shoppingList = this.shoppingListService.findById(id);
        if(shoppingList == null){
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("ShoppingList not found");
        }
        return ResponseEntity.ok(shoppingList);

    }

    @DeleteMapping("/shoppingLists/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean success = this.shoppingListService.delete(id);
        if(!success) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("ShoppingList not found");
        }
        return ResponseEntity.ok(true);
    }

    @PostMapping("/shoppingLists")
    public ResponseEntity<?> create(@RequestBody ShoppingList shoppingList){
        ShoppingList newShoppingList = this.shoppingListService.create(shoppingList);
        return ResponseEntity.ok(newShoppingList);
    }
  
    @PutMapping("/shoppingLists/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ShoppingList formData) {
        ShoppingList updatedShoppingList = this.shoppingListService.update(id, formData);
        if(updatedShoppingList == null){
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("ShoppingList not found");
        }
        return ResponseEntity.ok(updatedShoppingList);
    }
}