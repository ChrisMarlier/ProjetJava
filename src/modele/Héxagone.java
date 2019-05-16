package modele;
public class H�xagone {
    private int i;
    private int j;

    public H�xagone(int i, int j){
        this.i=i;
        this.j=j;
    }
    //M�thodes permetant de renvoyer les hexagone voisin
    public H�xagone voisinHaut(){
        H�xagone h�xagone=new H�xagone(this.i,this.j);
        h�xagone.i--;

        return h�xagone;
    }
    public H�xagone voisinHautGauche(){
        H�xagone h�xagone=new H�xagone(this.i,this.j);
        if(h�xagone.j%2==1){
            h�xagone.i--;
            h�xagone.j--;
        }
        else {

            h�xagone.j--;
        }
        return h�xagone;
    }
    public H�xagone voisinHautdroit(){
                H�xagone h�xagone=new H�xagone(this.i,this.j);
        if(h�xagone.j%2==1){
            h�xagone.i--;
            h�xagone.j++;
        }
        else {
            h�xagone.j++;
        }

        return h�xagone;
    }
    public H�xagone voisinBah(){
        H�xagone h�xagone=new H�xagone(this.i,this.j);
        h�xagone.i++;

        return h�xagone;
    }
    public H�xagone voisinBahGauche(){
        H�xagone h�xagone=new H�xagone(this.i,this.j);
        if(h�xagone.j%2==1){

            h�xagone.j--;
        }
        else {
            h�xagone.i++;
            h�xagone.j--;
        }

        return h�xagone;
    }
    public H�xagone voisinBahDroit(){
        H�xagone h�xagone=new H�xagone(this.i,this.j);

        if(h�xagone.j%2==1){

            h�xagone.j++;
        }
        else {
            h�xagone.i++;
            h�xagone.j++;
        }
        return h�xagone;
    }





    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}