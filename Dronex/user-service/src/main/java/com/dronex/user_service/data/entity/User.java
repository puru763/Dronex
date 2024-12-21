package com.dronex.user_service.data.entity;


import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;


    @NotNull
     private String username;

    @NotNull
    private String passwordHash;

    @NotNull
    private String email;


    @NotNull
    private String mobileNumber;


    @ElementCollection
    private List<UUID> droneIds;

    @ElementCollection
    private List<UUID> siteIds;
}