package com.mutpio.pfe.Controllers;

import com.mutpio.pfe.Entities.Ville;
import com.mutpio.pfe.Services.IVilleServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/ville")
public class VilleController {
    @Autowired
    IVilleServices villeServices;

    @PostMapping("/addVillage")
    Ville ajouterVille (@RequestBody Ville ville){
        return villeServices.ajouterVille(ville);
    }


}
