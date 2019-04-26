import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
public class GestionMap {

	ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();

	
	public void chargementMap() {

		String file = "./Maps/test.txt"; //Chemin de la map à modifier. A CHANGER plus tard

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {

		    	ArrayList<String> ListString = new ArrayList<String>(Arrays.asList(line.split(" ")));//On insert notre ligne dans une liste de String en séparant par un espace
		    
		    	ArrayList<Integer> ListInt = new ArrayList<Integer>();
		    	
		    	for(int i=0;i<ListString.size();i++) { //On parcourt toute la liste de String pour parser en int et ajouter a notre liste de int
		    		ListInt.add(Integer.parseInt(ListString.get(i)));
		    		
		    	}
		    	System.out.println(ListInt); //DEBOGAGE
		    	map.add(ListInt); //Et on ajoute la liste a notre map
		    }
		}
	      catch (Exception e) {
	            e.printStackTrace();
	        }

	}


	public void calculeDéplacementValide(Unité unité){

		ArrayList<ArrayList<Integer>> test = new ArrayList<ArrayList<Integer>>();


		for(int i=0;i<20;i++){
			ArrayList<Integer> ListInt = new ArrayList<Integer>();
			for(int j=0;j<24;j++){
				ListInt.add(0);
			}
			test.add(ListInt);
		}
		Héxagone héxagone=new Héxagone(unité.getCoordonnéeI(),unité.getCoordonnééJ());
		test=calcule(test,unité.getPtDep()+1,héxagone);

		for(int i=0;i<20;i++){
			System.out.println(test.get(i));
		}

	}
	private ArrayList<ArrayList<Integer>> calcule(ArrayList<ArrayList<Integer>> test, int ptDep, Héxagone héxagone){


		if( ptDep>0){
			test.get(héxagone.getI()).remove(héxagone.getJ());
			test.get(héxagone.getI()).add(héxagone.getJ(),1);
			ptDep-=map.get(héxagone.getI()).get(héxagone.getJ());
			System.out.println(ptDep+""+héxagone.getI()+""+héxagone.getJ()+"\n");



			if(héxagone.getI()>0){
				test=calcule(test, ptDep,héxagone.voisinHaut());
			}
			if(héxagone.getI()<19){
				test=calcule(test, ptDep,héxagone.voisinBah());
			}


//
			if (héxagone.getJ() > 0 && héxagone.getI() > 0) {
				test = calcule(test, ptDep,héxagone.voisinHautGauche());
			}
			if (héxagone.getJ() < 24 && héxagone.getI() > 0) {
				test = calcule(test, ptDep, héxagone.voisinHautdroit());
			}

			if ((héxagone.getJ() > 0 && héxagone.getI() < 19) || (héxagone.getI() == 19)) {
				test = calcule(test, ptDep,héxagone.voisinBahGauche());
			}
			if ((héxagone.getJ() < 24 && héxagone.getI() < 19) || (héxagone.getI() == 19 )) {
				test = calcule(test, ptDep, héxagone.voisinBahDroit());
			}
			}



		return test;
	}
}