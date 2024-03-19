package com.mutpio.pfe.Services;

import com.mutpio.pfe.Entities.*;
import com.mutpio.pfe.Repositories.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ProfilService implements IProfilService {

    private final IProspectRepository prospectRepository;

    private final IBeneficiareRepository beneficiareRepository;

    private final IContactRepository contactRepository;

    private final IDevisRepository devisRepository;

    private final IContratResiliationRepository contratResiliationRepository;



    public String generateRandomNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(1000000);
        return String.format("%06d", randomNumber);
    }

    @Override
    public void addProspectAndBeneficiaire(Prospect prospect, String email, LocalDate dateAdhesion) {
        prospectRepository.save(prospect);

        Contact contact = new Contact();
        contact.setEmail(email);
        contact.setProspect(prospect);
        contactRepository.save(contact);

        Devis devis = new Devis();
        devis.setDateDevis(LocalDate.now());
        devis.setDateAdhesion(dateAdhesion);
        devis.setNumDevis(generateRandomNumber());
        devis.setProspect(prospect);
        devisRepository.save(devis);

        Beneficiare beneficiare = new Beneficiare();
        beneficiare.setNom(prospect.getNom());
        beneficiare.setPrenom(prospect.getPrenom());
        beneficiare.setDateNaissance(prospect.getDateNaissance());
        beneficiare.setTypeBeneficiare(TypeBeneficiare.SOUSCRIPTEUR);
        beneficiare.setDevis(devis);
        beneficiareRepository.save(beneficiare);
    }
    //en java17 !!
    @Override
    @Transactional
    public void addProsAndBenef(Devis devis){
        devis.setDateDevis(LocalDate.now());
        devis.setNumDevis(generateRandomNumber());
        devis.setNumDevis(generateRandomNumber());
        devisRepository.save(devis);

        if(devis.getProspect()!=null){
            prospectRepository.save(devis.getProspect());
            Contact contact = devis.getProspect().getContact();
            contactRepository.save(contact);
        }
        if(devis.getContratResiliation()!=null){
            contratResiliationRepository.save(devis.getContratResiliation());
        }

        if (devis.getBeneficiares() != null) {
            beneficiareRepository.saveAll(devis.getBeneficiares());
        }

    }


    @Override
    public Beneficiare addConjoint(Beneficiare conjoint) {

        conjoint.setTypeBeneficiare(TypeBeneficiare.CONJOINT);
        return beneficiareRepository.save(conjoint);
    }

    @Override
    public List<Beneficiare> addEnfants(List<Beneficiare> enfants) {
        for(Beneficiare b : enfants){
            b.setTypeBeneficiare(TypeBeneficiare.ENFANT);
            beneficiareRepository.save(b);
        }
        return enfants;
    }

    @Override
    public ContratResiliation addContratResiliation(ContratResiliation contratResiliation) {
        return null;
    }



}
