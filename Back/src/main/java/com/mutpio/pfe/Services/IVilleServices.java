package com.mutpio.pfe.Services;

import com.mutpio.pfe.Entities.Ville;

import java.util.List;

public interface IVilleServices {

    public Ville ajouterVille(Ville ville);
    public void supprimerVille(Long idVille);
    public Ville getVille(Long idVille);
    public List<Ville> getAllVilles();




}
