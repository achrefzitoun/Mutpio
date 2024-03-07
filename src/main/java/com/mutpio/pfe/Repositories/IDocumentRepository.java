package com.mutpio.pfe.Repositories;

import com.mutpio.pfe.Entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocumentRepository extends JpaRepository<Document,Long> {
}
