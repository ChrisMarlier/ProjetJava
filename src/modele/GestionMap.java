package modele;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class GestionMap {

	private static ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
	
	
	public void chargementMap() {

		String file = "./Maps/test.txt"; //Chemin de la map � modifier. A CHANGER plus tard

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {

		    	ArrayList<String> ListString = new ArrayList<String>(Arrays.asList(line.split(" ")));//On insert notre ligne dans une liste de String en s�parant par un espace
		    
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


	public void calculeD�placementValide(Unit� unit�){

		ArrayList<ArrayList<Integer>> test = new ArrayList<ArrayList<Integer>>();


		for(int i=0;i<20;i++){
			ArrayList<Integer> ListInt = new ArrayList<Integer>();
			for(int j=0;j<24;j++){
				ListInt.add(0);
			}
			test.add(ListInt);
		}//cr�ation d'un tableau analogue a la map rempli de 0
		H�xagone h�xagone=new H�xagone(unit�.getCoordonn�eI(),unit�.getCoordonn��J());
		test=calcule(test,unit�.getPtDep()+1,h�xagone);

		for(int i=0;i<20;i++){
			System.out.println("Test2:"+test.get(i));
		}

	}


	private ArrayList<ArrayList<Integer>> calcule(ArrayList<ArrayList<Integer>> test, int ptDep, H�xagone h�xagone){
		// fonction r�cursive mettant un a 1 un case du tableau teste si une unit� � assez de point de d�pl	cement pour y aller

		if( ptDep>0){// premierement on me a 1 la case courante
			test.get(h�xagone.getI()).remove(h�xagone.getJ());
			test.get(h�xagone.getI()).add(h�xagone.getJ(),1);
			ptDep-=getMap().get(h�xagone.getI()).get(h�xagone.getJ());// on enlever les point de deplacement corepondant a la case



			// puis on remance l'algo sur les h�xagone voisin
			if(h�xagone.getI()>0){
				test=calcule(test, ptDep,h�xagone.voisinHaut());
			}
			if(h�xagone.getI()<19){
				test=calcule(test, ptDep,h�xagone.voisinBah());
			}


//
			if (h�xagone.getJ() > 0 && h�xagone.getI() > 0) {
				test = calcule(test, ptDep,h�xagone.voisinHautGauche());
			}
			if (h�xagone.getJ() < 24 && h�xagone.getI() > 0) {
				test = calcule(test, ptDep, h�xagone.voisinHautdroit());
			}

			if ((h�xagone.getJ() > 0 && h�xagone.getI() < 19) || (h�xagone.getI() == 19)) {
				test = calcule(test, ptDep,h�xagone.voisinBahGauche());
			}
			if ((h�xagone.getJ() < 24 && h�xagone.getI() < 19) || (h�xagone.getI() == 19 )) {
				test = calcule(test, ptDep, h�xagone.voisinBahDroit());
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