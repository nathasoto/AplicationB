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

         //todo
        int randomNumber = (int)(Math.random() * (4 - 1)+1);//génération d'un entier >= 1 et < 4 (max - min)+ min
        String url = "http://localhost:8081/api/personages/"+randomNumber;
        Object personnage = restTemplate.getForObject(url,Object.class);
        return  personnage;
    }

    @PostMapping(value = "/random")
    public Personnage ajouterPersonnage() {

        String nom = getRandomNom();
        int point_de_vie = (int)(Math.random() * (12 - 1)+1);
        String type = "magicien";

        Personnage personnage = new Personnage(nom,point_de_vie,type);
        String url = "http://localhost:8081/api/personages";
        restTemplate.postForLocation(url, personnage);

        return personnage ;

    }




}
