package com.sprintdemo.aplicationb.web.controller;

import com.sprintdemo.aplicationb.web.model.Personnage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@RestController
public class Controller {

    private final RestTemplate restTemplate;

    public Controller(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/random-name")
    public String getRandomNom(){
        String url = "https://random-word-api.herokuapp.com/word";
        String name = restTemplate.getForObject(url,String.class);
        return  name;
    }

    @GetMapping("/random")
    public Object getRandomPersonnage(){
        int randomNumber = (int)(Math.random() * (4 - 1)+1);//génération d'un entier >= 1 et < 4
        String url = "http://localhost:8081/Personnage/"+randomNumber;
        Object personnage = restTemplate.getForObject(url,Object.class);
        return  personnage;
    }

    @PostMapping(value = "/random")
    public Personnage ajouterPersonnage() {

        String nom = getRandomNom();
        int id = 7;
        String type = "magicien";
        int pointDeVie = 7;

        Personnage personnage = new Personnage(id, nom,type,pointDeVie);
        String url = "http://localhost:8081/Personnage";
        restTemplate.postForLocation(url, personnage);

        return personnage;

    }




}
