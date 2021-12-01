package org.example.NC.domain;

import lombok.Data;


import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String login;
    private String password;
    private String surname;
    private String name;
    private String patronymic;
    private String gender;
    private String address;
    private Integer discount;
    private boolean active;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public boolean isActive() {
        return active;
    }
}

