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




    //en java17 !!
    @Override
    @Transactional
    public void addProsAndBenef(Devis devis) {

        try {
            System.out.println("Début de l'ajout des bénéficiaires et prospects.");

            devis.setDateDevis(LocalDate.now());
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



    //Juste Prospect + ContratResiliation
    @Override
    public Devis ajouterDevisAvecProspectEtContact(Devis devis) {
        
        devis.setDateDevis(LocalDate.now());
        devis.setNumDevis(generateRandomNumber());
        devis.setEtat(Etat.EN_COURS_DE_TRAITEMENT);

        Prospect prospect = devis.getProspect();
        if (prospect != null) {
            devis.setProspect(prospect);

            Contact contact = prospect.getContact();

            if (contact != null) {
                contact.setProspect(prospect);
                contactRepository.save(contact);
            }
            prospectRepository.save(prospect);
        }
        ContratResiliation contrat = devis.getContratResiliation();

        if(contrat!=null){
            contrat.setDevis(devis);
            contratResiliationRepository.save(contrat);
        }

        if (devis.getBeneficiares() != null && !devis.getBeneficiares().isEmpty()) {
            devis.getBeneficiares().forEach(beneficiare -> {
                beneficiare.setDevis(devis);
                beneficiareRepository.save(beneficiare);
            });
            System.out.println("Bénéficiaires enregistrés avec succès.");
        }

        return devisRepository.save(devis);


    }


    public String generateRandomNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(1000000);
        return String.format("%06d", randomNumber);
    }



}
