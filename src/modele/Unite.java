package modele;
public class Unite {
    private int PV;
    private  int pvMax;
    private  int ptDep;
    private  int ptDepMax;
    private  int atk;
    private  int porteeAtk;
    private  int def;
    private  int CoordonneeI;
    private  int CoordonneeJ;

    public Unite(int PV,int pvMax,int  ptDep,int ptDepMax,int atk,int porteeAtk,int def,int CoordonneeI, int CoordonneeJ){
        this.PV=PV;
        this.pvMax=pvMax;
        this.ptDep=ptDep;
        this.ptDepMax=ptDepMax;
        this.atk=atk;
        this.porteeAtk=porteeAtk;
        this.def=def;
        this.CoordonneeI=CoordonneeI;
        this.CoordonneeJ=CoordonneeJ;
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

    public int getPorteeAtk() {
        return porteeAtk;
    }

    public void setPorteeAtk(int porteeAtk) {
        this.porteeAtk = porteeAtk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getCoordonneeI() {
        return CoordonneeI;
    }

    public void setCoordonneeI(int coordonneeI) {
        CoordonneeI = coordonneeI;
    }

    public int getCoordonneeJ() {
        return CoordonneeJ;
    }

    public void setCoordonneeJ(int coordonneeJ) {
        CoordonneeJ = coordonneeJ;
    }
}
