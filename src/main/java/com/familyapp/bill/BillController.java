package com.familyapp.bill;

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
public class BillController {

    private IBillService billService;

    public BillController(IBillService bs) {
            super();
            this.billService = bs;
    }

    @GetMapping("/api/bills")
    public List<Bill> findAll() {
        List<Bill> bills = this.billService.findAll();
        return bills;
    }

    @GetMapping("/api/bills/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Bill bill = this.billService.findById(id);
        if(bill == null){
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Bill not found");
        }
        return ResponseEntity.ok(bill);

    }

    @DeleteMapping("/api/bills/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean success = this.billService.delete(id);
        if(!success) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Bill not found");
        }
        return ResponseEntity.ok(true);
    }

    @PostMapping("/api/bills")
    public ResponseEntity<?> create(@RequestBody Bill bill){
        Bill newBill = this.billService.create(bill);
        return ResponseEntity.ok(newBill);
    }
  
    @PutMapping("/api/bills/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Bill formData) {
        Bill updatedBill = this.billService.update(id, formData);
        if(updatedBill == null){
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Bill not found");
        }
        return ResponseEntity.ok(updatedBill);
    }
}  