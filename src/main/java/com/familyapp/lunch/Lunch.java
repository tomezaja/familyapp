package com.familyapp.lunch;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.familyapp.grocery.Grocery;
import com.familyapp.user.User;

import lombok.Data;

@Entity
@Table(name="lunchs")
@Data
public class Lunch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name; 
    @OneToMany(mappedBy = "lunch")
    private List<User> users;
    @ManyToMany(mappedBy = "lunchs")
    Set<Grocery> groceries;
}
