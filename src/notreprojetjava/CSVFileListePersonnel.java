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
    
    //attribus
    private ArrayList<Employe> lesEmployes;
    //Accesseur 
     public ArrayList<Employe> getList(){
        return lesEmployes ;
    }
    //Constrcuteur
    /**
     * Constructeur qui permet de définir le CSV a intéroger et d'intancier le scanner 
     * pour pouvoir parcourir le CSV
     * @throws FileNotFoundException 
     */
    public CSVFileListePersonnel() throws FileNotFoundException {
        //super();
        nom = "liste_personnel.csv";
        path = System.getProperty("user.dir") + "\\data\\" + nom;
        sc = new Scanner(new FileReader(path));
        lesEmployes = new ArrayList<Employe>();
    }
    
   
    //Méthodes
    /**
     * Dans le CSV Liste_personnel nous avons l'ensemble du personnel
     * cette méthode permet de récupérer les employé et de les définir dans la
     * liste lesEmployes
     * @throws FileNotFoundException
     * @throws ParseException 
     */
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
