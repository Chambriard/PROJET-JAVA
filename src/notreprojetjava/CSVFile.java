/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notreprojetjava;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Utilisateur
 */
public class CSVFile {
    
    private String path;
    private Scanner sc;
    
    public CSVFile(String path) throws FileNotFoundException{
        this.path = path;
        this.sc = new Scanner(new FileReader(path));
    }

    public void afficher(){
        while(sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }
    
}
