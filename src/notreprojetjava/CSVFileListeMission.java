/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notreprojetjava;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author achambri
 */
public class CSVFileListeMission extends CSVFile{
    private ArrayList<Mission> ensembleMission ; 
    public CSVFileListeMission() throws FileNotFoundException {
        nom = "liste_Mission.csv";
        path = System.getProperty("user.dir") + "\\data\\" + nom;
        this.sc = new Scanner(new FileReader(path));
        //création d'une hashmap
        ensembleMission = new ArrayList<Mission>();   
    }
    public void recupMission() throws FileNotFoundException, ParseException{
        while(sc.hasNextLine()) {
            int statut ;
            int nbPersoMax;
            Date dateDeb ;
            Date dateFin ;
            String[] chaineDecoupe = null;
            chaineDecoupe = sc.nextLine().split(";");
            //System.out.println(chaineDecoupe[0]);
            statut = Integer.parseInt(chaineDecoupe[2]);
            nbPersoMax = Integer.parseInt(chaineDecoupe[5]);
            dateDeb = new Date(chaineDecoupe[3]);
            dateFin = new Date(chaineDecoupe[4]);
            
            ensembleMission.add(new Mission(chaineDecoupe[0], chaineDecoupe[1], statut, dateDeb,dateFin,nbPersoMax));
        }
    }
     public void afficher(){
        for(Mission maMission : ensembleMission){
            System.out.println(maMission.toString());
        }
    }
}
