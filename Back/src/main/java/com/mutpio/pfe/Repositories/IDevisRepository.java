package com.mutpio.pfe.Repositories;

import com.mutpio.pfe.Entities.Devis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDevisRepository extends JpaRepository<Devis,Long> {
}
