/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notreprojetjava;

/**
 *
 * @author achambri
 */
public class Date {
    int jour ;
    int moin ;
    int annee ;
    public Date(int jour, int moin, int annee){
        this.jour = jour ;
        this.annee = annee ;
        this.moin = moin ;
    }
    public Date(String date){
        String[] chaineDecoupe = null;
        chaineDecoupe = date.split("/");
        this.jour = Integer.parseInt(chaineDecoupe[0]);
        this.moin = Integer.parseInt(chaineDecoupe[1]);
        this.annee = Integer.parseInt(chaineDecoupe[2]);
    }
    public String ToString(){
        String chaine;
        chaine = "" + this.jour + "/" + this.moin + "/" + this.annee;
        return chaine ;
    }
    
}
