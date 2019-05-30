package modele;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

import Unite.*;

public class GestionMap {

	private static ArrayList<ArrayList<Integer>> map;
	private static ArrayList<Unite> uniteJ1;
	private static ArrayList<Unite> uniteJ2;

	
	public GestionMap() {
		//Initialisation et boucle principale du jeu
		
		map = new ArrayList<ArrayList<Integer>>();
		uniteJ1 = new ArrayList<Unite>();
		uniteJ2 = new ArrayList<Unite>();
		
		
		uniteJ1.add(new Jeep(4,5));
		uniteJ1.add(new Tank(5,6));
		uniteJ1.add(new Jeep(6,4));
		uniteJ1.add(new Tank(3,4));
		
		uniteJ2.add(new Jeep(10,10));
		uniteJ2.add(new Tank(11,11));
		uniteJ2.add(new InfanterieLegere(10,11));
		
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
		    System.out.println(getMap());














		}
	      catch (Exception e) {
	            e.printStackTrace();
	        }

	}


	public void calculeDeplacementValide(Unite unite){

		ArrayList<ArrayList<Integer>> listDeplacement = new ArrayList<ArrayList<Integer>>();


		for(int i=0;i<20;i++){
			ArrayList<Integer> ListInt = new ArrayList<Integer>();
			for(int j=0;j<24;j++){
				ListInt.add(0);
			}
			listDeplacement.add(ListInt);
		}//creation d'un tableau analogue a la map rempli de 0
		Hexagone hexagone=new Hexagone(unite.getCoordonneeI(),unite.getCoordonneeJ());
		listDeplacement=calcule(listDeplacement,unite.getPtDep()+1,hexagone);

		for(int i=0;i<20;i++){
			System.out.println("Test2:"+listDeplacement.get(i));
		}

	}


	private ArrayList<ArrayList<Integer>> calcule(ArrayList<ArrayList<Integer>> test, int ptDep, Hexagone hexagone){
		// fonction recursive mettant un a 1 un case du tableau teste si une unite e assez de point de depl	cement pour y aller

		if( ptDep>0){// premierement on me a 1 la case courante
			test.get(hexagone.getI()).remove(hexagone.getJ());
			test.get(hexagone.getI()).add(hexagone.getJ(),1);
			ptDep-=getMap().get(hexagone.getI()).get(hexagone.getJ());// on enlever les point de deplacement corepondant a la case



			// puis on remance l'algo sur les hexagone voisin
			if(hexagone.getI()>0){
				test=calcule(test, ptDep,hexagone.voisinHaut());
			}
			if(hexagone.getI()<19){
				test=calcule(test, ptDep,hexagone.voisinBah());
			}


//
			if (hexagone.getJ() > 0 && hexagone.getI() > 0) {
				test = calcule(test, ptDep,hexagone.voisinHautGauche());
			}
			if (hexagone.getJ() < 24 && hexagone.getI() > 0) {
				test = calcule(test, ptDep, hexagone.voisinHautdroit());
			}

			if ((hexagone.getJ() > 0 && hexagone.getI() < 19) || (hexagone.getI() == 19)) {
				test = calcule(test, ptDep,hexagone.voisinBahGauche());
			}
			if ((hexagone.getJ() < 24 && hexagone.getI() < 19) || (hexagone.getI() == 19 )) {
				test = calcule(test, ptDep, hexagone.voisinBahDroit());
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
}
