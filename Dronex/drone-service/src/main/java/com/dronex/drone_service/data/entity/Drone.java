//package com.dronex.drone_service.data.entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import lombok.*;
//import org.hibernate.annotations.UuidGenerator;
//
//import java.util.UUID;
//
//@Entity
//@Getter
//@Setter
//@ToString
//@AllArgsConstructor
//@NoArgsConstructor
//@Table(name = "drone")
//public class  Drone {
//
//
//    @Id
//    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
//    private UUID id;
//
//    private  String name;
//
//    private  UUID siteId;
//
//
//
//    public UUID getId() {
//        return id;
//    }
//
//    public void setId(UUID id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public UUID getSiteId() {
//        return siteId;
//    }
//
//    public void setSiteId(UUID siteId) {
//        this.siteId = siteId;
//    }
//
//
//}


package com.dronex.drone_service.data.entity;

import com.dronex.drone_service.domain.Mission;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "drone")
public class Drone {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;

    private String name;


    @Column(name = "site_id", nullable = false)
    private UUID siteId;

    @OneToMany(mappedBy = "drone")
    private List<Mission> missions;
}