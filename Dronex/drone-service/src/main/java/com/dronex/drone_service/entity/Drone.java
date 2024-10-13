package com.dronex.drone_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Data
@Entity
@Table(name = "drone")
public class  Drone {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;


    private  String name;

    private  UUID siteId;

}
