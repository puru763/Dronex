package com.dronex.site_service.mapper;

import com.dronex.site_service.dto.SiteDTO;
import com.dronex.site_service.entity.Site;

public class SiteMapper {


    public SiteDTO toDTO(Site site) {
        SiteDTO dto = new SiteDTO();
        dto.setName(dto.getName());
        return dto;
    }

    public Site toEntity(SiteDTO dto) {
        Site site = new Site();
        site.setName(dto.getName());
        return site;
    }

    public void updateSite(SiteDTO dto, Site site) {
        if (dto.getName() != null) {
            site.setName(dto.getName());
        }

    }
}
