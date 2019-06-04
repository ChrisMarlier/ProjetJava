package modele;

import Unite.*;
import java.util.ArrayList;

public class Joueur {
    private String nom;
    private ArrayList<Unite> listeUnites = new ArrayList<Unite>();
    private int PA;
    private int PM;
    private ArrayList<ArrayList<Integer>> brouillard=new ArrayList<>();
    public Joueur(String nom) {
        this.nom = nom;
        this.PM=10;
        this.PA = 10;

    }
    
    public void ajouterUnite(Unite unite) {
    	listeUnites.add(unite);
    }
    
    public void supprimerUnite(int indice){
    	listeUnites.remove(indice);
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





    public void initbrouilard(){

        for(int i=0;i<19;i++){
            ArrayList<Integer> ListInt = new ArrayList<Integer>();
            for(int j=0;j<19;j++){
                ListInt.add(1);
            }
            brouillard.add(ListInt);
        }//creation d'un tableau analogue a la map rempli de 0

        for(int i=0;i<this.listeUnites.size();i++) {
            Hexagone hexagone = new Hexagone(listeUnites.get(i).getCoordonneeI(), listeUnites.get(i).getCoordonneeJ());
            calculeB(hexagone, listeUnites.get(i).getPorteeAtk());

        }
        //DEBBOGAGE
        System.out.println("\n");
        for(int i=0;i<19;i++){

            System.out.println(brouillard.get(i));
        }

    }


    private void calculeB( Hexagone hexagone,int portée ){
        // fonction recursive mettant un a 1 un case du tableau teste si une unite e assez de point de depl	cement pour y aller

        if( portée>0){
            // premierement on me a 1 la case courante

            brouillard.get(hexagone.getJ()).remove(hexagone.getI());
            brouillard.get(hexagone.getJ()).add(hexagone.getI(),0);
            portée--;



            // puis on remance l'algo sur les hexagone voisin
            if(hexagone.getI()>0){
                calculeB(hexagone.voisinHaut(),portée);
            }
            if(hexagone.getI()<18){
                calculeB(hexagone.voisinBah(),portée);
            }


//
            if (hexagone.getJ() > 0 && hexagone.getI() > 0) {
                calculeB(hexagone.voisinHautGauche(),portée);
            }
            if (hexagone.getJ() < 18 && hexagone.getI() > 0) {
                calculeB(hexagone.voisinHautdroit(),portée);
            }

            if (hexagone.getJ() > 0 && hexagone.getI() < 18)  {
                calculeB(hexagone.voisinBahGauche(),portée);
            }
            if (hexagone.getJ() < 18 && hexagone.getI() < 18) {
                calculeB(hexagone.voisinBahDroit(),portée);
            }
        }


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
