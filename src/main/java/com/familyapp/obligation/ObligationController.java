package com.familyapp.obligation;

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
public class ObligationController {

    private IObligationService obligationService;

    public ObligationController(IObligationService os) {
            super();
            this.obligationService = os;
    }

    @GetMapping("/api/obligations")
    public List<Obligation> findAll() {
        List<Obligation> obligations = this.obligationService.findAll();
        return obligations;
    }

    @GetMapping("/api/obligations/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Obligation obligation = this.obligationService.findById(id);
        if(obligation == null){
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Obligation not found");
        }
        return ResponseEntity.ok(obligation);

    }

    @DeleteMapping("/api/obligations/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean success = this.obligationService.delete(id);
        if(!success) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Obligation not found");
        }
        return ResponseEntity.ok(true);
    }

    @PostMapping("/api/obligations")
    public ResponseEntity<?> create(@RequestBody Obligation obligation){
        Obligation newObligation = this.obligationService.create(obligation);
        return ResponseEntity.ok(newObligation);
    }
  
    @PutMapping("/api/obligations/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Obligation formData) {
        Obligation updatedObligation = this.obligationService.update(id, formData);
        if(updatedObligation == null){
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Obligation not found");
        }
        return ResponseEntity.ok(updatedObligation);
    }
}