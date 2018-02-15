/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notreprojetjava;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Utilisateur
 */
public abstract class CSVFile {
    
    // Attributs
    protected String nom;
    protected String path;
    protected Scanner sc;
    HashMap<String,ArrayList<Competence>> ensembleEmpComp;
    
    
    
    public CSVFile() throws FileNotFoundException{

    }

    public void afficher(){
        /*
        while(sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }*/
        System.out.println("Coucou");
        for(HashMap.Entry<String,ArrayList<Competence>> entry : ensembleEmpComp.entrySet()) {
            
            String key = entry.getKey();
            ArrayList<Competence> value = entry.getValue();
            System.out.println("id emp : " + key);
            for(Competence comp : value){
                 System.out.println("id comp : " + comp.toStringId());
            }
        }
    }
    
    public String toString(){
        String contenu = "";
        switch(this.nom){
            case "competences_personnel.csv" : contenu += " *** LISTE DES COMPETENCES PAR PERSONNE *** \r\n";
            break;
            
            case "liste_personnel.csv" : contenu += " *** LISTE DU PERSONNEL *** \r\n";
            break;
            
            case "liste_competences.csv" : contenu += " *** LISTE DES COMPETENCES *** \r\n";
            break;
        }
        
        while(sc.hasNextLine()) {
            contenu += sc.nextLine() + "\r\n";
        }
        
        return contenu;
    }
    
    //public void
}