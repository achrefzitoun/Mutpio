package com.mutpio.pfe.Repositories;

import com.mutpio.pfe.Entities.Signature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISignatureRepository extends JpaRepository<Signature,Long> {
}
