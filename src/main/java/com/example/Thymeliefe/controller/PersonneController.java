package com.example.Thymeliefe.controller;

import com.example.Thymeliefe.dao.Connexion;
import com.example.Thymeliefe.dao.PersonneDao;
import com.example.Thymeliefe.modele.Personne;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.SQLException;

@Controller
public class PersonneController
{
    @GetMapping("/listePersonnes")
    public String getAll(Model modele) throws ClassNotFoundException, SQLException {
        Connexion connexion=new Connexion();
        Connection con= connexion.connect();
        PersonneDao personneDao=new PersonneDao();
        modele.addAttribute("personnes",personneDao.getAllPersonne(con));
        return "ListePersonnes";
    }
}
