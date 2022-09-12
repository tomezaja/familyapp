package com.familyapp.user;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.familyapp.liabilities.Liability;
import com.familyapp.lunch.Lunch;
import com.familyapp.message.Message;
import com.familyapp.obligation.Obligation;
import com.familyapp.reservation.Reservation;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String username;
    private String password;
    private String picture;
    private LocalDate birthday;
    @OneToMany(mappedBy = "user")
    private List<Message> messages; 
    @OneToMany(mappedBy = "user")
    private List<Liability> liabilities;
    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Lunch lunch;
    @ManyToMany
    @JoinTable(
      name = "user_obligation", 
      joinColumns = @JoinColumn(name = "user_id"), 
      inverseJoinColumns = @JoinColumn(name = "obligation_id"))
    Set<Obligation> obligations; 

}