/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notreprojetjava;

import java.io.FileNotFoundException;
import java.text.ParseException;
import javax.swing.JFrame;

/**
 *
 * @author Chambriard
 */
public class NotreProjetJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        System.out.println(" *** DEBUT *** ");
        
        //CSVFile personnel = new CSVFile("liste_personnel.csv");
        //CSVFile personnel = new CSVFile("liste_competences.csv");
        //CSVFile personnel = new CSVFile("competences_personnel.csv");
        //System.out.println(personnel.toString());
        //personnel.afficher();
        
        /*
        Competence c = new Competence("F.1", "Anglais", "French");
        System.out.println(c.toString());
        System.out.println(c.returnFormat());
        */
        
        CSVFileListeCompetences maListComp = new CSVFileListeCompetences();
        maListComp.recupCompetence();
   
        
        
        CSVFileListePersonnel maListPerso = new CSVFileListePersonnel();
        maListPerso.recupEmployes();
        
        
        
        CSVFileCompetencesPersonnel maListCompPerso = new CSVFileCompetencesPersonnel();
        maListCompPerso.recupCompetencesPersonnel(maListComp.getList(), maListPerso.getList());
        
       
        
        CSVFileListeMission maListMission = new CSVFileListeMission();
        maListMission.recupMission();
        
        CSVFileListeMissionPersonnel maListMissionPerso = new CSVFileListeMissionPersonnel();
        maListMissionPerso.recupPeronnel(maListMission.getList(),maListPerso.getList());
        
        maListMission.afficher();
        
    }
    
}
