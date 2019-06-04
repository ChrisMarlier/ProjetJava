package Unite;

import modele.Unite;

public class Tank extends Unite{

	public Tank(int CoordonneeI, int CoordonneeJ) {
		
		super(100, 2, 80, 8, 8, CoordonneeI, CoordonneeJ,4);
	}
	public Tank(int PV,int CoordonneeI, int CoordonneeJ) {

		super(100, 2, 80, 8, 8, CoordonneeI, CoordonneeJ,4);
		this.setPV(PV);
	}
}
