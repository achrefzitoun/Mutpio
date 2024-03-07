package com.mutpio.pfe.Repositories;

import com.mutpio.pfe.Entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContactRepository extends JpaRepository<Contact,Long> {
}
