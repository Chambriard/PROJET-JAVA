/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notreprojetjava;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Utilisateur
 */
public abstract class CSVFile {
    
    // Attributs
    protected String nom;
    protected String path;
    protected Scanner sc;

    // Constructeur
    public CSVFile() throws FileNotFoundException{

    }
}