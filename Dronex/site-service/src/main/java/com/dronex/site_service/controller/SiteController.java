package com.dronex.site_service.controller;

import com.dronex.site_service.dto.SiteDTO;
import com.dronex.site_service.entity.Site;
import com.dronex.site_service.exception.InvalidSiteInputException;
import com.dronex.site_service.exception.SiteNotExistsException;
import com.dronex.site_service.repository.SiteRepository;
import com.dronex.site_service.service.SiteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/site")
public class SiteController {


    final SiteRepository siteRepository;
    final SiteService siteService;

    public SiteController(SiteRepository siteRepository, SiteService siteService) {
        this.siteRepository = siteRepository;
        this.siteService = siteService;
    }


    @PostMapping
    ResponseEntity<SiteDTO> createSite(@Valid @RequestBody SiteDTO siteDTO){
       try{
            SiteDTO createSite = siteService.createSite(siteDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createSite);
       }catch (InvalidSiteInputException e ){
                return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
    }


    //i  need  to   do  this   in  client   package   because   it  si  sending   request  in  another   microservice

//    @GetMapping("user/{userId}")
//    ResponseEntity<SiteDTO> getSiteByUser(@Valid @PathVariable UUID siteID, @PathVariable UUID userId) {
//       try{
//           List<SiteDTO> userSites = siteRepository.getSiteByUser(userId);
//       }
//       catch (){
//
//       }
//    }



    @PutMapping
    ResponseEntity<SiteDTO> updateSite( @PathVariable UUID id ,   @RequestBody SiteDTO siteDTO ){
        try {
            SiteDTO updatedUser = siteService.updateSite(id, siteDTO);
            return ResponseEntity.ok(updatedUser);
        } catch (SiteNotExistsException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (InvalidSiteInputException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

   @DeleteMapping
    ResponseEntity<SiteDTO>  deleteSite(@PathVariable UUID  id){
       try {
           siteService.deletesite(id);
           return ResponseEntity.noContent().build();
       } catch (SiteNotExistsException e) {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
   }
}
