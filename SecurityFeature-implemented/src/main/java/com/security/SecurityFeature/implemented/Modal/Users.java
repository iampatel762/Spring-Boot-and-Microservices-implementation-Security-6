package com.security.SecurityFeature.implemented.Modal;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class Users {
    @Id
    private int id;
    private String username;
    private String password;

}
