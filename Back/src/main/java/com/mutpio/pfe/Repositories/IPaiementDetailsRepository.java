package com.mutpio.pfe.Repositories;

import com.mutpio.pfe.Entities.PaiementDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaiementDetailsRepository extends JpaRepository<PaiementDetails,Long> {
}
