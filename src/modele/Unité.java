package modele;
public class Unit� {
    private int PV;
    private  int pvMax;
    private  int ptDep;
    private  int ptDepMax;
    private  int atk;
    private  int port�eAtk;
    private  int def;
    private  int Coordonn�eI;
    private  int Coordonn��J;

    public Unit�(int PV,int pvMax,int  ptDep,int ptDepMax,int atk,int port�eAtk,int def,int Coordonn�eI, int Coordonn��J){
        this.PV=PV;
        this.pvMax=pvMax;
        this.ptDep=ptDep;
        this.ptDepMax=ptDepMax;
        this.atk=atk;
        this.port�eAtk=port�eAtk;
        this.def=def;
        this.Coordonn�eI=Coordonn�eI;
        this.Coordonn��J=Coordonn��J;
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

    public int getPort�eAtk() {
        return port�eAtk;
    }

    public void setPort�eAtk(int port�eAtk) {
        this.port�eAtk = port�eAtk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getCoordonn�eI() {
        return Coordonn�eI;
    }

    public void setCoordonn�eI(int coordonn�eI) {
        Coordonn�eI = coordonn�eI;
    }

    public int getCoordonn��J() {
        return Coordonn��J;
    }

    public void setCoordonn��J(int coordonn��J) {
        Coordonn��J = coordonn��J;
    }
}