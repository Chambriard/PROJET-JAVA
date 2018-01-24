/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notreprojetjava;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Utilisateur
 */
public class CSVFileListePersonnel extends CSVFile {
    
    private ArrayList<String> lesEmployes;
    
    public CSVFileListePersonnel() throws FileNotFoundException {
        //super();
        nom = "liste_personnel.csv";
        path = System.getProperty("user.dir") + "\\data\\" + nom;
        sc = new Scanner(new FileReader(path));
        lesEmployes = new ArrayList<String>();
    }
    
    public void recupEmployes(){
        while(sc.hasNextLine()) {
            lesEmployes.add(sc.nextLine());
        }
    }
    
    public void afficher(){
        for(String monEmploye : lesEmployes){
            System.out.println(monEmploye);
        }
    }
}
