package com.mutpio.pfe.Repositories;

import com.mutpio.pfe.Entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompteRepository extends JpaRepository<Compte,Long> {
}
