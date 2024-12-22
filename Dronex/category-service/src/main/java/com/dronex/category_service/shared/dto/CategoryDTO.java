package com.dronex.category_service.shared.dto;


import lombok.Data;

@Data
public class CategoryDTO {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private  String name;

}
