//package com.dronex.mission_service.data.entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import lombok.Data;
//import org.hibernate.annotations.UuidGenerator;
//
//import java.util.List;
//import java.util.UUID;
//
//@Data
//@Entity
//@Table(name = "mission")
//public class Mission {
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
//    public UUID getSiteId() {
//        return siteId;
//    }
//
//    public void setSiteId(UUID siteId) {
//        this.siteId = siteId;
//    }
//
//    public UUID getDroneId() {
//        return droneId;
//    }
//
//    public void setDroneId(UUID droneId) {
//        this.droneId = droneId;
//    }
//
//    public List<String> getWaypoints() {
//        return waypoints;
//    }
//
//    public void setWaypoints(List<String> waypoints) {
//        this.waypoints = waypoints;
//    }
//
//    public UUID getCategoryId() {
//        return categoryId;
//    }
//
//    public void setCategoryId(UUID categoryId) {
//        this.categoryId = categoryId;
//    }
//
//    @Id
//    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
//    private UUID id;
//
//    private  UUID siteId;
//    private UUID droneId;
//    private List<String> waypoints;
//    private UUID categoryId;
//
//}


package com.dronex.mission_service.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mission")
public class Mission {


    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "site_id", nullable = false)
    private @NotEmpty UUID siteID;

    // Foreign key to Drone
    @ManyToOne
    @JoinColumn(name = "drone_id", nullable = false)
    private @NotEmpty UUID droneId;

    // Foreign key to Category
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private @NotEmpty UUID categoryId;

    @ElementCollection
    private List<String> waypoints;


    public void setSiteId(UUID siteId) {
    }

    public @NotEmpty(message = "Site ID cannot be empty") UUID getSiteId() {
        return null;
    }
}