package com.familyapp.reservation;

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
public class ReservationController {
    private IReservationService reservationService;

    public ReservationController(IReservationService rs) {
            super();
            this.reservationService = rs;
    }

    @GetMapping("/api/reservations")
    public List<Reservation> findAll() {
        List<Reservation> reservations = this.reservationService.findAll();
        return reservations;
    }

    @GetMapping("/api/reservations/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Reservation reservation = this.reservationService.findById(id);
        if(reservation == null){
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("reservation not found");
        }
        return ResponseEntity.ok(reservation);

    }

    @DeleteMapping("/api/reservations/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean success = this.reservationService.delete(id);
        if(!success) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("reservation not found");
        }
        return ResponseEntity.ok(true);
    }

    @PostMapping("/api/reservations")
    public ResponseEntity<?> create(@RequestBody Reservation reservation){
        Reservation newReservation = this.reservationService.create(reservation);
        return ResponseEntity.ok(newReservation);
    }
  
    @PutMapping("/api/reservations/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Reservation formData) {
        Reservation updatedReservation = this.reservationService.update(id, formData);
        if(updatedReservation == null){
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("reservation not found");
        }
        return ResponseEntity.ok(updatedReservation);
    }
}
