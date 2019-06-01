package modele;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import Unite.*;
import controleur.Coord;
import visuel.Panneau2;


public class GestionMap {

	private static ArrayList<ArrayList<Integer>> map;
	private static Joueur joueur1, joueur2;
	public static Coord caseCliquee = new Coord();
	static int indicePieceSelected = -1;
	static ArrayList<ArrayList<Integer>> listedeplacement= new ArrayList<ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> listeAttaque= new ArrayList<ArrayList<Integer>>();

	static int numeroClic=0;
	private static int joueurActuel = 1; // !!!!! A CHANGER

	public GestionMap() {
		//Initialisation et boucle principale du jeu
		
		map = new ArrayList<ArrayList<Integer>>();
		this.chargementMap();
		joueur1=new Joueur("joueur1");
		joueur2=new Joueur("joueur2");

		int i,j;
		Scanner sc;
		
		joueur1.ajouterUnite(new Jeep(0,0));
		joueur1.ajouterUnite(new Tank(0,18));
        joueur1.ajouterUnite(new Jeep(6,4));
        joueur1.ajouterUnite(new Tank(1,0));
        joueur2.ajouterUnite(new Tank(1,18));
        joueur2.ajouterUnite(new Tank(2,0));
        joueur2.ajouterUnite(new Tank(3,0));
        joueur2.ajouterUnite(new Tank(4,0));
        joueur2.ajouterUnite(new Tank(5,0));
        joueur2.ajouterUnite(new Tank(6,0));
		
		
		/*do{
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
					indicePieceSelected=joueur1.piecedanstableau(i,j);
				}while(indicePieceSelected!=-1);
				System.out.println("que voulez vous faire 1)deplacemen  3)attaque");
				sc = new Scanner(System.in);
				i = sc.nextInt();
				if(i==1)
				{
					this.Deplacement(joueur1,indicePieceSelected);
				}
				
			}
			else if(i==2){
				joueur1.fintour();
			}
		}while(i==2);*/

        


	}
	
