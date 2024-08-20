package com.banyuijio.auth.repository;

import com.banyuijio.auth.entity.UserInternal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserInternalRepository extends JpaRepository<UserInternal, UUID> {

    UserInternal findByUserId(UUID userId);

}
