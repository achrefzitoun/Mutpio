package com.mutpio.pfe.Services;

import com.mutpio.pfe.Entities.Ville;
import com.mutpio.pfe.Repositories.IVilleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class VilleServices implements IVilleServices{

    @Autowired
    private IVilleRepository villeRepository;

    @Override
    public Ville ajouterVille(Ville ville) {
        return villeRepository.save(ville);
    }

    @Override
    public void supprimerVille(Long idVille) {
        villeRepository.deleteById(idVille);
    }

    @Override
    public Ville getVille(Long idVille) {
        return villeRepository.findById(idVille).orElseThrow();
    }

    @Override
    public List<Ville> getAllVilles() {
        return StreamSupport.stream(villeRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
