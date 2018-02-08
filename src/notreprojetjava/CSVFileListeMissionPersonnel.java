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
    public CSVFileListeMissionPersonnel() throws FileNotFoundException {
        nom = "liste_MissionPersonnel.csv";
        path = System.getProperty("user.dir") + "\\data\\" + nom;
        this.sc = new Scanner(new FileReader(path)); 
    }
    public void recupPeronnel(ArrayList<Mission> lesMissions, ArrayList<Employe> lesEmployes){
        while(sc.hasNextLine()) {
            String[] chaineDecoupe = null;
            chaineDecoupe = sc.nextLine().split(";");
            
            for(Mission uneMiss : lesMissions){
                if(uneMiss.getId().equalsIgnoreCase(chaineDecoupe[0]))
                {
                    int i = 1;
                    while(i< chaineDecoupe.length){
                        for(Employe unEmp : lesEmployes){
                            if(unEmp.getId().equalsIgnoreCase(chaineDecoupe[i])){
                                uneMiss.equipeMission.add(unEmp);
                            }
                        }
                        i++ ;
                    }
                }
            }
        }
    }
    
}
