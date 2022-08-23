package com.gft.wineshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gft.wineshop.models.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
}
