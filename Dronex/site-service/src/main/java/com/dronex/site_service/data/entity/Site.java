package com.dronex.site_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@Table(name = "site")

public class Site {


    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;


    @NonNull
    @Size(min = 1, message = "Name cannot be empty")
    private  String name;
}
