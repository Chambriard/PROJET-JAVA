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
 * @author achambri
 */
public class CSVFileListeMissionPersonnel extends CSVFile {
    private ArrayList<Mission> ensembleMission ; 
    public CSVFileListeMissionPersonnel() throws FileNotFoundException {
        nom = "liste_MissionPersonnel.csv";
        path = System.getProperty("user.dir") + "\\data\\" + nom;
        this.sc = new Scanner(new FileReader(path));
        //création d'une hashmap
        ensembleMission = new ArrayList<Mission>();   
    }
    
}
