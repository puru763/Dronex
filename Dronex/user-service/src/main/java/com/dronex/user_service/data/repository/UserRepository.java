package com.dronex.user_service.data.repository;


import com.dronex.user_service.data.entity.User;
import com.dronex.user_service.shared.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository   extends JpaRepository<User ,UUID > {
    Optional<User> findByEmail(String email);
    Optional<User> findById(UUID id);

    Optional<List<UserDTO>> findDroneByUserId(UUID userId);

    Optional<List<UserDTO>> findSitesByUserId(UUID userId);
}
