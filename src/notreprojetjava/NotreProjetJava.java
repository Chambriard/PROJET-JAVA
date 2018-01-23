/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notreprojetjava;

import java.io.FileNotFoundException;

/**
 *
 * @author Chambriard
 */
public class NotreProjetJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(" *** DEBUT *** ");
        
        //CSVFile personnel = new CSVFile(System.getProperty("user.dir") + "\\data\\liste_personnel.csv");
        //CSVFile personnel = new CSVFile(System.getProperty("user.dir") + "\\data\\liste_competences.csv");
        CSVFile personnel = new CSVFile(System.getProperty("user.dir") + "\\data\\competences_personnel.csv");
        personnel.afficher();
    }
    
}
