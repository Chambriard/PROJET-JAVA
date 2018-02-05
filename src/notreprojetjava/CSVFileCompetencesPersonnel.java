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
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Utilisateur
 */
public class CSVFileCompetencesPersonnel extends CSVFile {
    
    public CSVFileCompetencesPersonnel() throws FileNotFoundException {
        //super();
        nom = "competences_personnel.csv";
        path = System.getProperty("user.dir") + "\\data\\" + nom;
        this.sc = new Scanner(new FileReader(path));
        
    }
    public void recupCompetencesPersonnel(ArrayList<Competence> lesComp, ArrayList<Employe> lesEmp){
        //récupération des num employés dans la list du CSVEmployé avec leur compétence associé 
        // dans la list du CSVComp
        while(sc.hasNextLine()) {
            String[] chaineDecoupe = null;
            String idEmp ;
            chaineDecoupe = sc.nextLine().split(";");
            idEmp = chaineDecoupe[0];
            Employe monEmpFichier = new Employe(idEmp) ;
            for(Employe unEmpList : lesEmp){
                if (unEmpList.equals(monEmpFichier)){
                    int i = 1; 
                    while(i< chaineDecoupe.length){
                        Competence uneComFiche = new Competence(chaineDecoupe[i]);
                        for(Competence uneCompList : lesComp){
                            if(uneComFiche.equals(uneCompList)){
                                //System.out.println("Coucou");
                                unEmpList.ajouterComp(uneCompList);
                            }
                        }
                        i++;
                    }
                }
            }
        }
    }
    
}
