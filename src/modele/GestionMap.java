package modele;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import Unite.*;
import controleur.Coord;
import controleur.actionIU;
import menu.FenetreNPartie;
import menu.FenetreNPartie2;
import visuel.Panneau;
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
	private static int nbrTourRestant = 0;
	
	private static int modeJeu = 1; // 1 IA / 2 2joueurs





	public GestionMap() {
		//Initialisation et boucle principale du jeu
		
		map = new ArrayList<ArrayList<Integer>>();
		this.chargementMap(1);
		if(modeJeu==2) {
		joueur1=new Joueur(FenetreNPartie.titleText2.getText().toString());
		joueur2=new Joueur(FenetreNPartie.titleText1.getText().toString());
		}
		if(modeJeu==1){ //bug ?
			joueur1=new Joueur(FenetreNPartie2.titleText.getText().toString());
			joueur2=new Joueur("The Master IA");
		}

		int i,j;
		Scanner sc;
		


		/*joueur1.ajouterUnite(new Jeep(2,1));
		joueur1.ajouterUnite(new Jeep(3,1));
		joueur1.ajouterUnite(new Jeep(6,1));
		joueur1.ajouterUnite(new Jeep(6,3));
		joueur1.ajouterUnite(new Jeep(7,1));
        joueur1.ajouterUnite(new Jeep(1,1));
        joueur1.ajouterUnite(new Tank(4,2));
        joueur1.ajouterUnite(new Tank(6,6));
        joueur1.ajouterUnite(new Tank(10,1));
        joueur1.ajouterUnite(new Tank(9,4));
        
        joueur2.ajouterUnite(new Jeep(16,15));
        joueur2.ajouterUnite(new Jeep(16,16));
        joueur2.ajouterUnite(new Jeep(15,17));
        joueur2.ajouterUnite(new Jeep(15,16));
        joueur2.ajouterUnite(new Tank(9,16));
        joueur2.ajouterUnite(new Tank(10,16));
        joueur2.ajouterUnite(new Tank(11,16));
        joueur2.ajouterUnite(new Tank(11,13));
        joueur2.ajouterUnite(new Tank(16,10));*/
		
		joueur1.ajouterUnite(new Tank(1,1));
        joueur2.ajouterUnite(new Tank(2,2));

        
        joueur1.initbrouilard();
        joueur2.initbrouilard();

	}
	
	public static void tourJeu() {
		System.out.println("mode de jeu :" + modeJeu);
		Panneau2 refresh = new Panneau2(GestionMap.getMap().size(),GestionMap.getMap().get(0).size(),16);
		actionIU refresh2 = new actionIU();
		Joueur joueur = null;
		Joueur ennemi = null;
		
		if(joueurActuel==1) {
			joueur = joueur1;
			ennemi = joueur2;
		}
		else if(joueurActuel==2) {
			joueur = joueur2;
			ennemi = joueur1;
		}
		
		if(modeJeu == 2 || (modeJeu == 1 && joueurActuel ==1)) {
		//Si le joueur clique sur une de ses unité
			if( (joueur.piecedanstableau(caseCliquee.getI(), caseCliquee.getJ()) != -1)) {
				indicePieceSelected=joueur.piecedanstableau(caseCliquee.getI(), caseCliquee.getJ());
				listedeplacement=calculeDeplacementValide(joueur.getUnites().get(indicePieceSelected),joueur.getPM());
				listeAttaque=calculeAtaqueValide(joueur.getUnites().get(indicePieceSelected));
				System.out.println("Piece selectionnee !");
				Panneau.preview.revalidate();
				Panneau.preview.repaint();
				numeroClic=1;
			}

			//Si une unite a deja ete select
			if(numeroClic == 1) {
				if(listedeplacement.get(caseCliquee.getJ()).get(caseCliquee.getI()) > 0) {
					
					System.out.println("Deplacement");
					Deplacement(joueur, indicePieceSelected, caseCliquee, listedeplacement);
					numeroClic=0;
					joueur.calculeB(new Hexagone(joueur.getUnites().get(indicePieceSelected).getCoordonneeI(),
							joueur.getUnites().get(indicePieceSelected).getCoordonneeJ())
							,joueur.getUnites().get(indicePieceSelected).getPorteeAtk()+1);
					effaceListes();
					indicePieceSelected = -1;
					
				}
				else if(listeAttaque.get(caseCliquee.getJ()).get(caseCliquee.getI()) > 0 && joueur.getPA()>=joueur.getUnites().get(indicePieceSelected).getPtnActionNecessaire()) {
					System.out.println("A LATAKE");
					joueur.setPA(joueur.getPA()-joueur.getUnites().get(indicePieceSelected).getPtnActionNecessaire());
					
					int indicePiecAtk = ennemi.piecedanstableau(caseCliquee.getI(), caseCliquee.getJ());
					joueur.getUnites().get(indicePieceSelected).attaque(ennemi.getUnites().get(indicePiecAtk));
					
					if(ennemi.getUnites().get(indicePiecAtk).getPV()<=0) { //Si l'unite est morte
						ennemi.supprimerUnite(indicePiecAtk);
					}
					
					
					numeroClic=0;
					effaceListes();
					indicePieceSelected = -1;
				}
				else
					System.out.println("Aucun deplacement ou attaque autorisee a� cette case");
				

			}
			
			else
				effaceListes();
			
			refresh.repaint();
			refresh2.update();
			
			
		
		}
		
		checkFinPartie();
	}
	
	public static void checkFinPartie() {
		if(joueur1.getUnites().isEmpty())
			System.out.println("Le joueur 2 à gagné ! Fin de partie !");
		else if(joueur2.getUnites().isEmpty())
			System.out.println("Le joueur 1 à gagné ! Fin de partie");
	}
	
	public void chargementMap(int map) {

		String file= "./Maps/test.txt"; 
		
		if(map == 1)
			file = "./Maps/test.txt"; 

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
		/*for(int i=0;i<19;i++){
			System.out.println("DepAutorisé:"+listDeplacement.get(i));
		}*/
		
		return listDeplacement;
	}


	
	public static void Deplacement(Joueur joueur,int indiceC, Coord coord, ArrayList<ArrayList<Integer>> listedeplacement){
		int i = coord.getJ();
		int j = coord.getI();
		
		if(joueur.getPM()-listedeplacement.get(i).get(j) >=0) {
			joueur.setPM(joueur.getPM()-listedeplacement.get(i).get(j));
			
			joueur.getUnites().get(indiceC).setCoordonneeI(coord.getI());//On set l'unité a sa nouvelle position
			joueur.getUnites().get(indiceC).setCoordonneeJ(coord.getJ());
			//System.out.println("PM restant : "+joueur.getPM());
		}
		
	}

	private static ArrayList<ArrayList<Integer>> calculeD(ArrayList<ArrayList<Integer>> test, int ptDep, Hexagone hexagone,Unite unite,int pointautiliser){
		// fonction recursive mettant un a 1 un case du tableau teste si une unitee assez de point de deplacement pour y aller

		if( ptDep>0 && (joueur1.piecedanstableau(hexagone.getI(),hexagone.getJ())==-1 || joueur1.piecedanstableau(hexagone.getI(),hexagone.getJ())==joueur1.piecedanstableau(unite.getCoordonneeI(),unite.getCoordonneeJ()))
				&& (joueur2.piecedanstableau(hexagone.getI(),hexagone.getJ())==-1 || joueur2.piecedanstableau(hexagone.getI(),hexagone.getJ())==joueur2.piecedanstableau(unite.getCoordonneeI(),unite.getCoordonneeJ()))){
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
			if(hexagone.getJ()>0){
				test=calculeD(test, ptDep,hexagone.voisinHaut(),unite,pointautiliser);
			}
			if(hexagone.getJ()<18){
				test=calculeD(test, ptDep,hexagone.voisinBah(),unite,pointautiliser);
			}


//
			if (hexagone.getJ() > 0 && hexagone.getI() > 0) {
				test = calculeD(test, ptDep,hexagone.voisinHautGauche(),unite,pointautiliser);
			}
			if (hexagone.getJ() >0 && hexagone.getI() <18) {
				test = calculeD(test, ptDep, hexagone.voisinHautdroit(),unite,pointautiliser);
			}

			if (hexagone.getJ() < 18 && hexagone.getI() > 0) {
				test = calculeD(test, ptDep,hexagone.voisinBahGauche(),unite,pointautiliser);
			}
			if (hexagone.getJ() < 18 && hexagone.getI() < 18) {
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

		/*for(int i=0;i<19;i++){
			System.out.println("AtkAutorisé: "+listeAttaque.get(i));
		}*/
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
						if(hexagone.getJ()>0){
							test=calculeA(test, porteAtk,hexagone.voisinHaut(),unite,pointautiliser);
						}
						if(hexagone.getJ()<18){
							test=calculeA(test, porteAtk,hexagone.voisinBah(),unite,pointautiliser);
						}


			//
						if (hexagone.getJ() > 0 && hexagone.getI() > 0) {
							test = calculeA(test, porteAtk,hexagone.voisinHautGauche(),unite,pointautiliser);
						}
						if (hexagone.getJ() >0 && hexagone.getI() <18) {
							test = calculeA(test, porteAtk, hexagone.voisinHautdroit(),unite,pointautiliser);
						}

						if (hexagone.getJ() <18  && hexagone.getI() > 0){
							test = calculeA(test, porteAtk,hexagone.voisinBahGauche(),unite,pointautiliser);
						}
						if (hexagone.getJ() < 18 && hexagone.getI() < 18) {
							test = calculeA(test, porteAtk, hexagone.voisinBahDroit(),unite,pointautiliser);
						}
		}
		return test;
	}
	
	public static int calculPointDeplacementNecessaire(int numMap) {
		//Renvoie le nombre de point de déplacement que coute le numéro de la map envoyé (le numero = le nombre marque dans le fichier map.txt)
		if(numMap == 1)
			return 2;
		else if(numMap == 7)
			return 1000;
		else 
			return 1;
			
		
	}
	
	public static void IA() {
		
		//Attaque de ce qu'elle peut
		for(int i=0; i<joueur2.getUnites().size(); i++) {
			listeAttaque=calculeAtaqueValide(joueur2.getUnites().get(i));
			
				for(int j=0; j<listeAttaque.size(); j++) {
					for(int k=0; k<listeAttaque.get(j).size(); k++) {
						if(listeAttaque.get(j).get(k) > 0 && joueur2.getPA() - joueur2.getUnites().get(i).getPtnActionNecessaire() >= 0) {
							//System.out.println("unité " + joueur2.getUnites().get(i).getCoordonneeI() + " " + joueur2.getUnites().get(i).getCoordonneeJ());
							System.out.println("ATTAQUE EN " + j + " " + k);
							
							int indiceEnnemi = joueur1.piecedanstableau(k, j);
							
							joueur2.setPA(joueur2.getPA()-joueur2.getUnites().get(i).getPtnActionNecessaire());

							joueur2.getUnites().get(i).attaque(joueur1.getUnites().get(indiceEnnemi));
							System.out.println(joueur2.getPA());
							
							if(joueur1.getUnites().get(indiceEnnemi).getPV()<=0) { //Si l'unitee est morte
								joueur1.supprimerUnite(indiceEnnemi);
							}
						}
					}
				}
			
		}
		
		
		Random rand = new Random();
		//int nombreAleatoire = rand.nextInt(max - min + 1) + min;
		int indiceAleat = rand.nextInt((joueur2.getUnites().size()-1) - 0 + 1) + 0;
		
		listedeplacement=calculeDeplacementValide(joueur2.getUnites().get(indiceAleat), joueur2.getPM());
		int deplacementEffectue = 0;
		
		for(int i=0; i<listedeplacement.size(); i++) {
			for(int j=0; j<listedeplacement.get(i).size(); j++) {
				
					if(listedeplacement.get(i).get(j) > 0 && deplacementEffectue ==0 && map.get(j).get(i) != 7 ){
						System.out.println("Deplaccement " +map.get(i).get(j) );
						System.out.println("aaaaaaa : i : " + i + "j : " + j);
						caseCliquee.setI(i);
						caseCliquee.setJ(j);
						Deplacement(joueur2, indiceAleat, caseCliquee, listedeplacement );
						deplacementEffectue=1;
					}

			}
		}
		
		Panneau2 refresh = new Panneau2(GestionMap.getMap().size(),GestionMap.getMap().get(0).size(),16);
		actionIU refresh2 = new actionIU();
		
		passerTour();

		
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

	public static int getJoueurActuel() {
		return joueurActuel;
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
	public static int getNbrTourRestant() {
		return nbrTourRestant;
	}
	public static int getModeJeu() {
		return modeJeu;
	}

	public static ArrayList<ArrayList<Integer>> getListedeplacement() {
		return listedeplacement;
	}

	public static ArrayList<ArrayList<Integer>> getListeAttaque() {
		return listeAttaque;
	}
	public static void effaceListes() {
		listeAttaque.clear();
		listedeplacement.clear();
	}
	public static void setModeJeu(int modeJeu) {
		GestionMap.modeJeu = modeJeu;
	}

}
