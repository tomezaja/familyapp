package com.familyapp.shoppingList;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.familyapp.grocery.Grocery;

import lombok.Data;

@Entity
@Table(name = "shoppingList")
@Data
public class ShoppingList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double quantity;
    @OneToMany(mappedBy = "shopping_list")
    private List<Grocery> groceries;

}