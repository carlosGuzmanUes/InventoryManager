package com.nothing.none.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nothing.none.model.entity.User;
@Repository

public interface UserRepository extends JpaRepository<User, UUID>{

    Optional<User> findByEmail(String email);


}
