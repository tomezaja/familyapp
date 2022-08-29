package com.familyapp.grocery;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.familyapp.lunch.Lunch;

import lombok.Data;

@Entity
@Table(name = "groceries")
@Data
public class Grocery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String unit;
    @ManyToOne
    @JoinColumn(name = "grocery_id")
    private Grocery grocery;

    @ManyToMany
    @JoinTable(
      name = "go_to_lunch", 
      joinColumns = @JoinColumn(name = "grocery_id"), 
      inverseJoinColumns = @JoinColumn(name = "lunch_id"))
    Set<Lunch> lunchs; 
}