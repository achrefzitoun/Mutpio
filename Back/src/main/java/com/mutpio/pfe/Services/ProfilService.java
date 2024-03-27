package com.mutpio.pfe.Services;

import com.mutpio.pfe.Entities.*;
import com.mutpio.pfe.Repositories.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    public void addProsAndBenef(Devis devis) {

        try {
            System.out.println("Début de l'ajout des bénéficiaires et prospects.");

            devis.setDateDevis(LocalDate.now());
            devis.setNumDevis(generateRandomNumber());
            devis.setNumDevis(generateRandomNumber());
            devisRepository.save(devis);
            System.out.println("Devis enregistré avec succès.");

            if (devis.getProspect() != null) {
                System.out.println("Enregistrement du prospect.");
                prospectRepository.save(devis.getProspect());
                System.out.println("Prospect enregistré avec succès.");

                Contact contact = devis.getProspect().getContact();
                contactRepository.save(contact);
                System.out.println("Contact enregistré avec succès.");
            }

            if (devis.getContratResiliation() != null) {
                contratResiliationRepository.save(devis.getContratResiliation());
                System.out.println("Contrat de résiliation enregistré avec succès.");
            }

            if (devis.getBeneficiares() != null && !devis.getBeneficiares().isEmpty()) {
                beneficiareRepository.saveAll(devis.getBeneficiares());
                System.out.println("Bénéficiaires enregistrés avec succès.");
            }
        } catch (Exception e) {
            System.err.println("Une erreur est survenue lors de l'enregistrement : " + e.getMessage());
            throw new RuntimeException("Erreur lors de l'enregistrement des données.", e);
        }
    }

    //Juste Prospect
    @Override
    public void ajouterDevisAvecProspectEtContact(Devis devis) {
        
        devis.setDateDevis(LocalDate.now());
        devis.setNumDevis(generateRandomNumber());

        Prospect prospect = devis.getProspect();
        if (prospect != null) {
            devis.setProspect(prospect);
        }

        devisRepository.save(devis);
        System.out.println("Devis enregistré avec succès.");

    }

    //C'est Bon !
    @Override
    public Prospect addProsp(Prospect prospect) {
        prospect.setAdressePostale(null);
        prospect.setCompte(null);

        Contact contact = prospect.getContact();

        if (contact != null) {
            contact.setProspect(prospect);
            contactRepository.save(contact);
        }

        return prospect;
    }

    @Override
    public Beneficiare addConjoint(Beneficiare conjoint) {

        conjoint.setTypeBeneficiare(TypeBeneficiare.CONJOINT);
        return beneficiareRepository.save(conjoint);
    }

    @Override
    public List<Beneficiare> addEnfants(List<Beneficiare> enfants) {
        for (Beneficiare b : enfants) {
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
