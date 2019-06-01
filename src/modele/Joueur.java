package modele;

import Unite.*;
import java.util.ArrayList;

public class Joueur {
    private String nom;
    private ArrayList<Unite> listeUnites = new ArrayList<Unite>();
    private int PA;
    private int PM;

    public Joueur(String nom) {
        this.nom = nom;
        this.PM=10;
        this.PA = 10;

    }
    
    public void ajouterUnite(Unite unite) {
    	listeUnites.add(unite);
    }
    
    
    public int piecedanstableau(int i, int j){
    	//Retourne l'indice du tableau d'unité de la piece selectionnée
        
        for(int x=0;x<listeUnites.size();x++){
            
            if(listeUnites.get(x).getCoordonneeI()==i && listeUnites.get(x).getCoordonneeJ()==j){
            	//System.out.println("Unité selectionné");
                return x;
            }
            
        }
        //System.out.println("pas d'uniter selectionnéé");
        return -1;
    }
    
    public void fintour(){
        this.PA=10;
        this.PM=10;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Unite> getUnites() {
        return listeUnites;
    }

    public void setUnites(ArrayList<Unite> unites) {
        this.listeUnites = unites;
    }

    public int getPA() {
        return PA;
    }

    public void setPA(int PA) {
        this.PA = PA;
    }

    public int getPM() {
        return PM;
    }

    public void setPM(int PM) {
        this.PM = PM;
    }
}
