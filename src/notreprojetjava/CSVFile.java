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
public class CSVFile {
    
    private String nom;
    private String path;
    private Scanner sc;
    HashMap<String,ArrayList<Competence>> ensembleEmpComp;
    public Scanner getSc(){
        return sc;
    }
    
    public CSVFile(String nom) throws FileNotFoundException{
        this.nom = nom;
        this.path = System.getProperty("user.dir") + "\\data\\" + nom;
        this.sc = new Scanner(new FileReader(path));
        //création d'une hashmap
        ensembleEmpComp = new HashMap<String,ArrayList<Competence>>();
        while(sc.hasNextLine()) {
            String[] chaineDecoupe = null;
            String idEmp ;
            ArrayList<Competence> lesCompChaine = new ArrayList<Competence>();
            chaineDecoupe = sc.nextLine().split(";");
            idEmp = chaineDecoupe[0];
            int i =1; 
            while(i< chaineDecoupe.length){
                Competence maComp = new Competence(chaineDecoupe[i]);
                lesCompChaine.add(maComp);
                i++ ;
            }
            ensembleEmpComp.put(idEmp,lesCompChaine);
        }
    }

    public void afficher(){
        /*
        while(sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }*/
        for(HashMap.Entry<String,ArrayList<Competence> > entry : ensembleEmpComp.entrySet()) {
            String key = entry.getKey();
            ArrayList<Competence> value = entry.getValue();
            System.out.println("id emp : " + key);
            for(Competence comp : value){
                 System.out.println("id comp : " + comp.toStringId());
            }
        }
        
        // Test sur les noms
        /*switch(this.nom){
            case "competences_personnel.csv" : System.out.println("C'est la liste des compétences de chaque personne.");
            break;
            
            case "liste_personnel.csv" : System.out.println("C'est la liste du personnel.");
            break;
            
            case "liste_competences.csv" : System.out.println("C'est la liste des compétences.");
            break;
        }*/
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