package com.dronex.site_service.shared.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SiteDTO {


    @NotEmpty(message = "Site name   can not be a null or empty")
    private  String name;

    public SiteDTO(String message, String serviceUnavailable) {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
