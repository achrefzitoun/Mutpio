package com.mutpio.pfe.Repositories;

import com.mutpio.pfe.Entities.RisqueLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRisqueLevelRepository extends JpaRepository<RisqueLevel,Long> {
}
