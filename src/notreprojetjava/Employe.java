/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notreprojetjava;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Chambriard
 */
public class Employe {
    private int id;
    private String nom;
    private String prenom;
    private Date dateE;
    private ArrayList<Competence> lesCompetences; 
    
    public Employe (int id , String nom, String prenom, Date dateE){
        this.id = id ;
        this.nom = nom;
        this.prenom = prenom ;
        this.dateE = dateE ;
        lesCompetences = new ArrayList<Competence>() ;
    }
    
    
}
