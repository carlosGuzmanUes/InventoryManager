package com.nothing.none.repository;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nothing.none.model.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, UUID> {
    
}
