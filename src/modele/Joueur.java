package modele;

import Unite.*;
import java.util.ArrayList;

public class Joueur {
    private String nom;
    private ArrayList<Unite> unites = new ArrayList<Unite>();
    private int PA;
    private int PM;

    public Joueur(String nom) {
        this.nom = nom;
        unites.add(new Jeep(4,5));
        unites.add(new Tank(0,18));
        unites.add(new Jeep(6,4));
        unites.add(new Tank(0,0));
        unites.add(new Tank(1,0));
        unites.add(new Tank(1,18));
        unites.add(new Tank(2,0));
        unites.add(new Tank(3,0));
        unites.add(new Tank(4,0));
        unites.add(new Tank(5,0));
        unites.add(new Tank(6,0));

    }
    
    
    public int piecedanstableau(int i, int j){
        
        for(int x=0;x<unites.size();x++){
            
            if(unites.get(x).getCoordonneeI()==i && unites.get(x).getCoordonneeJ()==j){
                return x;
            }
            
        }
        System.out.println("pas d'uniter s'elextioner");
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
        return unites;
    }

    public void setUnites(ArrayList<Unite> unites) {
        this.unites = unites;
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
