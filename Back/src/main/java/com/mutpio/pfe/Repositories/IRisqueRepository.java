package com.mutpio.pfe.Repositories;

import com.mutpio.pfe.Entities.Risque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRisqueRepository extends JpaRepository<Risque,Long> {
}
