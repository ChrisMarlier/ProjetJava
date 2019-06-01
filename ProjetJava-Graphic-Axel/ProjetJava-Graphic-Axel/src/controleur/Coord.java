package controleur;

public class Coord {
	
	private int i;
	private int j;
	
	//Transforme un numéro d'héxagone en cordonnée i et j
	public void numHexagoneToCoord(int hexagone) {
		
		this.j = hexagone%19;
		this.i = (hexagone/19)%100;
		System.out.println("i: "+i+" j: "+j);
		
	}

	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}

}
