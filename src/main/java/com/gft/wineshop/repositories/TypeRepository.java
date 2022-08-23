package com.gft.wineshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gft.wineshop.models.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type,Integer> {
}
