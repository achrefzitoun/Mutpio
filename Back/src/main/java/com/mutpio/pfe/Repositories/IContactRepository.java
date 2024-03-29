package com.mutpio.pfe.Repositories;

import com.mutpio.pfe.Entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContactRepository extends JpaRepository<Contact,Long> {
    Contact findByEmail(String email);
}
