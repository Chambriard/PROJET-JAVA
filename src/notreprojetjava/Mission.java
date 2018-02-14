/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notreprojetjava;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.HashMap;

/**
 *
 * @author Utilisateur
 */
public class Mission {
    
    // Attributs
    private String id;
    private String libelle;
    private int statut;
    private Date dateDeb;
    private Date dateFin;
    private int nbEmpTot;
    HashMap<Competence, Integer> CompReq;
    ArrayList<Employe> equipeMission;
    
    // Constructeur
    public Mission(String id, String libelle, Date dateDeb, Date dateFin, int nbEmpTot){
        this.id = id;
        this.libelle = libelle;
        this.statut = 1;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
        this.nbEmpTot = nbEmpTot;
        CompReq = new HashMap<Competence, Integer>();
        equipeMission = new ArrayList<Employe>();
    }
    
    public Mission(String id, String libelle,int statut, Date dateDeb, Date dateFin, int nbEmpTot){
        //System.out.println(dateDeb.afficher());
        //System.out.println(dateFin.afficher());
        this.id = id;
        this.libelle = libelle;
        this.statut = statut;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
        this.nbEmpTot = nbEmpTot;
        CompReq = new HashMap<Competence, Integer>();
        equipeMission = new ArrayList<Employe>();
    }
    
    // Accesseurs
    public String getId(){
        return id ;
    }
    public String getLibelle(){
        return libelle ;
    }
    
    // Méthodes
    public String toString(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String chaine ;
        chaine = this.id + " " + this.libelle + " " + this.statut + " " + formatter.format(this.dateDeb) + " " + formatter.format(this.dateFin) + " " + this.nbEmpTot ;
        chaine = chaine + equipeMission.toString();
        for(HashMap.Entry<Competence,Integer> entry :CompReq.entrySet()){
            Competence key = entry.getKey();
            int value = entry.getValue();
            chaine = chaine + System.getProperty("line.separator") + key.toString();
            chaine = chaine + System.getProperty("line.separator") + "nb fois requis " + value;
        }
        return chaine;
    }
    
    // public void ajoutComp(...){}
    
    // public void ajoutEmp(...){}
    
    // public void supprComp(...){}
    
    // public void supprEmp(...){}
    
    // public void changerStatut(...){}
    
}
