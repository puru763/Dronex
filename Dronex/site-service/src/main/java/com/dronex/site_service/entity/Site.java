package com.dronex.site_service.entity;

import lombok.Data;

import java.util.UUID;

@Data
public class Site {
    private UUID ID;
    private  String name;
}
