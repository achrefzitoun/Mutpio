package com.mutpio.pfe.Repositories;

import com.mutpio.pfe.Entities.Beneficiare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBeneficiareRepository extends JpaRepository<Beneficiare,Long> {
}
