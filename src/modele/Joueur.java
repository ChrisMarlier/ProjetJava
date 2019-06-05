package modele;

import Unite.*;

import java.io.Serializable;
import java.util.ArrayList;

public class Joueur implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom;
    private ArrayList<Unite> listeUnites = new ArrayList<Unite>();
    private ArrayList<ArrayList<Integer>> brouillard=new ArrayList<>();
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
    
    public void supprimerUnite(int indice){
    	listeUnites.remove(indice);
    }
    
    
    public int piecedanstableau(int i, int j){
    	//Retourne l'indice du tableau d'unite de la piece selectionnee
        
        for(int x=0;x<listeUnites.size();x++){
            
            if(listeUnites.get(x).getCoordonneeI()==i && listeUnites.get(x).getCoordonneeJ()==j){
                return x;
            }
            
        }
        return -1;
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
            calculeB(hexagone, listeUnites.get(i).getPorteeAtk()+1);

        }
      ;
    /*    //DEBBOGAGE
        System.out.println("\n");
        for(int i=0;i<19;i++){

            System.out.println(brouillard.get(i));
        }
*/
    }


    public void calculeB( Hexagone hexagone,int portee ){
        // fonction recursive mettant un a 1 un case du tableau teste si une unite e assez de point de depl	cement pour y aller

        if( portee>0){
            // premierement on me a 1 la case courante

                brouillard.get(hexagone.getJ()).remove(hexagone.getI());
                brouillard.get(hexagone.getJ()).add(hexagone.getI(),0);
                portee--;



            // puis on remance l'algo sur les hexagone voisin
            if(hexagone.getJ()>0){
                calculeB(hexagone.voisinHaut(),portee);

            }
            if(hexagone.getJ()<18){
                calculeB(hexagone.voisinBah(),portee);

            }


//
            if (hexagone.getJ() > 0 && hexagone.getI() > 0) {
                 calculeB(hexagone.voisinHautGauche(),portee);

            }

            if (hexagone.getJ() > 0 && hexagone.getI() < 18) {
               calculeB(hexagone.voisinHautdroit(),portee);

            }
//
            if (hexagone.getJ() <18 && hexagone.getI() > 0)  {
                 calculeB(hexagone.voisinBahGauche(),portee);

            }
            if (hexagone.getJ() < 18 && hexagone.getI() < 18) {
               calculeB(hexagone.voisinBahDroit(),portee);

            }
        }


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

	public ArrayList<ArrayList<Integer>> getBrouillard() {
		return brouillard;
	}

	public void setBrouillard(ArrayList<ArrayList<Integer>> brouillard) {
		this.brouillard = brouillard;
	}
}
