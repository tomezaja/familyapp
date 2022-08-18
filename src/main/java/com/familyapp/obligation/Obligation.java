package com.familyapp.obligation;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.familyapp.user.User;

import lombok.Data;

@Entity
@Table(name = "obligations")
@Data
public class Obligation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private LocalDate date;
    @ManyToMany(mappedBy = "obligations")
    Set<User> users;
}