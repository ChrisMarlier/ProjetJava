
public class Main {

	public static void main(String[] args) {

		GestionMap test = new GestionMap();
		test.chargementMap();

		Unité unité=new Unité(10,10,5,5,10,10,10,0,3);
		test.calculeDéplacementValide(unité);
	}

}
