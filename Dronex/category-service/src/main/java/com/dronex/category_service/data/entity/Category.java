//package com.dronex.category_service.data.entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//import jakarta.validation.constraints.Size;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.NonNull;
//import org.hibernate.annotations.UuidGenerator;
//
//import java.util.UUID;
//
//@Data
//@Entity
//@NoArgsConstructor
//@Table(name = "category")
//public class Category {
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
//    public UUID getSiteID() {
//        return siteID;
//    }
//
//    public void setSiteID(UUID siteID) {
//        this.siteID = siteID;
//    }
//
//    @Id
//    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
//    private UUID id;
//
//    @NonNull
//    @Size(min = 1, message = "Name cannot be empty")
//    private  String name;
//
//
//    private UUID siteID;
//
//}


package com.dronex.category_service.data.entity;

import com.dronex.category_service.domain.Mission;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@Table(name = "category")
public class Category {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;

    @Size(min = 1, message = "Name cannot be empty")
    private String name;

    // Assuming a Category can belong to multiple Missions
    @OneToMany(mappedBy = "category")
    private List<Mission> missions;
}