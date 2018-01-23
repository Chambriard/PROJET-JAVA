/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notreprojetjava;

/**
 *
 * @author Chambriard
 */
public class Competence {
    private String id ;
    private String nomAng ;
    private String nomFra ;
    
    public Competence (String id, String nomAng, String nomFra){
        this.id = id;
        this.nomAng = nomAng;
        this.nomFra = nomFra;
    }
    public Competence (String id){
        this.id = id;
        this.nomAng = "";
        this.nomFra = "";
    }
    public String toStringId(){
        return id ;
    }
    
    public String toString(){
        return id + "\nNom Anglais : " + nomAng + "\nNom Français : " + nomFra;
    }
    
    public String returnFormat(){
        return id + ";" + nomAng + ";" + nomFra + ";";
    }
    
}
