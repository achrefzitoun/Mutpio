package com.mutpio.pfe.Repositories;

import com.mutpio.pfe.Entities.Prospect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProspectRepository extends JpaRepository<Prospect,Long> {
}
