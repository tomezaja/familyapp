package com.familyapp.car;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.familyapp.reservation.Reservation;

import lombok.Data;

@Entity
@Table(name="cars")
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name; 
    private String serviceDate;
    @OneToMany(mappedBy = "cars")
    private List<Reservation> reservations;
}
