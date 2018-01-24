/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notreprojetjava;

import java.io.FileNotFoundException;

/**
 *
 * @author Utilisateur
 */
public class CSVFileListePersonnel extends CSVFile {
    
    public CSVFileListePersonnel() throws FileNotFoundException {
        super();
        nom = "liste_competences.csv";
        path = System.getProperty("user.dir") + "\\data\\" + nom;
        
    }
    
}
