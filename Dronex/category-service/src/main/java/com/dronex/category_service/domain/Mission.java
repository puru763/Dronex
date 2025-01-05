package com.dronex.category_service.domain;

import java.util.List;
import java.util.UUID;

public class Mission {
    private UUID id;

    private  UUID siteId;
    private UUID droneId;
    private List<String> waypoints;
    private UUID categoryId;
}
