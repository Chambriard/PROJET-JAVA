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
    private Date dateE;
    private ArrayList<Competence> lesCompetences; 
    private CSVFile monCSV ;
    public Employe (String id , String nom, String prenom, Date dateE) throws FileNotFoundException{
        this.id = id ;
        this.nom = nom;
        this.prenom = prenom ;
        this.dateE = dateE ;
        monCSV = new CSVFile(System.getProperty("user.dir") + "\\data\\competences_personnel.csv");
        lesCompetences = new ArrayList<Competence>() ;
        /*
        boolean presenceEmp = false ;
        while(monCSV.getSc().hasNextLine() && presenceEmp == false) {
            String[] chaineDecoupe = null;
            String idEmp ;
            chaineDecoupe = monCSV.getSc().nextLine().split(";");
            idEmp = chaineDecoupe[0];
            if(Integer.parseInt(idEmp) == id){
                int i =0 ;
                while(i < chaineDecoupe.length){
               
                }
            }
            
        }
        */
    }
    public void ajouterComp(Competence uneComp){
        
    }
   
    
    
}