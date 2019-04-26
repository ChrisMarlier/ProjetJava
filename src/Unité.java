public class Unité {
    private int PV;
    private  int pvMax;
    private  int ptDep;
    private  int ptDepMax;
    private  int atk;
    private  int portéeAtk;
    private  int def;
    private  int CoordonnéeI;
    private  int CoordonnééJ;

    public Unité(int PV,int pvMax,int  ptDep,int ptDepMax,int atk,int portéeAtk,int def,int CoordonnéeI, int CoordonnééJ){
        this.PV=PV;
        this.pvMax=pvMax;
        this.ptDep=ptDep;
        this.ptDepMax=ptDepMax;
        this.atk=atk;
        this.portéeAtk=portéeAtk;
        this.def=def;
        this.CoordonnéeI=CoordonnéeI;
        this.CoordonnééJ=CoordonnééJ;
    }














    public int getPV() {
        return PV;
    }

    public void setPV(int PV) {
        this.PV = PV;
    }

    public int getPvMax() {
        return pvMax;
    }

    public void setPvMax(int pvMax) {
        this.pvMax = pvMax;
    }

    public int getPtDep() {
        return ptDep;
    }

    public void setPtDep(int ptDep) {
        this.ptDep = ptDep;
    }

    public int getPtDepMax() {
        return ptDepMax;
    }

    public void setPtDepMax(int ptDepMax) {
        this.ptDepMax = ptDepMax;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getPortéeAtk() {
        return portéeAtk;
    }

    public void setPortéeAtk(int portéeAtk) {
        this.portéeAtk = portéeAtk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getCoordonnéeI() {
        return CoordonnéeI;
    }

    public void setCoordonnéeI(int coordonnéeI) {
        CoordonnéeI = coordonnéeI;
    }

    public int getCoordonnééJ() {
        return CoordonnééJ;
    }

    public void setCoordonnééJ(int coordonnééJ) {
        CoordonnééJ = coordonnééJ;
    }
}
