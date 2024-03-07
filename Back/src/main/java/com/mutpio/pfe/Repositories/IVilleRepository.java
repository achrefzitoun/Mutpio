package com.mutpio.pfe.Repositories;

import com.mutpio.pfe.Entities.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVilleRepository extends JpaRepository<Ville,Long> {
}
