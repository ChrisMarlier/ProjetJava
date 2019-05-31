package modele;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import Unite.*;
import controleur.Coord;


public class GestionMap {

	private static ArrayList<ArrayList<Integer>> map;
	private static Joueur joueur1, joueur2;
	public static Coord caseCliquee = new Coord();
	


	public GestionMap() {
		//Initialisation et boucle principale du jeu
		
		map = new ArrayList<ArrayList<Integer>>();
		this.chargementMap();
		joueur1=new Joueur("joueur1");
		joueur2=new Joueur("joueur2");

		int i,j;
		int coordonnePieceSelected;
		Scanner sc;
		
		joueur1.ajouterUnite(new Jeep(0,0));
		joueur1.ajouterUnite(new Tank(0,18));
        joueur1.ajouterUnite(new Jeep(6,4));
        joueur1.ajouterUnite(new Tank(0,0));
        joueur1.ajouterUnite(new Tank(1,0));
        joueur2.ajouterUnite(new Tank(1,18));
        joueur2.ajouterUnite(new Tank(2,0));
        joueur2.ajouterUnite(new Tank(3,0));
        joueur2.ajouterUnite(new Tank(4,0));
        joueur2.ajouterUnite(new Tank(5,0));
        joueur2.ajouterUnite(new Tank(6,0));
		
		
		do{
			System.out.println("que voulez vous faire 1)action  3)fin du tour");
			sc = new Scanner(System.in);
			i = sc.nextInt();
			if (i==1) {
				do {
					System.out.println("entrez coodonée uniter::\nI:");
					sc = new Scanner(System.in);
					i = sc.nextInt();
					System.out.println("j:");
					sc = new Scanner(System.in);
					j = sc.nextInt();
					coordonnePieceSelected=joueur1.piecedanstableau(i,j);
				}while(coordonnePieceSelected!=-1);
				System.out.println("que voulez vous faire 1)deplacemen  3)attaque");
				sc = new Scanner(System.in);
				i = sc.nextInt();
				if(i==1)
				{
					this.Deplacement(joueur1,coordonnePieceSelected);
				}
				
			}
			else if(i==2){
				joueur1.fintour();
			}
		}while(i==2);

        


	}
	public void chargementMap() {

		String file = "./Maps/test.txt"; //Chemin de la map e modifier. A CHANGER plus tard

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {

				ArrayList<String> ListString = new ArrayList<String>(Arrays.asList(line.split(" ")));//On insert notre ligne dans une liste de String en separant par un espace

				ArrayList<Integer> ListInt = new ArrayList<Integer>();

				for(int i=0;i<ListString.size();i++) { //On parcourt toute la liste de String pour parser en int et ajouter a notre liste de int
					ListInt.add(Integer.parseInt(ListString.get(i)));

				}
				//System.out.println(ListInt); //DEBOGAGE
				getMap().add(ListInt); //Et on ajoute la liste a notre map
			}
			//System.out.println(getMap());
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}


	public ArrayList<ArrayList<Integer>> calculeDeplacementValide(Unite unite,int pointD){

		ArrayList<ArrayList<Integer>> listDeplacement = new ArrayList<ArrayList<Integer>>();


		for(int i=0;i<20;i++){
			ArrayList<Integer> ListInt = new ArrayList<Integer>();
			for(int j=0;j<24;j++){
				ListInt.add(0);
			}
			listDeplacement.add(ListInt);
		}//creation d'un tableau analogue a la map rempli de 0
		Hexagone hexagone=new Hexagone(unite.getCoordonneeI(),unite.getCoordonneeJ());

		listDeplacement=calcule(listDeplacement,Math.min(unite.getPvMax(),pointD)+1,hexagone,0);
		listDeplacement.get(hexagone.getI()).remove(hexagone.getJ());
		listDeplacement.get(hexagone.getI()).add(hexagone.getJ(),0);
		for(int i=0;i<20;i++){
			System.out.println("Test2:"+listDeplacement.get(i));
		}
		return listDeplacement;
	}

	public void gestiondeplacement(ArrayList<ArrayList<Integer>> listDeplacement,Joueur joueur,int indicec,int i, int j){
		if(listDeplacement.get(i).get(j)!=0){
			joueur.getUnites().get(indicec).setCoordonneeI(i);
			joueur.getUnites().get(indicec).setCoordonneeJ(j);
			joueur.setPM(joueur.getPM()-listDeplacement.get(i).get(j));
			System.out.println("PM restant : "+joueur.getPM());
		}
	

	}
	
	public void Deplacement(Joueur joueur,int indiceC){
		int i,j;
		ArrayList<ArrayList<Integer>> listedeplacement;
		Scanner sc;
		do{
			System.out.println("entrez coodonée case cible:\nI:");
			sc = new Scanner(System.in);
			i = sc.nextInt();
			System.out.println("j:");
			sc = new Scanner(System.in);
			j = sc.nextInt();
			 listedeplacement=this.calculeDeplacementValide(joueur.getUnites().get(indiceC),joueur.getPM());
		}while(listedeplacement.get(i).get(j)==0);
		System.out.println("PM restant : "+joueur.getPM());
	}

	private ArrayList<ArrayList<Integer>> calcule(ArrayList<ArrayList<Integer>> test, int ptDep, Hexagone hexagone,int pointautiliser){
		// fonction recursive mettant un a 1 un case du tableau teste si une unite e assez de point de depl	cement pour y aller

		if( ptDep>0 ){// premierement on me a 1 la case courante

			if(test.get(hexagone.getI()).get(hexagone.getJ())==0 || test.get(hexagone.getI()).get(hexagone.getJ())>pointautiliser ){
				test.get(hexagone.getI()).remove(hexagone.getJ());
				test.get(hexagone.getI()).add(hexagone.getJ(),pointautiliser);
			}
			pointautiliser+=getMap().get(hexagone.getI()).get(hexagone.getJ());
			ptDep-=getMap().get(hexagone.getI()).get(hexagone.getJ());// on enlever les point de deplacement corepondant a la case



			// puis on remance l'algo sur les hexagone voisin
			if(hexagone.getI()>0){
				test=calcule(test, ptDep,hexagone.voisinHaut(),pointautiliser);
			}
			if(hexagone.getI()<19){
				test=calcule(test, ptDep,hexagone.voisinBah(),pointautiliser);
			}


//
			if (hexagone.getJ() > 0 && hexagone.getI() > 0) {
				test = calcule(test, ptDep,hexagone.voisinHautGauche(),pointautiliser);
			}
			if (hexagone.getJ() < 24 && hexagone.getI() > 0) {
				test = calcule(test, ptDep, hexagone.voisinHautdroit(),pointautiliser);
			}

			if ((hexagone.getJ() > 0 && hexagone.getI() < 19) || (hexagone.getI() == 19)) {
				test = calcule(test, ptDep,hexagone.voisinBahGauche(),pointautiliser);
			}
			if ((hexagone.getJ() < 24 && hexagone.getI() < 19) || (hexagone.getI() == 19 )) {
				test = calcule(test, ptDep, hexagone.voisinBahDroit(),pointautiliser);
			}
		}



		return test;
	}


	public static ArrayList<ArrayList<Integer>> getMap() {
		return map;
	}


	public static void setMap(ArrayList<ArrayList<Integer>> map) {
		GestionMap.map = map;
	}
	public static Joueur getJoueur1() {
		return joueur1;
	}
	public static Joueur getJoueur2() {
		return joueur2;
	}

}
