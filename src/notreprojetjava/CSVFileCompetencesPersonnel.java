/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notreprojetjava;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Utilisateur
 */
public class CSVFileCompetencesPersonnel extends CSVFile {
    
    public CSVFileCompetencesPersonnel(String nom) throws FileNotFoundException {
        super();
        nom = "competences_personnel.csv";
        path = System.getProperty("user.dir") + "\\data\\" + nom;
        
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
    
}
