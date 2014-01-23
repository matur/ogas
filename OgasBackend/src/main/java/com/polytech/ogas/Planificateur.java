/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.polytech.ogas;

import com.polytech.ogas.service.EntretienFacadeREST;
import java.util.ArrayList;
import java.util.Date;

/**
 * Classe proposant une méthode statique permettant le calcul du planning des entretiens
 * pour un évenement donné
 * L'appel à cette méthode pour un évennement déjà plannifié aura pour conséquence de générer
 * à nouveau le planning de l'évennement
 * @author epulapp
 */
public class Planificateur {
    public static boolean computePlanning(short idEvenement)
    {
        return true;
    }
    
    public static ArrayList<RendezVous> getPlanning(short idEvenement)
    {
        EntretienFacadeREST facade = new EntretienFacadeREST();
        ArrayList<Entretien> entretiens = facade.findAllByIdEvenement(idEvenement);
        
        return null; 
    }
            
    class RendezVous{
        
        private short idEtudiant;
        private String libelleEtudiant;
  
        private short idEntreprise;
        private String libelleEntreprise;
        
        private short idSalle;
        private String libelleSalle;
        
        private Date horaireDebut;
        private Date horaireFin;
        
        public RendezVous(short idEtudiant, String libelleEtudiant, short idEntreprise, String libelleEntreprise, short idSalle, String libelleSalle, Date horaireDebut, Date horaireFin)
        {
            this.idEtudiant = idEtudiant;
            this.libelleEtudiant = libelleEtudiant;
            
            this.idEntreprise = idEntreprise;
            this.libelleEntreprise = libelleEntreprise;
            
            this.idSalle = idSalle;
            this.libelleSalle = libelleSalle;
            
            this.horaireDebut = horaireDebut;
            this.horaireFin = horaireFin;
        }
    }
}
