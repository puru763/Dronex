package com.dronex.category_service.shared.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CategoryDTO {


    @NotEmpty(message = "Site  Name  can not be a null or empty")
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
