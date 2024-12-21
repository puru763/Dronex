package com.dronex.site_service.service;

import com.dronex.site_service.shared.dto.SiteDTO;

import java.util.UUID;

public interface SiteService {
    SiteDTO createSite(SiteDTO siteDTO);

    SiteDTO updateSite(UUID id, SiteDTO siteDTO);

    void deletesite(UUID id);
}
