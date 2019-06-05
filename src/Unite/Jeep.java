package Unite;

import java.io.Serializable;

import modele.Unite;

public class Jeep extends Unite implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2657838485078068152L;

	public Jeep(int CoordonneeI, int CoordonneeJ) {
		super(50, 5, 3, 3, 3, CoordonneeI, CoordonneeJ, 2);

	}

}
