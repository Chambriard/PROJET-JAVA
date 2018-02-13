/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notreprojetjava;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Chambriard
 */
public class Employe {
    
    private String id;
    private String nom;
    private String prenom;
    //private Date dateE;
    private String dateE;
    private ArrayList<Competence> lesCompetences; 
    //private CSVFile monCSV;
    
    public Employe (String id , String nom, String prenom, String dateE) throws FileNotFoundException{
        this.id = id ;
        this.nom = nom;
        this.prenom = prenom ;
        this.dateE = dateE ;
        lesCompetences = new ArrayList<Competence>() ;
    }
    public Employe (String id){
        this.id = id ;
        this.nom = "";
        this.prenom = "" ;
        this.dateE = null ;
        lesCompetences = new ArrayList<Competence>() ;
    }
    public void ajouterComp(Competence uneComp){
        lesCompetences.add(uneComp);
    }
    public boolean equals(Object obj){
        Employe other =(Employe)obj;
        if(!this.id.equals(other.id))
            return false;
        return true;              
    }
    public String getId(){
        return id ;
    }
    public String getNom(){
        return nom ;
    }
    public String toString(){
        String chaine ;
        chaine =  "Employe" + prenom + " " + nom + " - Date d'entrée en entreprise : " + dateE + ".";
        chaine = chaine + System.getProperty("line.separator") + " les Competences de l'employé" ;
        for(Competence uneComp : lesCompetences){
            chaine = chaine + System.getProperty("line.separator") + uneComp.toStringId();
        }
        return chaine ;
    }
    
}
