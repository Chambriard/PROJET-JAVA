/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notreprojetjava;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Utilisateur
 */
public class Mission {
    
    private String id;
    private String libelle;
    private int statut;
    private Date dateDeb;
    private Date dateFin;
    private int nbEmpTot;
    HashMap<Competence, Integer> CompReq;
    ArrayList<Employe> equipeMission;
    
    public Mission(String id, String libelle, Date DateDeb, Date DateFin, int nbEmpTot){
        this.id = id;
        this.libelle = libelle;
        this.statut = 1;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
        this.nbEmpTot = nbEmpTot;
        CompReq = new HashMap<Competence, Integer>();
        equipeMission = new ArrayList<Employe>();
    }
    public Mission(String id, String libelle,int statut, Date DateDeb, Date DateFin, int nbEmpTot){
        this.id = id;
        this.libelle = libelle;
        this.statut = statut;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
        this.nbEmpTot = nbEmpTot;
        CompReq = new HashMap<Competence, Integer>();
        equipeMission = new ArrayList<Employe>();
    }
    
    
    public String toString(){
        String chaine ;
        chaine = this.id + this.libelle + this.statut + this.dateDeb + this.dateFin + this.nbEmpTot ;
        return chaine;
    }
    
    // public void ajoutComp(...){}
    
    // public void ajoutEmp(...){}
    
    // public void supprComp(...){}
    
    // public void supprEmp(...){}
    
    // public void changerStatut(...){}
    
}
