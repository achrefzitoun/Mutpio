package com.mutpio.pfe.Repositories;

import com.mutpio.pfe.Entities.RefBancaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRefBancaireRepository extends JpaRepository<RefBancaire,Long> {
}
