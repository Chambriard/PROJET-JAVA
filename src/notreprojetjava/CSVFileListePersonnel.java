/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notreprojetjava;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Utilisateur
 */
public class CSVFileListePersonnel extends CSVFile {
    
    private ArrayList<Employe> lesEmployes;
    
    public CSVFileListePersonnel() throws FileNotFoundException {
        //super();
        nom = "liste_personnel.csv";
        path = System.getProperty("user.dir") + "\\data\\" + nom;
        sc = new Scanner(new FileReader(path));
        lesEmployes = new ArrayList<Employe>();
    }
    
    public ArrayList<Employe> getList(){
        return lesEmployes ;
    }
    
    public void recupEmployes() throws FileNotFoundException, ParseException{
        
        while(sc.hasNextLine()) {
            String[] chaineDecoupe = null;
            chaineDecoupe = sc.nextLine().split(";");
            //SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yy");
            //Date d = sdf.parse(chaineDecoupe[2]);
            lesEmployes.add(new Employe(chaineDecoupe[3], chaineDecoupe[1], chaineDecoupe[0], chaineDecoupe[2]));
        }
    }
    
    public void afficher(){
        for(Employe monEmploye : lesEmployes){
            System.out.println(monEmploye.toString());
        }
    }
}
