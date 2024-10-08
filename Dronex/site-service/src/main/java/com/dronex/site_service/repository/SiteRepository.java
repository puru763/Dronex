package com.dronex.site_service.repository;

import com.dronex.site_service.dto.SiteDTO;
import com.dronex.site_service.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface SiteRepository extends JpaRepository<Site, UUID> {

    SiteDTO createSite(SiteDTO siteDTO);

    List<SiteDTO> getSiteByUser(UUID userId);

    Optional<SiteDTO> findName();
}
