package com.gft.wineshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gft.wineshop.models.Wine;

@Repository
public interface WineRepository extends JpaRepository<Wine, Integer> {
}
