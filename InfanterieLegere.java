package Unite;

import modele.Unite;

public class InfanterieLegere extends Unite {

	public InfanterieLegere(int CoordonneeI, int CoordonneeJ) {
		super(50, 4, 3, 3, 2, CoordonneeI, CoordonneeJ, 1);

	}
	public InfanterieLegere(int PV, int CoordonneeI, int CoordonneeJ) {
		super(50, 4, 3, 3, 2, CoordonneeI, CoordonneeJ, 1);
		this.setPV(PV);
	}

}
