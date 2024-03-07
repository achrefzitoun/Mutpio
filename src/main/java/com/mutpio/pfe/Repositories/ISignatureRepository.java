package com.mutpio.pfe.Repositories;

import com.mutpio.pfe.Entities.Signature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISignatureRepository extends JpaRepository<Signature,Long> {
}