	public static void tourJeu() {

		Panneau2 refresh = new Panneau2(GestionMap.getMap().size(),GestionMap.getMap().get(0).size(),16);
		
		Joueur joueur = null;
		
		if(joueurActuel==1)
			joueur = joueur1;
		else if(joueurActuel==2)
			joueur = joueur2;
		
		//Si le joueur clique sur une de ses unité
			if( (joueur.piecedanstableau(caseCliquee.getI(), caseCliquee.getJ()) != -1)) {
				indicePieceSelected=joueur.piecedanstableau(caseCliquee.getI(), caseCliquee.getJ());
				listedeplacement=calculeDeplacementValide(joueur.getUnites().get(indicePieceSelected),joueur.getPM());
				listeAttaque=calculeAtaqueValide(joueur.getUnites().get(indicePieceSelected));
				System.out.println("Pièce séléctionnée !");
				numeroClic=1;
			}

			//Si une unité a déja été select
			if(numeroClic == 1) {
				if(listedeplacement.get(caseCliquee.getJ()).get(caseCliquee.getI()) > 0) {
					
					System.out.println("Déplacement");
					Deplacement(joueur, indicePieceSelected, caseCliquee, listedeplacement);
					//System.out.println(joueur1.getUnites().get(2).getCoordonneeI() + " " + joueur1.getUnites().get(2).getCoordonneeJ());
					numeroClic=0;
					indicePieceSelected = -1;
					
				}
				else if(listeAttaque.get(caseCliquee.getJ()).get(caseCliquee.getI()) > 0 && joueur.getPA()>=joueur.getUnites().get(indicePieceSelected).getPtnActionNecessaire()) {
					System.out.println("A LATAKE");
					joueur1.setPA(joueur.getPA()-joueur.getUnites().get(indicePieceSelected).getPtnActionNecessaire());
					numeroClic=0;
					indicePieceSelected = -1;
				}
				else
					System.out.println("Aucun déplacement ou attaque autorisée à cette case");
			}
		
		refresh.repaint();
			
			
			
		
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


	public static ArrayList<ArrayList<Integer>> calculeDeplacementValide(Unite unite,int pointD){

		ArrayList<ArrayList<Integer>> listDeplacement = new ArrayList<ArrayList<Integer>>();


		for(int i=0;i<19;i++){
			ArrayList<Integer> ListInt = new ArrayList<Integer>();
			for(int j=0;j<19;j++){
				ListInt.add(0);
			}
			listDeplacement.add(ListInt);
		}//creation d'un tableau analogue a la map rempli de 0
		Hexagone hexagone=new Hexagone(unite.getCoordonneeI(),unite.getCoordonneeJ());
		listDeplacement=calculeD(listDeplacement,Math.min(unite.getPtDepMax(),pointD)+1,hexagone,unite,0);
		listDeplacement.get(hexagone.getJ()).remove(hexagone.getI());
		listDeplacement.get(hexagone.getJ()).add(hexagone.getI(),0);
		
		//DEBBOGAGE
		for(int i=0;i<19;i++){
			System.out.println("DepAutorisé:"+listDeplacement.get(i));
		}
		
		return listDeplacement;
	}


	
	public static void Deplacement(Joueur joueur,int indiceC, Coord coord, ArrayList<ArrayList<Integer>> listedeplacement){
		int i = coord.getJ();
		int j = coord.getI();
		
		Scanner sc;
		//do{
			/*System.out.println("entrez coodonée case cible:\nI:");
			sc = new Scanner(System.in);
			i = sc.nextInt();
			System.out.println("j:");
			sc = new Scanner(System.in);
			j = sc.nextInt();*/
			//listedeplacement=calculeDeplacementValide(joueur.getUnites().get(indiceC),joueur.getPM());
		//}while(listedeplacement.get(i).get(j)==0);
		
		joueur.setPM(joueur.getPM()-listedeplacement.get(i).get(j));
		
		joueur.getUnites().get(indiceC).setCoordonneeI(coord.getI());//On set l'unité a sa nouvelle position
		joueur.getUnites().get(indiceC).setCoordonneeJ(coord.getJ());
		System.out.println("PM restant : "+joueur.getPM());
	}

	private static ArrayList<ArrayList<Integer>> calculeD(ArrayList<ArrayList<Integer>> test, int ptDep, Hexagone hexagone,Unite unite,int pointautiliser){
		// fonction recursive mettant un a 1 un case du tableau teste si une unite e assez de point de depl	cement pour y aller

		if( ptDep>0 && (joueur1.piecedanstableau(hexagone.getI(),hexagone.getJ())==-1 || joueur1.piecedanstableau(hexagone.getI(),hexagone.getJ())==joueur1.piecedanstableau(unite.getCoordonneeI(),unite.getCoordonneeJ()))
				&& (joueur2.piecedanstableau(hexagone.getI(),hexagone.getJ())==-1 || joueur1.piecedanstableau(hexagone.getI(),hexagone.getJ())==joueur1.piecedanstableau(unite.getCoordonneeI(),unite.getCoordonneeJ()))){
		// premierement on me a 1 la case courante

			if(test.get(hexagone.getJ()).get(hexagone.getI())==0 || test.get(hexagone.getJ()).get(hexagone.getI())>pointautiliser ){
				test.get(hexagone.getJ()).remove(hexagone.getI());
				test.get(hexagone.getJ()).add(hexagone.getI(),pointautiliser);
			}
			
			//On envoie la map actuelle pour calculer le nombre de point de deplacement que coute la case
			int pointDep = calculPointDeplacementNecessaire(getMap().get(hexagone.getJ()).get(hexagone.getI()));
			pointautiliser+=pointDep;
			ptDep-=pointDep;// on enlever les point de deplacement corepondant a la case



			// puis on remance l'algo sur les hexagone voisin
			if(hexagone.getI()>0){
				test=calculeD(test, ptDep,hexagone.voisinHaut(),unite,pointautiliser);
			}
			if(hexagone.getI()<18){
				test=calculeD(test, ptDep,hexagone.voisinBah(),unite,pointautiliser);
			}


//
			if (hexagone.getJ() > 0 && hexagone.getI() > 0) {
				test = calculeD(test, ptDep,hexagone.voisinHautGauche(),unite,pointautiliser);
			}
			if (hexagone.getJ() < 18 && hexagone.getI() > 0) {
				test = calculeD(test, ptDep, hexagone.voisinHautdroit(),unite,pointautiliser);
			}

			if ((hexagone.getJ() > 0 && hexagone.getI() < 18) || (hexagone.getI() == 18)) {
				test = calculeD(test, ptDep,hexagone.voisinBahGauche(),unite,pointautiliser);
			}
			if ((hexagone.getJ() < 18 && hexagone.getI() < 18) || (hexagone.getI() == 18 )) {
				test = calculeD(test, ptDep, hexagone.voisinBahDroit(),unite,pointautiliser);
			}
		}
		return test;
	}



	public static ArrayList<ArrayList<Integer>> calculeAtaqueValide(Unite unite){
		//Retourne la map remplit de 0 si il ne peut rien faire et de 1 si il peut attaquer
		
		ArrayList<ArrayList<Integer>> listeAttaque = new ArrayList<ArrayList<Integer>>();


		for(int i=0;i<19;i++){
			ArrayList<Integer> ListInt = new ArrayList<Integer>();
			for(int j=0;j<19;j++){
				ListInt.add(0);
			}
			listeAttaque.add(ListInt);
		}//creation d'un tableau analogue a la map rempli de 0

		Hexagone hexagone=new Hexagone(unite.getCoordonneeI(),unite.getCoordonneeJ());

		listeAttaque=calculeA(listeAttaque,unite.getPorteeAtk()+1,hexagone,unite,0);
		listeAttaque.get(hexagone.getJ()).remove(hexagone.getI());
		listeAttaque.get(hexagone.getJ()).add(hexagone.getI(),0);

		for(int i=0;i<19;i++){
			System.out.println("AtkAutorisé: "+listeAttaque.get(i));
		}
		return listeAttaque;
	}


	private static ArrayList<ArrayList<Integer>> calculeA(ArrayList<ArrayList<Integer>> test, int porteAtk, Hexagone hexagone,Unite unite,int pointautiliser){
		// fonction recursive mettant un a 1 un case du tableau teste si une unite e assez de point de depl	cement pour y aller

		if( porteAtk>0 ){
			// premierement on me a 1 la case courante
				if( (joueur2.piecedanstableau(hexagone.getI(),hexagone.getJ())!=-1 && joueurActuel==1) 
					||(joueur1.piecedanstableau(hexagone.getI(),hexagone.getJ())!=-1 && joueurActuel==2)	){
				test.get(hexagone.getJ()).remove(hexagone.getI());
				test.get(hexagone.getJ()).add(hexagone.getI(),1);}

			porteAtk--;



			// puis on remance l'algo sur les hexagone voisin
			if(hexagone.getI()>0){
				test=calculeA(test, porteAtk,hexagone.voisinHaut(),unite,pointautiliser);
			}
			if(hexagone.getI()<18){
				test=calculeA(test, porteAtk,hexagone.voisinBah(),unite,pointautiliser);
			}


//
			if (hexagone.getJ() > 0 && hexagone.getI() > 0) {
				test = calculeA(test, porteAtk,hexagone.voisinHautGauche(),unite,pointautiliser);
			}
			if (hexagone.getJ() < 18 && hexagone.getI() > 0) {
				test = calculeA(test, porteAtk, hexagone.voisinHautdroit(),unite,pointautiliser);
			}

			if ((hexagone.getJ() > 0 && hexagone.getI() < 18) || (hexagone.getI() == 18)) {
				test = calculeA(test, porteAtk,hexagone.voisinBahGauche(),unite,pointautiliser);
			}
			if ((hexagone.getJ() < 18 && hexagone.getI() < 18) || (hexagone.getI() == 18 )) {
				test = calculeA(test, porteAtk, hexagone.voisinBahDroit(),unite,pointautiliser);
			}
		}
		return test;
	}
	
	public static int calculPointDeplacementNecessaire(int numMap) {
		//Renvoie le nombre de point de déplacement que coute le numéro de la map envoyé (le numero = le nombre marque dans le fichier map.txt)
		if(numMap == 1)
			return 2;
		else 
			return 1;
			
		
	}
	
	public static void passerTour() {
		if(joueurActuel==1) {
			joueurActuel=2;
			joueur1.setPA(10);
			joueur1.setPM(10);
			System.out.println("C'est au joueur 2 de jouer");
		}
		else if(joueurActuel==2) {
			joueurActuel=1;
			joueur2.setPA(10);
			joueur2.setPM(10);
			System.out.println("C'est au joueur 1 de jouer");
		}
		
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
