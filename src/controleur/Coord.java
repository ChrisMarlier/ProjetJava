package controleur;

public class Coord {
	
	private int i;
	private int j;
	
	//Transforme un numéro d'héxagone en cordonnée i et j
	public void numHexagoneToCoord(int hexagone) {
		
		this.j = hexagone%19;
		System.out.println(j);
		
		
	}

}
