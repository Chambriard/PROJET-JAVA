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
    
    public void setStatut(int s){
        statut = s;
    }
    public Date getDateDeb(){
        return dateDeb;
    }
    public Date getDateFin(){
        return dateFin;
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
    
    /**
     * Permet l'ajout d'une compétence nécessaire à la mission
     * @param comp
     * @param nb 
     */
    public void ajoutComp(Competence comp, Integer nb){
        if(!CompReq.containsKey(comp))
            CompReq.put(comp, nb);
        else
            System.out.println("La compétence existe déjà dans la mission");
    }
    
    /**
     * Supprime une compétence nécessaire à la mission
     * @param comp 
     */
    public void supprComp(Competence comp){
        if(CompReq.containsKey(comp))
            CompReq.remove(comp);
        else
            System.out.println("La compétence n'existe pas dans la mission");
    }
    
    /**
     * Modifie le nombre d'itération d'une compétence nécessaire
     * @param comp
     * @param nb 
     */
    public void modifNbComp(Competence comp, Integer nb){
        CompReq.put(comp, nb);
    }
    
    /**
     * Ajoute un employé à la mission
     * @param e 
     */
    public void ajoutEmp(Employe e){
        if(equipeMission.size() < nbEmpTot){
            equipeMission.add(e);
            int nb;
            // On désincrémente de 1 chaque compétence de la mission que l'employé dispose.
            for(Competence c : e.getCompetences()){
                if(CompReq.containsKey(c)){
                    nb = CompReq.get(c);
                    nb--;
                    CompReq.put(c, nb);
                }
            }
        }
        else
            System.out.println("Le nombre maximal d'employés est atteint pour cette mission.");
    }
    
    /**
     * Supprime un employé d'une mission
     * @param e 
     */
    public void supprEmp(Employe e){
        if(equipeMission.contains(e)){
            equipeMission.remove(e);
            int nb;
            // On incrémente de 1 chaque compétence de la mission que l'employé dispose.
            for(Competence c : e.getCompetences()){
                if(CompReq.containsKey(c)){
                    nb = CompReq.get(c);
                    nb++;
                    CompReq.put(c, nb);
                }
            }
        }
    }
    
    // public void changerStatut(...){}
    
}
