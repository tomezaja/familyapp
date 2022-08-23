package com.familyapp.lunch;

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
public class LunchController {
    private ILunchService lunchService;

    public LunchController(ILunchService ls) {
            super();
            this.lunchService = ls;
    }

    @GetMapping("/api/lunchs")
    public List<Lunch> findAll() {
        List<Lunch> lunchs = this.lunchService.findAll();
        return lunchs;
    }

    @GetMapping("/api/lunchs/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Lunch lunch = this.lunchService.findById(id);
        if(lunch == null){
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Lunch not found");
        }
        return ResponseEntity.ok(lunch);

    }

    @DeleteMapping("/api/lunch/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean success = this.lunchService.delete(id);
        if(!success) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("lunch not found");
        }
        return ResponseEntity.ok(true);
    }

    @PostMapping("/api/lunchs")
    public ResponseEntity<?> create(@RequestBody Lunch lunch){
        Lunch newLunch = this.lunchService.create(lunch);
        return ResponseEntity.ok(newLunch);
    }
  
    @PutMapping("/api/lunchs/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Lunch formData) {
        Lunch updatedLunch = this.lunchService.update(id, formData);
        if(updatedLunch == null){
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("lunch not found");
        }
        return ResponseEntity.ok(updatedLunch);
    }
}
