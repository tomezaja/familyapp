package com.familyapp.liabilities;

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
public class LiabilityController {

    private ILiabilityService liabilityService;

    public LiabilityController(ILiabilityService ls) {
            super();
            this.liabilityService = ls;
    }

    @GetMapping("/api/liabilities")
    public List<Liability> findAll() {
        List<Liability> liabilities = this.liabilityService.findAll();
        return liabilities;
    }

    @GetMapping("/api/liabilities/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Liability liability = this.liabilityService.findById(id);
        if(liability == null){
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Liability not found");
        }
        return ResponseEntity.ok(liability);

    }

    @DeleteMapping("/api/liabilities/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean success = this.liabilityService.delete(id);
        if(!success) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Liability not found");
        }
        return ResponseEntity.ok(true);
    }

    @PostMapping("/api/liabilities")
    public ResponseEntity<?> create(@RequestBody Liability liability){
        Liability newLiability = this.liabilityService.create(liability);
        return ResponseEntity.ok(newLiability);
    }
  
    @PutMapping("/api/liabilities/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Liability formData) {
        Liability updatedLiability = this.liabilityService.update(id, formData);
        if(updatedLiability == null){
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Liability not found");
        }
        return ResponseEntity.ok(updatedLiability);
    }
}