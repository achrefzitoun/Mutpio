package com.mutpio.pfe.Repositories;

import com.mutpio.pfe.Entities.Tarificateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITarificateurRepository extends JpaRepository<Tarificateur,Long> {
}
