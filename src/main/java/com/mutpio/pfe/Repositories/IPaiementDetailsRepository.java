package com.mutpio.pfe.Repositories;

import com.mutpio.pfe.Entities.PaiementDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaiementDetailsRepository extends JpaRepository<PaiementDetails,Long> {
}
