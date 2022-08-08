package com.familyapp.user;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Integer id;
    private String name;
    private String picture;
    private String birthday;
    private String email;
    private Integer lunchId;

    public User() {
    }

    public User(Integer id, String name, String picture, String birthday, String email, Integer lunchId) {

        this.id = id;
        this.name = name;
        this.picture = picture;
        this.birthday = birthday;
        this.email = email;
        this.lunchId = lunchId;
    }

    public User(String name, String picture, String birthday, String email, Integer lunchId) {
        this.name = name;
        this.picture = picture;
        this.birthday = birthday;
        this.email = email;
        this.lunchId = lunchId;
    }

}
