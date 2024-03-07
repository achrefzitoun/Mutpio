package com.mutpio.pfe.Repositories;

import com.mutpio.pfe.Entities.Prospect;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProspectRepository extends JpaRepository<Prospect,Long> {
}
