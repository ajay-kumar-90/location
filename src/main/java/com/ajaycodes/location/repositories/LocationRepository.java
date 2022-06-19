package com.ajaycodes.location.repositories;

import com.ajaycodes.location.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {
    @Query(value="SELECT loc.type, COUNT(loc) FROM Location loc GROUP BY loc.type")
    List<Object[]> findTypeAndTypeCount();


}
