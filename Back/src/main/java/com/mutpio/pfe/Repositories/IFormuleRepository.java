package com.mutpio.pfe.Repositories;

import com.mutpio.pfe.Entities.Formule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFormuleRepository extends JpaRepository<Formule,Long> {
}
