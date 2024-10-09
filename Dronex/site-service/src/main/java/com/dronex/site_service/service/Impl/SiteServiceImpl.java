package com.dronex.site_service.service.Impl;


import com.dronex.site_service.dto.SiteDTO;
import com.dronex.site_service.entity.Site;
import com.dronex.site_service.exception.SiteAlreadyExistsException;
import com.dronex.site_service.exception.SiteNotExistsException;
import com.dronex.site_service.mapper.SiteMapper;
import com.dronex.site_service.repository.SiteRepository;
import com.dronex.site_service.service.SiteService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class SiteServiceImpl   implements SiteService {


    final SiteRepository siteRepository;
    final SiteMapper siteMapper;

    public SiteServiceImpl(SiteRepository siteRepository, SiteMapper siteMapper) {
        this.siteRepository = siteRepository;
        this.siteMapper = siteMapper;
    }

//    @Override
//    public SiteDTO createSite(SiteDTO siteDTO) {
//        Optional<Site> existingsite = siteRepository.findByName(siteDTO.getName());
//        if (existingsite.isPresent()) {
//            throw new SiteAlreadyExistsException("site  already exists with name " + siteDTO.getName());
//        }
//        Site site = new Site();
//        Site saveSite = siteRepository.save(site);
//        return siteMapper.toDTO(saveSite);
//    }

    @Override
    public SiteDTO createSite(SiteDTO siteDTO) {
        Optional<Site> existingSite = siteRepository.findByName(siteDTO.getName());
        if (existingSite.isPresent()) {
            throw new SiteAlreadyExistsException("Site already exists with name " + siteDTO.getName());
        }
        Site site  = siteMapper.toEntity(siteDTO);
        Site saveSite =  siteRepository.save(site);
        return siteMapper.toDTO(saveSite);

    }

    @Override
    public SiteDTO updateSite(UUID id, SiteDTO siteDTO) {
        Optional<Site> existingSite = siteRepository.findById(id);
        if (!existingSite.isPresent()) {
            throw new SiteNotExistsException("site does not exist with this ID: " + id);
        }
        Site site = existingSite.get();
        siteMapper.updateSite(siteDTO, site);
        Site updatedUser = siteRepository.save(site);
        return siteMapper.toDTO(updatedUser);
    }

    @Override
    public void deletesite(UUID id) {
        Optional<Site> existingUser = siteRepository.findById(id);
        if (!existingUser.isPresent()) {
            throw new SiteNotExistsException("User does not exist with this ID: " + id);
        }
        siteRepository.delete(existingUser.get());
    }
}
