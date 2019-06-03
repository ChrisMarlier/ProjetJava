package Unite;

import modele.Unite;

public class Jeep extends Unite {

	public Jeep(int CoordonneeI, int CoordonneeJ) {
		super(50, 5, 3, 3, 3, CoordonneeI, CoordonneeJ, 2);

	}
	public Jeep(int PV,int CoordonneeI, int CoordonneeJ) {
		super(50, 5, 3, 3, 3, CoordonneeI, CoordonneeJ, 2);
		this.setPV(PV);
	}

}
