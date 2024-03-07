package com.mutpio.pfe.Repositories;

import com.mutpio.pfe.Entities.ContratResiliation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContratResiliationRepository extends JpaRepository<ContratResiliation,Long> {
}
