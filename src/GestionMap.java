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
}