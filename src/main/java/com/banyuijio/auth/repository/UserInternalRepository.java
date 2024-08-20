package com.banyuijio.auth.repository;

import com.banyuijio.auth.entity.UserInternal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserInternalRepository extends JpaRepository<UserInternal, UUID> {

    UserInternal findByUserId(UUID userId);
    Optional<UserInternal> findByUsername(String userName);

}
